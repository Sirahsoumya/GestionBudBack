package ma.mic.sic.budgetaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mic.sic.budgetaire.entity.Projet;
import ma.mic.sic.budgetaire.entity.Type;
import ma.mic.sic.budgetaire.repository.TypeRepository;

@RestController
@RequestMapping(value = "type")
@CrossOrigin(origins = "http://localhost:4200")
public class TypeController {
	@Autowired
	private TypeRepository typeRepository;

	@PostMapping("/save")
	public void Save(@RequestBody  Type type ) {
		typeRepository.save( type);
	}

	@DeleteMapping("/delete/{idType}")
	public void Delete(@PathVariable(required = true) String idType) {
		 Type type = typeRepository.findById(Integer.parseInt(idType));
		typeRepository.delete( type);
	}

	@GetMapping("/all")
	public List<Type> findAll() {
		return typeRepository.findAll();

	}
	
   //findbyId pour modefier
	@GetMapping("/findId/{idType}")
	public Type findTypeById(@PathVariable(required = true) int idType)  {
		return typeRepository.findById(idType);
		
	}
	
	@PatchMapping("/typ/{idType}")
	public void update(@RequestBody  Type type,@PathVariable(required = true)int idType ) {
		System.out.println("methode patch !!");
	 typeRepository.save(type);
	
	
	}
	

}
