package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Participant;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParticipantRepositoryTest {

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Test
    public void whenSaveThenReturnAParticipantWithId(){
        //GIVEN
        Participant participant = new Participant()
                .setName("Lorena")
                .setLastName("Gaudio")
                .setBirthday(LocalDate.parse("1988-05-23"))
                .setGender("Femenino")
                .setAddress("Lomas de Zamora");

        //WHEN
        Participant saved = participantRepository.save(participant);

        //THEN
        assertNotNull(saved.getId());
        assertNotNull(saved.getName());
        assertNotNull(saved.getLastName());
    }

}