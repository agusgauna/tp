package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Category;
import ar.com.ada.tp.model.repository.CategoryRepository;
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
public class CategoryLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Category initial data...");

            List<Category> categoryList = Arrays.asList(
                    new Category()
                            .setId(1L)
                            .setCategory("Tecnologia"),
                    new Category()
                            .setId(2L)
                            .setCategory("Cocina"),
                    new Category()
                            .setId(3L)
                            .setCategory("Fotografia")
            );
            categoryRepository.saveAll(categoryList);
        }
    }
}
