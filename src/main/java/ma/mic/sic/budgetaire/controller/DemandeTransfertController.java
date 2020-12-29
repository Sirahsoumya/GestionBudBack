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

import ma.mic.sic.budgetaire.entity.Compagne;
import ma.mic.sic.budgetaire.entity.DemandeTransfert;
import ma.mic.sic.budgetaire.repository.DemandeTransfertRepository;



@RestController
@RequestMapping(value = "demandeTransfert")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeTransfertController {
	@Autowired
	private  DemandeTransfertRepository demandeTransfertRepository;

	@PostMapping("/save")
	public void Save(@RequestBody DemandeTransfert demandeTransfert) {
		demandeTransfertRepository.save(demandeTransfert);
	}
/*
	@DeleteMapping("/delete/{numDemande}")
	public void Delete(@PathVariable(required = true) int numDemande) {
		System.out.println("-----delete entrer ou pas------------");
		DemandeTransfert demandeTransfert =demandeTransfertRepository.findById(numDemande);
		demandeTransfertRepository.delete(demandeTransfert);
	}*/
	

	@DeleteMapping("/delete/{numDemande}")
	public void Delete(@PathVariable(required = true) int numDemande) {
		System.out.println("-----delete entrer ou pas------------");
		System.out.println(numDemande);
		/*DemandeTransfert d =demandeTransfertRepository.findById(numDemande);
		System.out.println("********************");
		System.out.println(d.toString());
		System.out.println("********************");
		demandeTransfertRepository.delete(d);
		DemandeTransfert test = new DemandeTransfert();
		test.setNumDemande(1);*/
		demandeTransfertRepository.delete(demandeTransfertRepository.findById(numDemande));
		
	}
	
	

	@GetMapping("/all")
	public List<DemandeTransfert> findAll() {
		return demandeTransfertRepository.findAll();
	}
	@GetMapping("/findId/{numDemande}")
	public DemandeTransfert findDemandeTransfertById(@PathVariable(required = true) int numDemande)  {
		return demandeTransfertRepository.findById(numDemande);
		
	}
	
	@PatchMapping("/demTransfert/{numDemande}")
	public void update(@RequestBody  DemandeTransfert demandeTransfert,@PathVariable(required = true) int numDemande ) {
		demandeTransfertRepository.save(demandeTransfert);
	
	
	}

}
