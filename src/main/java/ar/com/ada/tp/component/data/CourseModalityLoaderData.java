package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.CourseModality;
import ar.com.ada.tp.model.repository.CourseModalityRepository;
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
@Order(4)
public class CourseModalityLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseModalityLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("courseModalityRepository")
    private CourseModalityRepository courseModalityRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading CourseModality initial data...");

            List<CourseModality> courseModalityList = Arrays.asList(
                    new CourseModality()
                            .setId(1L)
                            .setModality("Online"),
                    new CourseModality()
                            .setId(1L)
                            .setModality("Presencial")
            );
            courseModalityRepository.saveAll(courseModalityList);
        }
    }
}
