package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.mic.sic.budgetaire.entity.StatutProjet;
import org.springframework.stereotype.Repository;
@Repository
public interface StatutProjetRepository extends JpaRepository<StatutProjet,Integer> {
	StatutProjet findById(int idStatut);

}

