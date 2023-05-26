package ValiIT.back_praktikale_23.domain.address.region;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Resource
    private RegionRepository regionRepository;

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions;

    }

    public Region findRegionBy(Integer regionId) {
        Optional<Region> optionalRegion = regionRepository.findById(regionId);
        Region region = optionalRegion.get();
        return region;
    }
}
