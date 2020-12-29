package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Compagne;


public interface CompagneRepository extends JpaRepository<Compagne,Integer> {
	Compagne findById(int idCompagne);


}
