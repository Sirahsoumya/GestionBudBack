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
import ma.mic.sic.budgetaire.entity.StatutProjet;
import ma.mic.sic.budgetaire.repository.StatutProjetRepository;


@RestController
@RequestMapping(value = "statutProjet")
@CrossOrigin(origins = "http://localhost:4200")
public class StatutProjetController {
	@Autowired
	private StatutProjetRepository statutProjetRepository;

	@PostMapping("/save")
	public void Save(@RequestBody StatutProjet statutProjet) {
		statutProjetRepository.save(statutProjet);
	}

	@DeleteMapping("/delete/{idStatut}")
	public void Delete(@PathVariable(required = true) String idStatut) {
		StatutProjet statutProjet = statutProjetRepository.findById(Integer.parseInt(idStatut));
		statutProjetRepository.delete(statutProjet);
	}

	@GetMapping("/all")
	public List<StatutProjet> findAll() {
		return statutProjetRepository.findAll();

	}
	 @GetMapping("/findById/{idStatut}")
	 public StatutProjet findStatutProjetById(@PathVariable(required = true) String idStatut)  {
		return statutProjetRepository.findById(Integer.parseInt(idStatut));
				
			}
			
	@PatchMapping("/statutProj/{idStatut}")
	public void update(@RequestBody  StatutProjet statutProjet,@PathVariable(required = true) String idStatut ) {
		statutProjetRepository.save(statutProjet);
			
			
			}

}
