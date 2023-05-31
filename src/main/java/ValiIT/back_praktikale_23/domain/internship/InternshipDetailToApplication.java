package ValiIT.back_praktikale_23.domain.internship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Internship}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipDetailToApplication implements Serializable {
    private Integer internshipId;
    private String companyEmail;
}