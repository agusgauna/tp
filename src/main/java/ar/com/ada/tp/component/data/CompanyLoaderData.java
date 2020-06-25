package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.repository.CompanyRepository;
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
import java.time.Year;
import java.util.Arrays;
import java.util.List;

@Component
@Order(7)
public class CompanyLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading TypeCategoryCompany initial data...");

            List<Company> companyList = Arrays.asList(
                    new Company()
                            .setId(1L)
                            .setName("Ada")
                            .setCuil(33405221)
                            .setAddress("Lomas de Zamora")
                            .setYear(Year.of(2001))
                            .setTelephone(55774422),
                    new Company()
                            .setId(2L)
                            .setName("Instituto Gato Dumas")
                            .setCuil(33405221)
                            .setAddress("Adrogue")
                            .setYear(Year.of(2010))
                            .setTelephone(55771540)
            );
            companyRepository.saveAll(companyList);
        }
    }
}
