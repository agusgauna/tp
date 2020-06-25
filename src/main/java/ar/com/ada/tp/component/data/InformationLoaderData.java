package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.repository.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
@Order(3)
public class InformationLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(InformationLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("informationRepository")
    private InformationRepository informationRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Information initial data...");

            List<Information> informationList = Arrays.asList(
                    new Information()
                            .setId(1L)
                            .setStudy(Boolean.FALSE)
                            .setWork(Boolean.TRUE)
                            .setHasIncome(Boolean.TRUE)
                            .setHowMuch(40000)
                            .setInCharge(Boolean.FALSE)
                            .setHowMany(0),
                    new Information()
                            .setId(2L)
                            .setStudy(Boolean.TRUE)
                            .setWork(Boolean.FALSE)
                            .setHasIncome(Boolean.FALSE)
                            .setHowMuch(0)
                            .setInCharge(Boolean.FALSE)
                            .setHowMany(0)
            );
            informationRepository.saveAll(informationList);
        }
    }
}
