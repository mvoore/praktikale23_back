package ValiIT.back_praktikale_23.domain.category;

import ValiIT.back_praktikale_23.domain.region.Region;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;


    }
}
