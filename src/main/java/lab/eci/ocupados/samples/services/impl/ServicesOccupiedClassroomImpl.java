package lab.eci.ocupados.samples.services.impl;

import java.util.List;

import com.google.inject.Inject;

import lab.eci.ocupados.entites.Computer;
import lab.eci.ocupados.persistence.ComputerDAO;
import lab.eci.ocupados.samples.services.ServicesOccupiedClassroom;


public class ServicesOccupiedClassroomImpl implements ServicesOccupiedClassroom {

    @Inject
    private ComputerDAO computadorDAO;

    public List<Computer> getComputadoresBySalon(String salon) {		
		return computadorDAO.getComputadoresBySalon(salon);
	}

}