package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.mic.sic.budgetaire.entity.Orientation;
@Repository
public interface OrientationRepository extends JpaRepository<Orientation,Integer> {
	Orientation	findById(int numOrientation);

}
