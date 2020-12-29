package ma.mic.sic.budgetaire.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Sponsor;
import org.springframework.stereotype.Repository;
@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Integer> {
	Sponsor findById(int idSponsor);
	// lister les sponsors d'un projet
	@Query("select s from Sponsor s where s.projets.idProjet = :id")
    List<Sponsor> findSponsorByProjetId(@Param("id") Integer idProjet);


}
