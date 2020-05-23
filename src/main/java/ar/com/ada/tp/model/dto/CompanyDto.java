package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Representative;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
    private Integer cuil;

    @NotBlank(message = "type is required")
    private String type;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "category is required")
    private String category;

    @JsonFormat(pattern = "yyyy")
    @NotNull(message = "year is required")
    @PastOrPresent(message = "the year must be past or present")
    private Date year;

    @NotNull(message = "telephone is required")
    private Integer telephone;

    @JsonIgnoreProperties(value = "companies")
    private Set<Representative> representatives;

    @JsonIgnoreProperties(value = "companies")
    private Set<Course> courses;

    public CompanyDto setId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyDto setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyDto setCuil(Integer cuil) {
        this.cuil = cuil;
        return this;
    }

    public CompanyDto setType(String type) {
        this.type = type;
        return this;
    }

    public CompanyDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public CompanyDto setYear(Date year) {
        this.year = year;
        return this;
    }

    public CompanyDto setTelephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }
}
