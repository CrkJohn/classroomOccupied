package lab.eci.ocupados.persistence.mybatisimpl;

import java.util.ArrayList;

import com.google.inject.Inject;
import lab.eci.ocupados.entites.*;
import lab.eci.ocupados.persistence.ComputadorDAO;
import lab.eci.ocupados.persistence.mybatisimpl.mappers.ComputadorMapper;

public class MyBATISComputadorDAO implements ComputadorDAO{

	
	@Inject
	private ComputadorMapper computadorMapper;
	
	public ArrayList<Computador> getComputadores() {
		return computadorMapper.getComputadores();
	}

}