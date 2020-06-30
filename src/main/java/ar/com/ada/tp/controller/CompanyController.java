package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.services.CompanyServices;
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
@RequestMapping("/companies")
public class CompanyController {

    @Autowired @Qualifier("companyServices")
    private CompanyServices companyServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllCompanies() {
        List<CompanyDto> all = companyServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getCompanyById(@PathVariable Long id){
        CompanyDto companyById = companyServices.findCompanyById(id);
        return ResponseEntity.ok(companyById);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping({"","/"})
    public ResponseEntity addNewCompany (@Valid @RequestBody CompanyDto companyDto) throws URISyntaxException {
        CompanyDto companySaved = companyServices.save(companyDto);
        return ResponseEntity.created(new URI("/companies/" + companyDto.getId()))
                .body(companySaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateCompanyById(@Valid @RequestBody CompanyDto companyDto, @PathVariable Long id){
        CompanyDto companyUpdated = companyServices.updateCompany(companyDto, id);
        return ResponseEntity.ok(companyUpdated);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteCompany (@PathVariable Long id){
        companyServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping({"{companyId}/representatives/{representativeId}","{companyId}/representatives/{representativeId}/"})
    public ResponseEntity addRepresentativeToCompany(@PathVariable Long companyId, @PathVariable Long representativeId) {
        CompanyDto companyDtoWithNewRepresentative = companyServices.addRepresentativeToCompany(representativeId, companyId);
        return ResponseEntity.ok(companyDtoWithNewRepresentative);
    }

    @PutMapping({"{companyId}/courses/{courseId}","{companyId}/courses/{courseId}/"})
    public ResponseEntity addCourseToCompany(@PathVariable Long companyId, @PathVariable Long courseId) {
        CompanyDto companyDtoWithNewCourse = companyServices.addCourseToCompany(courseId, companyId);
        return ResponseEntity.ok(companyDtoWithNewCourse);
    }
}
