package ma.mic.sic.budgetaire.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.SourcheBudget;
import org.springframework.stereotype.Repository;
@Repository
public interface SourceBudgetRepository extends JpaRepository<SourcheBudget,Integer> {
	SourcheBudget findById(int idSourceBudget);
 

}
