package ValiIT.back_praktikale_23.domain.internship.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.user.id = ?1")
    Company findCompanyBy(Integer userId);

}