package ma.mic.sic.budgetaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mic.sic.budgetaire.entity.Partenaire;
import ma.mic.sic.budgetaire.repository.PartenaireRepository;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping(value = "partenaires")
@CrossOrigin(origins = "http://localhost:4200")
public class PartenaireController {
	@Autowired
	private PartenaireRepository partenaireRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Partenaire partenaire) {
		partenaireRepository.save(partenaire);
	}

	@DeleteMapping("/delete/{idPartenaire}")
	public void Delete(@PathVariable(required = true) String idPartenaire) {
		Partenaire partenaire = partenaireRepository.findById(Integer.parseInt(idPartenaire));
		partenaireRepository.delete(partenaire);
	}

	@GetMapping("/all")
	public List<Partenaire> findAll() {
		return partenaireRepository.findAll();
	}
	
	@GetMapping("/findById/{idPartenaire}")
	 public Partenaire findPartenaireById(@PathVariable(required = true) String idPartenaire)  {
		return partenaireRepository.findById(Integer.parseInt(idPartenaire));
				
			}
			
	@PatchMapping("/part/{idPartenaire}")
	public void update(@RequestBody  Partenaire partenaire,@PathVariable(required = true) String idPartenaire ) {
		partenaireRepository.save(partenaire);
			
			
			}
	

}
