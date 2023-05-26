package ValiIT.back_praktikale_23.business.address.city;

import ValiIT.back_praktikale_23.domain.address.city.City;
import ValiIT.back_praktikale_23.domain.address.city.CityMapper;
import ValiIT.back_praktikale_23.domain.address.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CitiesService {

    @Resource
    private CityService cityService;

    @Resource
    private CityMapper cityMapper;

    public List<CityDto> getCities() {
        List<City> cities = cityService.getCities();
       List<CityDto> dtos = cityMapper.toDtos(cities);

        return dtos;
    }
}
