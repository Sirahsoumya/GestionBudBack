package ma.mic.sic.budgetaire.controller;
import org.springframework.web.bind.annotation.PatchMapping;
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
import ma.mic.sic.budgetaire.entity.SourcheBudget;
import ma.mic.sic.budgetaire.repository.SourceBudgetRepository;


@RestController
@RequestMapping(value = "sourceBudgets")
@CrossOrigin(origins = "http://localhost:4200")
public class SourceBudgetController {
	@Autowired
	private SourceBudgetRepository sourceBudgetRepository;

	@PostMapping("/save")
	public void Save(@RequestBody SourcheBudget sourceBudget) {
		sourceBudgetRepository.save(sourceBudget);
	}

	@DeleteMapping("/delete/{idSourceBudget}")
	public void Delete(@PathVariable(required = true) String idSourceBudget) {
		SourcheBudget sourceBudget = sourceBudgetRepository.findById(Integer.parseInt(idSourceBudget));
		sourceBudgetRepository.delete(sourceBudget);
	}

	@GetMapping("/all")
	public List<SourcheBudget> findAll() {
		return sourceBudgetRepository.findAll();

	}


    @GetMapping("/findById/{idSourceBudget}")
	 public SourcheBudget findSourcheBudgetById(@PathVariable(required = true) String idSourceBudget)  {
		return sourceBudgetRepository.findById(Integer.parseInt(idSourceBudget));
				
			}
			
	@PatchMapping("/source/{idSourceBudget}")
	public void update(@RequestBody  SourcheBudget sourcheBudget,@PathVariable(required = true) String idSourceBudget ) {
		sourceBudgetRepository.save(sourcheBudget);
			
			
			}
}
