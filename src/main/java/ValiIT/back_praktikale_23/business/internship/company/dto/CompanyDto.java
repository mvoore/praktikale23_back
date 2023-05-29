package ValiIT.back_praktikale_23.business.internship.company.dto;

import ValiIT.back_praktikale_23.domain.internship.company.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto implements Serializable {
    private Integer companyId;
    private Integer userId;
    private String companyName;
    private String phoneNumber;
    private String email;
}