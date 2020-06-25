package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.ParticipantGender;
import ar.com.ada.tp.model.repository.ParticipantGenderRepository;
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
@Order(2)
public class ParticipantGenderLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantGenderLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("participantGenderRepository")
    private ParticipantGenderRepository participantGenderRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading ParticipantGender initial data...");

            List<ParticipantGender> participantGenderList = Arrays.asList(
                    new ParticipantGender()
                            .setId(1L)
                            .setGender("Femenino"),
                    new ParticipantGender()
                            .setId(2L)
                            .setGender("Masculino")
            );
            participantGenderRepository.saveAll(participantGenderList);
        }
    }
}
