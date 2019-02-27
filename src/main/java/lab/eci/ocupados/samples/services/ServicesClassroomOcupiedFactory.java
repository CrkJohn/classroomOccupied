package lab.eci.ocupados.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import java.util.Optional;
import static com.google.inject.Guice.createInjector;
import lab.eci.ocupados.persistence.ComputadorDAO;
import lab.eci.ocupados.persistence.mybatisimpl.MyBATISComputadorDAO;
import lab.eci.ocupados.samples.services.impl.*;

public class ServicesClassroomOcupiedFactory {

   private static ServicesClassroomOcupiedFactory instance = new ServicesClassroomOcupiedFactory();

   private static Optional<Injector> optInjector;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(ComputadorDAO.class).to(MyBATISComputadorDAO.class);
               bind(ServicesClassroomOcupied.class).to(ServicesClassroomOcupiedImpl.class);
           }
       });
   }

   private ServicesClassroomOcupiedFactory(){
       optInjector = Optional.empty();
   }

   public ServicesClassroomOcupied getServiciosAlquiler(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServicesClassroomOcupied.class);
   }


   public ServicesClassroomOcupied getServiciosAlquilerTesting(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
       }

       return optInjector.get().getInstance(ServicesClassroomOcupied.class);
   }


   public static ServicesClassroomOcupiedFactory getInstance(){
       return instance;
   }

}