package ValiIT.back_praktikale_23.business.category;

import ValiIT.back_praktikale_23.domain.internship.category.Category;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryMapper;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryMapper categoryMapper;


    public List<CategoryDto> getCategories() {

        List<Category> categories = categoryService.getCategories();
        List<CategoryDto> dtos = categoryMapper.toDtos(categories);
        return dtos;


    }


}

