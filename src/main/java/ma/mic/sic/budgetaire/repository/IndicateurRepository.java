package ma.mic.sic.budgetaire.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.mic.sic.budgetaire.entity.Indicateur;


@Repository
public interface IndicateurRepository extends JpaRepository<Indicateur,Integer> {
	Indicateur	findById(int idIndicateur);


}
