package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.mic.sic.budgetaire.entity.Marche;
@Repository
public interface MarcheRepository extends JpaRepository<Marche,Integer> {
	Marche findById(int idMarche);

}
