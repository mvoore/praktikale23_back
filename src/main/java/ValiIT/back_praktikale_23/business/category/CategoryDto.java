package ValiIT.back_praktikale_23.business.category;

import ValiIT.back_praktikale_23.domain.internship.category.Category;
import lombok.Data;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto {
    private  Integer categoryId;
    private  String categoryName;
}