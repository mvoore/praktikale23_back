package ValiIT.back_praktikale_23.business.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link ValiIT.back_praktikale_23.domain.internship.Internship}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInternshipDto implements Serializable {
    private Integer internshipId;
    private String categoryName;
    private String title;
    private LocalDate dateAdded;
}