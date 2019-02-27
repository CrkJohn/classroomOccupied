package lab.eci.ocupados.persistence.mybatisimpl.mappers;

import lab.eci.ocupados.entites.Computador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface ComputadorMapper{
    
    public ArrayList<Computador> getComputadores();    
}