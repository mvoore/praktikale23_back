package ValiIT.back_praktikale_23.domain.internship.application;

import ValiIT.back_praktikale_23.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query("""
            select a from Application a
            where a.user.id = ?1 and a.status = ?2
            order by a.internship.company.name, a.internship.category.name""")
    List<Application> findByApplications(Integer userId, String status);



}