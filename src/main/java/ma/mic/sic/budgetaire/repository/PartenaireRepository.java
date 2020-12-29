package ma.mic.sic.budgetaire.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.mic.sic.budgetaire.entity.Partenaire;

import org.springframework.stereotype.Repository;
@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire,Integer> {
	Partenaire findById(int idPartenaire);


}
