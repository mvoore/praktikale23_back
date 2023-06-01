package ValiIT.back_praktikale_23.business.Intern.dto;

import ValiIT.back_praktikale_23.domain.internship.application.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Application}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto implements Serializable {
    private Integer applicationId;
    private Integer internshipId;
    private String internshipTitle;
    private String internshipCompanyName;
}