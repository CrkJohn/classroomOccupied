package lab.eci.ocupados.samples.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import java.util.Optional;

import lab.eci.ocupados.persistence.ComputerDAO;
import lab.eci.ocupados.persistence.mybatisimpl.MyBATISComputadorDAO;
import lab.eci.ocupados.samples.services.impl.*;

public class ServicesOccupiedClassroomFactory {

   private static ServicesOccupiedClassroomFactory instance = new ServicesOccupiedClassroomFactory();

   private static Optional<Injector> optInjector;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
               //install(JdbcHelper.MySQL); 
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(ComputerDAO.class).to(MyBATISComputadorDAO.class);
               bind(ServicesOccupiedClassroom.class).to(ServicesOccupiedClassroomImpl.class);
           }
       });
   }

   private ServicesOccupiedClassroomFactory(){
       optInjector = Optional.empty();
   }

   public ServicesOccupiedClassroom getServicesOccupiedClassroom(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServicesOccupiedClassroom.class);
   }




   public static ServicesOccupiedClassroomFactory getInstance(){
       return instance;
   }

}