package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Mandat;


public interface MandatRepository extends JpaRepository<Mandat,Integer> {
	Mandat findById(int numMandat);

}
