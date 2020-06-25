package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.repository.ParticipantRepository;
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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Order(10)
public class ParticipantLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Participant initial data...");

            List<Participant> participantList = Arrays.asList(
                    new Participant()
                            .setId(1L)
                            .setName("Patricia")
                            .setLastName("Marbella")
                            .setBirthday(LocalDate.parse("1969-02-10"))
                            .setAddress("Avellaneda"),
                    new Participant()
                            .setId(2L)
                            .setName("Horacio")
                            .setLastName("Marquez")
                            .setBirthday(LocalDate.parse("1990-01-30"))
                            .setAddress("Rafael Calzada")
            );
            participantRepository.saveAll(participantList);
        }
    }
}
