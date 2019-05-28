package lab.eci.ocupados.gui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lab.eci.ocupados.samples.services.ServicesOccupiedClassroom;
import lab.eci.ocupados.samples.services.ServicesOccupiedClassroomFactory;
import static lab.eci.ocupados.samples.services.client.MyBatisExample.getSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PanelMain extends JFrame implements Runnable {

    private CardLayout layout;
    private JPanel principal;

    private static B0 b0;
    private static Plataformas plataformas;
    private static Redes redes;
    private static IngSoftware ingSoftware;
    private static SqlSessionFactory sessionfact = getSqlSessionFactory();
    private static SqlSession sqlss = sessionfact.openSession();
    private static ServicesOccupiedClassroomFactory servicesFactory = ServicesOccupiedClassroomFactory.getInstance();
    public static ServicesOccupiedClassroom services = servicesFactory.getServicesOccupiedClassroom();
    public String salones[] = {"B0", "plataformas", "redes", "ingSoftware"};
    public static LoadData salonesObj[];
    public Long time = System.nanoTime();

    public PanelMain() {
        prepareElementos();
        prepareAcciones();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

    }

    private void prepareElementos() {
        setTitle("Salones ocupados");
        layout = new CardLayout();
        this.getContentPane().setLayout(new CardLayout());

        principal = new JPanel(layout);
        setLocationRelativeTo(null);
        principal = new JPanel(layout);
        add(principal);

        b0 = new B0(this);
        plataformas = new Plataformas(this);
        redes = new Redes(this);
        ingSoftware = new IngSoftware(this);
        
        principal.add(b0, "B0");
        principal.add(plataformas, "plataformas");
        principal.add(redes,"redes");
        principal.add(ingSoftware,"ingSoftware");
        centro();
        salonesObj = new LoadData[4];
        salonesObj[0] = b0;
        salonesObj[1] = plataformas;
        salonesObj[2] = redes;
        salonesObj[3] = ingSoftware;
       
        setResizable(false);
        IniciarTA();
        setFocusable(false);
    }

    private void prepareAcciones() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
    }

    public void salir() {
        // System.out.println(getWidth() + " " + getHeight());
        if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de salir?", "Salir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setVisible(false);
            System.exit(0);

        }
    }

    private void IniciarTA() {
        irPanel("b0");
    }

    public void irPanel(String src) {
        layout.show(principal, src);
    }

    private void centro() {
        int xEsquina = 872, yEsquina = 600;
        setSize(xEsquina, yEsquina);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        PanelMain GUI = new PanelMain();
        GUI.setVisible(true);
        Thread t1 = new Thread(GUI);
        t1.start();
    }

    @Override
    public void run() {
        int i = 1;
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println("AXA " + i);
                System.out.println(salonesObj[i].getClass());
                salonesObj[i].reload();
                irPanel(salones[i]);
                i = (i + 1) % 4; //;salones.length;
            }
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(PanelMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
