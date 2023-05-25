package ValiIT.back_praktikale_23.business.internship.dto;

import ValiIT.back_praktikale_23.domain.internship.Internship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Internship} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipRequest implements Serializable {
    private Integer userId;
    private Integer addressId;
    private String title;
    private Integer categoryId;
    private String description;
    private String imageData;
}