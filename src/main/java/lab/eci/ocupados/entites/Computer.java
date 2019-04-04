package lab.eci.ocupados.entites;



import java.sql.Date;

public class Computer {
    
    String nombreEquipo;
    Date logOn;
    Date logOff;
    String ip;
    
    public Computer(){
    }
    
    public Computer(String nombreEquipo, Date logOn, Date logOff, String ip) {
        this.nombreEquipo = nombreEquipo;
        this.logOn = logOn;
        this.logOff = logOff;
        this.ip = ip;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

	public Date getLogOn() {
        return logOn;
    }

    public void setLogOn(Date logOn) {
        this.logOn = logOn;
    }

    public Date getLogOff() {
        return logOff;
    }

    public void setLogOff(Date logOff) {
        this.logOff = logOff;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    @Override
	public String toString() {
		return "Computer [nombreEquipo=" + nombreEquipo + ", logOn=" + logOn + ", logOff=" + logOff + ", ip=" + ip
				+ "]";
	}
	
}
