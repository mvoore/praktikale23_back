package ValiIT.back_praktikale_23.business.region;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RegionsController {

    @Resource
    private RegionsService regionsService;

    @GetMapping("/regions")
    @Operation(summary = "Leiab süsteemist (andmebaasist region tabelist) kõik regioonid.")

    public List<RegionDto> getRegions() {
        List<RegionDto> regions = regionsService.getRegions();
        return regions;

    }

}
