package ar.com.ada.tp.component.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataCleaner implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataCleaner.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Data Cleaner initializer...\n");

//            // Para borrar los registros de las tablas y por eso las elimine de Categorydata
//            companyRepresentativeRepository.deleteAll();
//            companyRepresentativeRepository.resetAutoincrementValue();
//
        }
    }
}