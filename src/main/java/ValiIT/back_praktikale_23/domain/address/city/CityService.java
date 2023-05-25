package ValiIT.back_praktikale_23.domain.address.city;

import ValiIT.back_praktikale_23.domain.user.role.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public City findCityBy(Integer cityId) {
        City city = cityRepository.findById(cityId).get();
        return city;

    }
}
