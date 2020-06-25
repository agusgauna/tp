package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.repository.CourseRepository;
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
@Order(9)
public class CourseLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Course initial data...");

            List<Course> courseList = Arrays.asList(
                    new Course()
                            .setId(1L)
                            .setName("Desarrollo Backend")
                            .setDescription("Descripcion 1")
                            .setCost(80000)
                            .setQuota(50)
                            .setScholarship(20)
                            .setCountInscription(10)
                            .setCountQuota(5)
                            .setDifference(35),
            new Course()
                    .setId(2L)
                    .setName("Desarrollo Frontend")
                    .setDescription("Descripcion 2")
                    .setCost(80000)
                    .setQuota(50)
                    .setScholarship(20)
                    .setCountInscription(20)
                    .setCountQuota(5)
                    .setDifference(25)
            );
            courseRepository.saveAll(courseList);
        }
    }
}
