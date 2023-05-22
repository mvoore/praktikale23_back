package ValiIT.back_praktikale_23.business.category;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;


    @GetMapping("/categories")
    @Operation(summary = "Leiab süsteemist (andmebaasist category tabelist) kõik kategooriad.")


    public List<CategoryDto> getCategories(){

        List<CategoryDto>categories = categoriesService.getCategories();
        return categories;


    }


}
