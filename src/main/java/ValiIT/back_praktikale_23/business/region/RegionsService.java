package ValiIT.back_praktikale_23.business.region;

import ValiIT.back_praktikale_23.domain.address.region.Region;
import ValiIT.back_praktikale_23.domain.address.region.RegionMapper;
import ValiIT.back_praktikale_23.domain.address.region.RegionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionsService {


    @Resource
    private RegionService regionService;

    @Resource
    private RegionMapper regionMapper;


    public List<RegionDto> getRegions() {

        List<Region> regions = regionService.getRegions();
        List<RegionDto> dtos = regionMapper.toDtos(regions);
        return dtos;

    }
}
