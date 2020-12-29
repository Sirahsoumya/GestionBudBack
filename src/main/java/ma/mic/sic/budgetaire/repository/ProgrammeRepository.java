package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.mic.sic.budgetaire.entity.Programme;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme,Integer>{
	Programme findById(int numProgramme);
	

}