package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.domain.internship.Internship;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Internship} entity
 */
@Data
public class InternshipDto implements Serializable {
    private Integer internshipId;
    private String companyName;
    private String categoryName;
    private String regionName;
    private String title;
    private String imageData;
    private LocalDate dateAdded;
}