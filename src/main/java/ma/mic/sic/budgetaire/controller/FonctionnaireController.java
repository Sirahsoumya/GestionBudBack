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

import ma.mic.sic.budgetaire.entity.Fonctionnaire;
import ma.mic.sic.budgetaire.repository.FonctionnaireRepository;

@RestController
@RequestMapping(value = "fonctionnaires")
@CrossOrigin(origins = "http://localhost:4200")
public class FonctionnaireController {
	@Autowired
	private FonctionnaireRepository fonctionnaireRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Fonctionnaire fonctionnaire) {
		fonctionnaireRepository.save(fonctionnaire);
	}

	@DeleteMapping("/delete/{idFonctionnaire}")
	public void Delete(@PathVariable(required = true) String idFonctionnaire) {
		Fonctionnaire fonctionnaire = fonctionnaireRepository.findById(Integer.parseInt(idFonctionnaire));
		fonctionnaireRepository.delete(fonctionnaire);
	}

	@GetMapping("/all")
	public List<Fonctionnaire> findAll() {
		return fonctionnaireRepository.findAll();
	}
	
	 @GetMapping("/findId/{idFonctionnaire}")
		public Fonctionnaire findFonctionnaireById(@PathVariable(required = true) int idFonctionnaire)  {
			return fonctionnaireRepository.findById(idFonctionnaire);	
		}
		
		@PatchMapping("/fonction/{idFonctionnaire}")
		public void update(@RequestBody  Fonctionnaire fonctionnaire,@PathVariable(required = true) int idFonctionnaire ) {
			fonctionnaireRepository.save(fonctionnaire);
		}
	

}
