package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.DemandeBudget;

public interface DemandeBudgetRepository extends JpaRepository<DemandeBudget,Integer> {
	DemandeBudget findById(int idDemande);


}
