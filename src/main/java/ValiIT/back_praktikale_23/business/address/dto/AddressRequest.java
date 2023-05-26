package ValiIT.back_praktikale_23.business.address.dto;

import ValiIT.back_praktikale_23.domain.address.Address;
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
public class AddressRequest implements Serializable {
    private Integer regionId;
    private Integer cityId;
    private Integer companyId;
    private String addressName;
    private String street;
    private Integer streetNumber;
    private Integer postalCode;
    private BigDecimal longitude;
    private BigDecimal latitude;
}