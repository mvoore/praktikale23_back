package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import ValiIT.back_praktikale_23.business.internship.InternshipDto;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
import ValiIT.back_praktikale_23.util.ImageUtil;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {LocalDate.class})
public interface InternshipAddressMapper {

    @Mapping(source = "id", target = "internshipId")
    @Mapping(source = "internship.title", target = "title")
    @Mapping(source = "internship.company.name", target = "companyName")
    @Mapping(source = "internship.category.name", target = "categoryName")
    @Mapping(source = "address.region.name", target = "regionName")
    @Mapping(source = "internship.image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "internship.dateAdded", target = "dateAdded")
    InternshipDto toDto(InternshipAddress internshipAddress);

   List <InternshipDto> toDtos(List <InternshipAddress> internshipAddresses);


    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

}