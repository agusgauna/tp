package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.CourseParticipant;
import ar.com.ada.tp.model.repository.CourseParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class CourseParticipantLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseParticipantLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("courseParticipantRepository")
    private CourseParticipantRepository courseParticipantRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading CourseParticipant initial data...");

            List<CourseParticipant> courseParticipantList = Arrays.asList(
                    new CourseParticipant()
                            .setRequestType("Beca"),
                    new CourseParticipant()
                            .setRequestType("Pago")
            );
            courseParticipantRepository.saveAll(courseParticipantList);
        }
    }
}
