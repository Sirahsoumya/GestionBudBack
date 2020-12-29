package ma.mic.sic.budgetaire.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.mic.sic.budgetaire.entity.Projet;
import ma.mic.sic.budgetaire.repository.ProjetRepository;



@RestController
@RequestMapping(value = "projets")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {
	
	@Autowired
	private ProjetRepository projetRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Projet projet) {
		projetRepository.save(projet);
	}

	@DeleteMapping("/delete/{idProjet}")
	public void Delete(@PathVariable(required = true) String idProjet) {
		System.out.println("-----delete entrer ou pas------------");
		Projet projet = projetRepository.findById(Integer.parseInt(idProjet));
		projetRepository.delete(projet);
	}

	@GetMapping("/all")
	public List<Projet> findAll() {
		return projetRepository.findAll();
	}
	
	@GetMapping("/byId/{idProjet}")
	public Projet findById(@PathVariable(required = true) String idProjet)  {
		return projetRepository.findById(Integer.parseInt(idProjet));
		
	}
	

	//lister projet en retard
		@GetMapping("/retartedProject")
		public List<Projet> listAll() {
			System.out.println("lister les projets en retard c amarche ou pas");
			return projetRepository.listProjetRetard();
			
		}
		
				
		@PatchMapping("/proj/{idProjet}")
		public void update(@RequestBody  Projet projet,@PathVariable(required = true) String idProjet ) {
			projetRepository.save(projet);
				
				
				}

}

