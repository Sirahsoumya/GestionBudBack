package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.mic.sic.budgetaire.entity.Perimetre;

@Repository
public interface PerimetreRepository extends JpaRepository<Perimetre,Integer> {
	Perimetre	findById(int idPerimetre);


}
