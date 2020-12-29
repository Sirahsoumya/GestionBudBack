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
import ma.mic.sic.budgetaire.entity.DemandeBudget;
import ma.mic.sic.budgetaire.repository.DemandeBudgetRepository;


@RestController
@RequestMapping(value = "demandeBudget")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeBudgetController {
	@Autowired
	private  DemandeBudgetRepository demandeBudgetRepository;

	@PostMapping("/save")
	public void Save(@RequestBody  DemandeBudget demandeBudget) {
		System.out.println("demande budget enregistrer");
		System.out.println("------demande budget :-----"+demandeBudget.getProjet());
		demandeBudgetRepository.save(demandeBudget);
	}

	@DeleteMapping("/delete/{idDemande}")
	public void Delete(@PathVariable(required = true) String idDemande) {
		 DemandeBudget demandeBudget =demandeBudgetRepository.findById(Integer.parseInt(idDemande));
		 demandeBudgetRepository.delete(demandeBudget);
	}

	@GetMapping("/all")
	public List< DemandeBudget> findAll() {
		return demandeBudgetRepository.findAll();
	}
	
	@GetMapping("/findId/{idDemande}")
	public DemandeBudget findDemandeBudgetId(@PathVariable(required = true) int idDemande)  {
		return demandeBudgetRepository.findById(idDemande);
		
	}
	
	@PatchMapping("/demBudget/{idDemande}")
	public void update(@RequestBody  DemandeBudget demandeBudget,@PathVariable(required = true) int idDemande ) {
		demandeBudgetRepository.save(demandeBudget);
	
	
	}

}
