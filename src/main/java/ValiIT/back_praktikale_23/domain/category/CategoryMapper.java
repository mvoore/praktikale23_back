package ValiIT.back_praktikale_23.domain.category;

import ValiIT.back_praktikale_23.business.category.CategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(source = "categoryId", target = "id")
    @Mapping(source = "categoryName", target = "name")
    Category toEntity(CategoryDto categoryDto);

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    CategoryDto toDto(Category category);

    List<CategoryDto> toDtos(List<Category> categories);

}