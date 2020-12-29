package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Recette;

public interface RecetteRepository extends JpaRepository<Recette,Integer> {
	Recette findById(int idRecette);


}
