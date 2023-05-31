package ValiIT.back_praktikale_23.domain.user.coverletter;

import ValiIT.back_praktikale_23.business.Intern.CoverletterRequest;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CoverletterMapper {

    @Mapping(source ="fileData", target = "file", qualifiedByName = "stringToByteArray")
    Coverletter toEntity(CoverletterRequest coverletterRequest);

    @Named("stringToByteArray")
    default byte[] stringToByteArray(String value) {
        return value != null ? value.getBytes() : null;
    }
}

