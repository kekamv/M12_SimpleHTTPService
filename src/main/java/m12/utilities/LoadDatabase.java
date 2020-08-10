package m12.utilities;


import m12.model.Employee;
import m12.model.Role;
import m12.repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LoadDatabase {

    private static final Logger log= LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDB (EmployeeRepository repository){
        return args -> {
            log.info("Preloading" + repository.save(new Employee("Andrea_First", Role.RESEARCHER)));
            log.info("Preloading" + repository.save(new Employee("Sean_Second", Role.MKTGASSISTANCE)));
            log.info("Preloading" + repository.save(new Employee("Toni_Third", Role.RECEPTIONIST)));
            log.info("Preloading" + repository.save(new Employee("Laia_Fourth", Role.DEVELOPER)));
            log.info("Preloading" +  repository.save(new Employee("Toni_Fifth", Role.DEVELOPER)));
        };

    }
}
