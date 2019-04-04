package lab.eci.ocupados.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lab.eci.ocupados.entites.Computer;
import lab.eci.ocupados.persistence.mybatisimpl.mappers.ComputerMapper;
import lab.eci.ocupados.samples.services.ServicesOccupiedClassroom;
import lab.eci.ocupados.samples.services.ServicesOccupiedClassroomFactory;

public class MyBatisExample {

	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		  SqlSessionFactory sessionfact = getSqlSessionFactory();
	      SqlSession sqlss = sessionfact.openSession();
	      
	      ServicesOccupiedClassroomFactory servicesFactory = ServicesOccupiedClassroomFactory.getInstance();
	      ServicesOccupiedClassroom services = servicesFactory.getServicesOccupiedClassroom();
	      ComputerMapper compMapper = sqlss.getMapper(ComputerMapper.class);
	      
	      try {
	    	  List<Computer> computers = compMapper.getComputadoresBySalon("B0");
	    	  for (Computer computer : computers) {
				System.out.println(computer);
	    	  }
	      }catch(Exception e) {
	    	  System.err.println(e.getMessage());
	      }
	}
}
