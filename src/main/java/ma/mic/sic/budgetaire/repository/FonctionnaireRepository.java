package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Fonctionnaire;
import org.springframework.stereotype.Repository;
@Repository
public interface FonctionnaireRepository extends JpaRepository<Fonctionnaire,Integer> {
	Fonctionnaire	findById(int idFonctionnaire);


}
