package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.ParticipantDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParticipantControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldBeCreatedANewParticipant() {
        //GIVEN
        String url = "http://localhost:" + port + "/participants";

        //requestBody
        ParticipantDto participant = new ParticipantDto()
                .setId(1L)
                .setName("Lorena Maria")
                .setLastName("Gaudio")
                .setBirthday(LocalDate.parse("1988-05-23"))
                .setAddress("Lomas de Zamora");

        HttpEntity<ParticipantDto> request = new HttpEntity<>(participant);

        //WHEN
        ResponseEntity<ParticipantDto> response = testRestTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<ParticipantDto>() {
                }
        );

        //THEN

        //FORMA A: expected vs actual
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());

        //FORMA B: by method isEqualTo
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isEqualTo(1);

    }
}