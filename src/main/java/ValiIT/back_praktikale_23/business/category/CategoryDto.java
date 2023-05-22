package ValiIT.back_praktikale_23.business.category;

import ValiIT.back_praktikale_23.domain.category.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto {
    private final Integer categoryId;
    private final String categoryName;
}