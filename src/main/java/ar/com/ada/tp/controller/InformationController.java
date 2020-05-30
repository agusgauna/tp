package ar.com.ada.tp.controller;


import ar.com.ada.tp.model.dto.InformationDto;
import ar.com.ada.tp.services.InformationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/informations")
public class InformationController {

    @Autowired @Qualifier("informationServices")
    private InformationServices informationServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllInformation() {
        List<InformationDto> all = informationServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getInformationById(@PathVariable Long id){
        InformationDto informationById = informationServices.findInformationById(id);
        return ResponseEntity.ok(informationById);
    }

    @PostMapping({"","/"})
    public ResponseEntity addNewInformation (@Valid @RequestBody InformationDto informationDto) {
        InformationDto informationSaved = informationServices.save(informationDto);
        return ResponseEntity.ok(informationSaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateInformationById(@Valid @RequestBody InformationDto informationDto, @PathVariable Long id){
        InformationDto informationUpdated = informationServices.updateInformation(informationDto, id);
        return ResponseEntity.ok(informationUpdated);
    }

    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteInformation (@PathVariable Long id){
        informationServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
