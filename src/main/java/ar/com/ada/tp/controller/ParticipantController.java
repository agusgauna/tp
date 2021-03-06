package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.services.ParticipantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired @Qualifier("participantServices")
    private ParticipantServices participantServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllParticipant() {
        List<ParticipantDto> all = participantServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getParticipantById(@PathVariable Long id){
        ParticipantDto participantById = participantServices.findParticipantById(id);
        return ResponseEntity.ok(participantById);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping({"","/"})
    public ResponseEntity addNewParticipant (@Valid @RequestBody ParticipantDto participantDto) throws URISyntaxException {
        ParticipantDto participantSaved = participantServices.save(participantDto);
        return ResponseEntity.created(new URI("/participants/" + participantSaved.getId()))
                .body(participantSaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateParticipantById(@Valid @RequestBody ParticipantDto participantDto, @PathVariable Long id){
        ParticipantDto participantUpdated = participantServices.updateParticipant(participantDto, id);
        return ResponseEntity.ok(participantUpdated);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteParticipant (@PathVariable Long id){
        participantServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping({"{participantId}/informations/{informationId}","{participantId}/informations/{informationId}/"})
    public ResponseEntity addInformationToParticipant(@PathVariable Long participantId, @PathVariable Long informationId) {
        ParticipantDto participantDtoWithNewInformation = participantServices.addInformationToParticipant(informationId, participantId);
        return ResponseEntity.ok(participantDtoWithNewInformation);
    }

}
