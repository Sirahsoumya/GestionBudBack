package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.mic.sic.budgetaire.entity.DemandeTransfert;


public interface DemandeTransfertRepository extends JpaRepository<DemandeTransfert,Integer> {
	DemandeTransfert findById(int numDemande);
	
	
	
	


}
