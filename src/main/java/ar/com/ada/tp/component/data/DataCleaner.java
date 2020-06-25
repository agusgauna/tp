package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.repository.*;
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

@Component
@Order(0)
public class DataCleaner implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataCleaner.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("companyTypeRepository")
    private CompanyTypeRepository companyTypeRepository;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("courseModalityRepository")
    private CourseModalityRepository courseModalityRepository;

    @Autowired @Qualifier("courseParticipantRepository")
    private CourseParticipantRepository courseParticipantRepository;

    @Autowired @Qualifier("documentTypeRepository")
    private DocumentTypeRepository documentTypeRepository;

    @Autowired @Qualifier("informationRepository")
    private InformationRepository informationRepository;

    @Autowired @Qualifier("participantGenderRepository")
    private ParticipantGenderRepository participantGenderRepository;

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Data Cleaner initializer...\n");

            // Para borrar los registros de las tablas y por eso las elimine de Categorydata
            courseParticipantRepository.deleteAll();
            courseParticipantRepository.resetAutoincrementValue();
            participantRepository.deleteAll();
            participantRepository.resetAutoincrementValue();
            informationRepository.deleteAll();
            informationRepository.resetAutoincrementValue();
            participantGenderRepository.deleteAll();
            participantGenderRepository.resetAutoincrementValue();
            documentTypeRepository.deleteAll();
            documentTypeRepository.resetAutoincrementValue();
            representativeRepository.deleteAll();
            representativeRepository.resetAutoincrementValue();
            courseRepository.deleteAll();
            courseRepository.resetAutoincrementValue();
            courseModalityRepository.deleteAll();
            courseModalityRepository.resetAutoincrementValue();
            companyRepository.deleteAll();
            companyRepository.resetAutoincrementValue();
            categoryRepository.deleteAll();
            categoryRepository.resetAutoincrementValue();




        }
    }
}