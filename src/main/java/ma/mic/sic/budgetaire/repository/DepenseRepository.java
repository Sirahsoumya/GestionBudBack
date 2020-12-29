package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Depense;



public interface DepenseRepository extends JpaRepository<Depense,Integer>{
	Depense findById(int idDepense);
}
