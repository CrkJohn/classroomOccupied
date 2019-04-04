package lab.eci.ocupados.persistence;

import java.util.*;
import lab.eci.ocupados.entites.*;

public interface  ComputerDAO {
    
    public ArrayList<Computer> getComputadoresBySalon(String salon);
    
}
