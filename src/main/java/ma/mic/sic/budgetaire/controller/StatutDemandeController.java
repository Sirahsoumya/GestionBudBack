package ma.mic.sic.budgetaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mic.sic.budgetaire.entity.Sponsor;
import ma.mic.sic.budgetaire.entity.StatutDemande;

import ma.mic.sic.budgetaire.repository.StatutDemandeRepository;


@RestController
@RequestMapping(value = "statutDemande")
@CrossOrigin(origins = "http://localhost:4200")
public class StatutDemandeController {
	@Autowired
	private   StatutDemandeRepository statutDemandeRepository;

	@PostMapping("/save")
	public void Save(@RequestBody  StatutDemande statutDemande ) {
		statutDemandeRepository.save(statutDemande);
	}

	@DeleteMapping("/delete/{idStatut}")
	public void Delete(@PathVariable(required = true) String idStatut) {
		StatutDemande statutDemande = statutDemandeRepository.findById(Integer.parseInt(idStatut));
		 statutDemandeRepository.delete(statutDemande);
	}

	@GetMapping("/all")
	public List<StatutDemande> findAll() {
		return statutDemandeRepository.findAll();

	}


	 @GetMapping("/findById/{idStatut}")
	 public StatutDemande findStatutDemandeById(@PathVariable(required = true) String idStatut)  {
		return statutDemandeRepository.findById(Integer.parseInt(idStatut));
				
			}
			
	@PatchMapping("/statut/{idStatut}")
	public void update(@RequestBody  StatutDemande statutDemande,@PathVariable(required = true) String idStatut ) {
		statutDemandeRepository.save(statutDemande);
			
			
			}
}
