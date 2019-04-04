package lab.eci.ocupados.persistence.mybatisimpl.mappers;

import lab.eci.ocupados.entites.Computer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ComputerMapper{
    
    public ArrayList<Computer> getComputadoresBySalon(@Param("salon") String salon);
    
}