package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Representative;
import ar.com.ada.tp.model.repository.RepresentativeRepository;
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
@Order(6)
public class RepresentativeLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepresentativeLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Representative initial data...");

            List<Representative> representativeList = Arrays.asList(
                    new Representative()
                            .setId(1L)
                            .setName("Marcelo")
                            .setLastName("Fernandez")
                            .setDocument(20156814).setPosition("Asesor")
                            .setEmail("marcefernandez@gmail.com"),
                    new Representative()
                            .setId(2L)
                            .setName("Cristina")
                            .setLastName("Zapata")
                            .setDocument(28168414)
                            .setPosition("Asesor")
                            .setEmail("criszapata@gmail.com")
            );
            representativeRepository.saveAll(representativeList);
        }
    }
}
