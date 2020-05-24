package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ParticipantMapper;
import ar.com.ada.tp.model.repository.ParticipantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParticipantServicesTest {

    private final ParticipantMapper participantMapper = ParticipantMapper.MAPPER;

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private CycleAvoidingMappingContext context;

    @InjectMocks
    private ParticipantServices participantServices;

    @Test
    public void whenFindThenReturnParticipantList() {
        //GIVEN
        Participant dto = new Participant()
                .setId(1L)
                .setName("Lorena")
                .setLastName("Gaudio")
                .setBirthday(LocalDate.parse("1988-05-23"))
                .setGender("Femenino")
                .setAddress("Lomas de Zamora");
        Participant dto2 = new Participant()
                .setId(2L)
                .setName("Mauricio")
                .setLastName("Fernandez")
                .setBirthday(LocalDate.parse("1970-04-05"))
                .setGender("Masculino")
                .setAddress("San Miguel");

        List<Participant> expectedParticipantList = Arrays.asList(dto, dto2);
        //doReturn(expectedParticipantList).when(participantRepository).findAll();
        when(participantRepository.findAll()).thenReturn(expectedParticipantList);

        //WHEN
        List<ParticipantDto> participantDtos = participantServices.findAll();

        //THEN
        assertThat(participantDtos.size()).isEqualTo(2);
        assertThat(participantDtos.get(0).getName()).isEqualTo("Lorena");
        assertThat(participantDtos.get(0).getLastName()).isEqualTo("Gaudio");
    }

    @Test
    public void whenSaveReturnParticipantDtoSaved() {
        //GIVEN
        Participant participant = new Participant()
                .setId(1L)
                .setName("Lorena")
                .setLastName("Gaudio")
                .setBirthday(LocalDate.parse("1988-05-23"))
                .setGender("Femenino")
                .setAddress("Lomas de Zamora");

        when(participantRepository.save(any(Participant.class))).thenReturn(participant);
        ParticipantDto dto = new ParticipantDto();

        //WHEN
        ParticipantDto dtoSaved = participantServices.save(dto);

        //THEN
        assertThat(dtoSaved.getId()).isEqualTo(1);

    }
}