package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Participant;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParticipantRepositoryTest {

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Test @Order(0)
    public void whenSaveThenReturnAParticipantWithId(){
        //GIVEN
        Participant participant = new Participant()
                .setName("Lorena")
                .setLastName("Gaudio")
                .setBirthday(LocalDate.parse("1988-05-23"))
                .setAddress("Lomas de Zamora");

        //WHEN
        Participant saved = participantRepository.save(participant);

        //THEN
        assertNotNull(saved.getId());
        assertNotNull(saved.getName());
        assertNotNull(saved.getLastName());
    }

    @Test @Order(1)
    public void whenFindByNameAndLastNameThenReturnParticipant() {
        //GIVEN
        String name = "Lorena";
        String lastName = "Gaudio";

        //WHEN
        Optional<Participant> byNameAndLastName = participantRepository.findByNameAndLastName(name, lastName);
        Participant participant = byNameAndLastName.get();

        //THEN
        assertEquals(true, byNameAndLastName.isPresent());
        assertEquals(name, participant.getName());
        assertEquals(lastName, participant.getLastName());
    }

    @Test @Order(2)
    public void whenFindAllThenReturnParticipantList() {
        //GIVEN

        //WHEN
        List<Participant> participantList = participantRepository.findAll();

        //THEN
        assertThat(participantList).hasSizeGreaterThan(0);
    }

}