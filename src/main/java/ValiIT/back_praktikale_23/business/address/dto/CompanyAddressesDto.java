package ValiIT.back_praktikale_23.business.address.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ValiIT.back_praktikale_23.domain.address.Address}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAddressesDto implements Serializable {
    private Integer addressId;
    private String regionName;
    private String cityName;
    private String street;
    private Integer streetNumber;
    private Integer postalCode;
    private String status;
}