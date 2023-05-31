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
public class ApplicationRequest implements Serializable {
    private Integer internshipId;
    private Integer userId;
    private String email;
    private String fullName;
    private String message;
}