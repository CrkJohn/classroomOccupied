package lab.eci.ocupados.samples.services;

import java.util.List;

import lab.eci.ocupados.entites.Computer;

public interface ServicesOccupiedClassroom {
	
    public List<Computer> getComputadoresBySalon(String salon);
	
}