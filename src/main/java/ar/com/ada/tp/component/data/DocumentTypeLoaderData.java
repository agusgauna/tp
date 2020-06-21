package ar.com.ada.tp.component.data;

import ar.com.ada.tp.model.entity.DocumentType;
import ar.com.ada.tp.model.repository.DocumentTypeRepository;
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
public class DocumentTypeLoaderData implements ApplicationRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTypeLoaderData.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("documentTypeRepository")
    private DocumentTypeRepository documentTypeRepository;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading DocumentType initial data...");

            List<DocumentType> documentTypeList = Arrays.asList(
                    new DocumentType()
                            .setType("DNI"),
                    new DocumentType()
                            .setType("Pasaporte")
            );
            documentTypeRepository.saveAll(documentTypeList);
        }
    }
}
