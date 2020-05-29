package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired @Qualifier("companyServices")
    private CompanyServices companyServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllCompany() {
        List<CompanyDto> all = companyServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getCompanyById(@PathVariable Long id){
        CompanyDto companyById = companyServices.findCompanyById(id);
        return ResponseEntity.ok(companyById);
    }

    @PostMapping({"","/"})
    public ResponseEntity addNewCompany (@Valid @RequestBody CompanyDto companyDto) {
        CompanyDto companySaved = companyServices.save(companyDto);
        return ResponseEntity.ok(companySaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateCompanyById(@Valid @RequestBody CompanyDto companyDto, @PathVariable Long id){
        CompanyDto companyUpdated = companyServices.updateCompany(companyDto, id);
        return ResponseEntity.ok(companyUpdated);
    }

    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteCompany (@PathVariable Long id){
        companyServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
