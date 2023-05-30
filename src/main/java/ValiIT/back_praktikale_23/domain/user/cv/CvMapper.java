package ValiIT.back_praktikale_23.domain.user.cv;

import ValiIT.back_praktikale_23.business.Intern.CvRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CvMapper {

    @Mapping(source ="fileData", target = "file", qualifiedByName = "stringToByteArray")
    Cv toEntity(CvRequest cvRequest);

    @Named("stringToByteArray")
    default byte[] stringToByteArray(String value) {
        return value != null ? value.getBytes() : null;
    }
}

