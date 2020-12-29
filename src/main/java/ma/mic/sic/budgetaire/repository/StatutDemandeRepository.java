package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.mic.sic.budgetaire.entity.StatutDemande;

public interface StatutDemandeRepository extends JpaRepository<StatutDemande,Integer> {
	StatutDemande findById(int idStatut);


}