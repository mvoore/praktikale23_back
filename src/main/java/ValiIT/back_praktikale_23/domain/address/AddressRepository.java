package ValiIT.back_praktikale_23.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("select a from Address a where a.company.id = ?1 and a.status = ?2")
    List<Address> findAddressesBy(Integer companyId, String status);


}