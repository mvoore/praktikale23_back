package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternshipAddressRepository extends JpaRepository<InternshipAddress, Integer> {
    @Query("""
            select i from InternshipAddress i
            where (i.address.region.id = ?1 or ?1 = 0 ) and (i.internship.category.id = ?2 or ?2 = 0) and i.internship.status = ?3""")
    List<InternshipAddress> findInternshipAddressesBy(Integer regionId, Integer categoryId, String status, Sort sort);

}