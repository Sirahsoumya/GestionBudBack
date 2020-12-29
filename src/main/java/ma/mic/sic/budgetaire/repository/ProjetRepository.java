package ma.mic.sic.budgetaire.repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.mic.sic.budgetaire.entity.Projet;
@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
	Projet findById(int idProjet);

	//Lister les projet en retard
	@Query("SELECT p from Projet p where p.etatAvancementReelle <= p.etatAvancementTheorique")
	List<Projet> listProjetRetard();

}
