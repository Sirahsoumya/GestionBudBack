package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.mic.sic.budgetaire.entity.Type;

public interface TypeRepository extends JpaRepository<Type,Integer> {
	Type findById(int  idType);


}
