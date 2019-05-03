package lab.eci.ocupados.persistence.mybatisimpl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import lab.eci.ocupados.entites.*;
import lab.eci.ocupados.persistence.ComputerDAO;
import lab.eci.ocupados.persistence.mybatisimpl.mappers.ComputerMapper;

public class MyBATISComputadorDAO implements ComputerDAO{

	
	@Inject
	private ComputerMapper computadorMapper;
	
	public ArrayList<Computer> getComputadoresBySalon(String salon) {
		ArrayList<String> list = new ArrayList<String>();
		return computadorMapper.getComputadoresBySalon(salon);
		
	}

}