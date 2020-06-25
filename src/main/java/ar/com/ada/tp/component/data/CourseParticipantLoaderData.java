package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.CourseParticipant;
import ar.com.ada.tp.model.entity.CourseParticipantId;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.repository.CourseParticipantRepository;
import ar.com.ada.tp.model.repository.CourseRepository;
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
import java.util.Arrays;
import java.util.List;

@Component
@Order(11)
public class CourseParticipantLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseParticipantLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("courseParticipantRepository")
    private CourseParticipantRepository courseParticipantRepository;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading CourseParticipant initial data...");

            Course courseOne = courseRepository.findById(1L).get();
            Course courseTwo = courseRepository.findById(2L).get();

            Participant participantOne = participantRepository.findById(1L).get();
            Participant participantTwo = participantRepository.findById(2L).get();

            CourseParticipantId courseParticipantIdOne = new CourseParticipantId()
                    .setCourseId(courseOne.getId())
                    .setParticipantId(participantOne.getId());
            CourseParticipantId courseParticipantIdTwo = new CourseParticipantId()
                    .setCourseId(courseTwo.getId())
                    .setParticipantId(participantTwo.getId());

            List<CourseParticipant> courseParticipantList = Arrays.asList(
                    new CourseParticipant()
                            .setId(courseParticipantIdOne)
                            .setCourse(courseOne)
                            .setParticipant(participantOne)
                            .setRequestType("Beca"),
                    new CourseParticipant()
                            .setId(courseParticipantIdTwo)
                            .setCourse(courseTwo)
                            .setParticipant(participantTwo)
                            .setRequestType("Pago")
            );
            courseParticipantRepository.saveAll(courseParticipantList);
        }
    }
}
