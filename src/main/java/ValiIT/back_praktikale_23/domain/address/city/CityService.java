package ValiIT.back_praktikale_23.domain.address.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public City findCityBy(Integer cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        City city = optionalCity.get();
        return city;

    }
    public List<City> getCities() {
        List<City> cities = cityRepository.findAll();
        return cities;

    }
}
