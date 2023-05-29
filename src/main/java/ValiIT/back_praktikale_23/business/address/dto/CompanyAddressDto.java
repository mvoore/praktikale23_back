package ValiIT.back_praktikale_23.business.address.dto;

import ValiIT.back_praktikale_23.domain.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Address}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAddressDto implements Serializable {
    private String regionName;
    private String cityName;
    private String street;
    private Integer streetNumber;
    private Integer postalCode;
}