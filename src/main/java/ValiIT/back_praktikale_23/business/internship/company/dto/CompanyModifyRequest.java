package ValiIT.back_praktikale_23.business.internship.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ValiIT.back_praktikale_23.domain.internship.company.Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyModifyRequest implements Serializable {
    private String companyName;
    private String phoneNumber;
    private String email;
}