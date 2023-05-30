package ValiIT.back_praktikale_23.domain.internship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {
    @Query("select i from Internship i where i.company.user.id = ?1 and i.status = ?2")
    List<Internship> findCompanyActiveInternshipsBy(Integer id, String status);





}