package ValiIT.back_praktikale_23.business.internshipaddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipAddressRequest implements Serializable {
    private Integer internshipAddressId;
    private Integer addressId;
}