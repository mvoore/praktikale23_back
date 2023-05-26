package ValiIT.back_praktikale_23.business.address.city;



import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @GetMapping("/cities")
    @Operation(summary = "Leiab süsteemist (andmebaasist city tabelist) kõik citid.")

    public List<CityDto> getCities() {
        List<CityDto> regions = citiesService.getCities();
        return regions;

    }


}
