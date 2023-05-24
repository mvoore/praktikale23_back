package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.domain.internship.Internship;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Internship} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipDto implements Serializable {
    private Integer internshipId;
    private String companyName;
    private String categoryName;
    private String regionName;
    private String title;
    private String imageData;
    private LocalDate dateAdded;
}