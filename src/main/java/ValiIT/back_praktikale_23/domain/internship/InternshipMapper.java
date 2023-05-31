package ValiIT.back_praktikale_23.domain.internship;

import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipOffer;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
import ValiIT.back_praktikale_23.util.ImageUtil;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface InternshipMapper {
    @Mapping(constant = "A", target = "status")
    @Mapping(expression = "java(LocalDate.now())", target = "dateAdded")
    Internship toEntity(InternshipOffer internshipDto);


    Internship partialUpdate(InternshipOffer internshipOffer, @MappingTarget Internship internship);



    @Mapping(source = "id", target = "internshipId")
    @Mapping(source = "internship.title", target = "title")
    @Mapping(source = "internship.category.name", target = "categoryName")
    @Mapping(source = "internship.dateAdded", target = "dateAdded")
    CompanyInternshipDto toDto(InternshipAddress internshipAddress);

    List<CompanyInternshipDto> toDtos(List<InternshipAddress> internshipAddresses);

    @Mapping(source="company.user.id",target = "userId")
    @Mapping(source="category.id",target = "categoryId")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    InternshipOffer toInternshipOffer(Internship internship);


    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        byte[] imageData = image.getData();
        return ImageUtil.byteArrayToBase64ImageData(imageData);
    }

}