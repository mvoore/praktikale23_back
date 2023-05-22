package ValiIT.back_praktikale_23.domain.region;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegionService {

    @Resource
    private RegionRepository regionRepository;

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions;

    }
}
