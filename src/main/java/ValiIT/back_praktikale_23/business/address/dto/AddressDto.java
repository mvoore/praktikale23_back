package ValiIT.back_praktikale_23.business.address.dto;

import ValiIT.back_praktikale_23.domain.address.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Address}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private Integer addressId;
    private String regionName;
    private String cityName;
    private String companyName;
    private String companyPhoneNumber;
    private String companyEmail;
    private String name;
    private String street;
    private Integer streetNumber;
    private Integer postalCode;
    private BigDecimal longitude;
    private BigDecimal latitude;
}