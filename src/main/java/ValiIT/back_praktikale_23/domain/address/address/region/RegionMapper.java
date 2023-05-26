package ValiIT.back_praktikale_23.domain.address.address.region;

import ValiIT.back_praktikale_23.business.region.RegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    @Mapping(source = "regionId", target = "id")
    @Mapping(source = "regionName", target = "name")
    Region toEntity(RegionDto regionDto);

    @Mapping(source = "id", target = "regionId")
    @Mapping(source = "name", target = "regionName")
    RegionDto toDto(Region region);


    List<RegionDto> toDtos(List<Region> regions);



}