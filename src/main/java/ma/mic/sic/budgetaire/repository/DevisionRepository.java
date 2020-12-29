package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Devision;

import org.springframework.stereotype.Repository;
@Repository
public interface DevisionRepository extends JpaRepository<Devision,Integer> {
	Devision	findById(int idDevision);


}
