package ValiIT.back_praktikale_23.domain.address.address.city;

import ValiIT.back_praktikale_23.business.address.city.CityDto;
import ValiIT.back_praktikale_23.business.region.RegionDto;
import ValiIT.back_praktikale_23.domain.address.address.region.Region;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {
    @Mapping(source = "cityId", target = "id")
    @Mapping(source = "cityName", target = "name")

    City toEntity(CityDto cityDto);

    @Mapping(source = "id",target = "cityId")
    @Mapping(source = "name",target = "cityName")
    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);

}