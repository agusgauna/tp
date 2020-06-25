package ar.com.ada.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "cuil", "address", "year", "telephone",
        "representative", "course", "category", "company_type"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CompanyDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
    private Integer cuil;

    @NotBlank(message = "address is required")
    private String address;

    @JsonFormat(pattern = "yyyy")
    @NotNull(message = "year is required")
    @PastOrPresent(message = "the year must be past or present")
    private Year year;

    @NotNull(message = "telephone is required")
    private Integer telephone;

    @JsonIgnoreProperties(value = "company")
    private Set<RepresentativeDto> representatives;

    @JsonIgnoreProperties(value = "company")
    private Set<CourseDto> courses;

    @JsonIgnoreProperties(value = "companies")
    private CategoryDto category;

    @JsonIgnoreProperties(value = "company")
    private CompanyTypeDto companyType;

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

    public CompanyDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyDto setYear(Year year) {
        this.year = year;
        return this;
    }

    public CompanyDto setTelephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }
}
