package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.CompanyType;
import ar.com.ada.tp.model.repository.CompanyTypeRepository;
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
@Order(1)
public class CompanyTypeLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyTypeLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("companyTypeRepository")
    private CompanyTypeRepository companyTypeRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading CompanyType initial data...");

            List<CompanyType> companyTypeList = Arrays.asList(
                    new CompanyType()
                            .setId(1L)
                            .setType("Sociedad Anonima"),
                    new CompanyType()
                            .setId(2L)
                            .setType("ONG")
            );
            companyTypeRepository.saveAll(companyTypeList);
        }
    }
}
