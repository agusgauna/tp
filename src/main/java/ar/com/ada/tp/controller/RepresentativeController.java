package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.RepresentativeDto;
import ar.com.ada.tp.services.RepresentativeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/representatives")
public class RepresentativeController {

    @Autowired @Qualifier("representativeServices")
    private RepresentativeServices representativeServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllRepresentative() {
        List<RepresentativeDto> all = representativeServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getRepresentativeById(@PathVariable Long id){
        RepresentativeDto representativeById = representativeServices.findRepresentativeById(id);
        return ResponseEntity.ok(representativeById);
    }

    @PostMapping({"","/"})
    public ResponseEntity addNewRepresentative (@Valid @RequestBody RepresentativeDto representativeDto) {
        RepresentativeDto representativeSaved = representativeServices.save(representativeDto);
        return ResponseEntity.ok(representativeSaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateRepresentativeById(@Valid @RequestBody RepresentativeDto representativeDto, @PathVariable Long id){
        RepresentativeDto representativeUpdated = representativeServices.updateRepresentative(representativeDto, id);
        return ResponseEntity.ok(representativeUpdated);
    }

    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteRepresentative (@PathVariable Long id){
        representativeServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
