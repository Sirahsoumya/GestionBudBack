package ma.mic.sic.budgetaire.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.mic.sic.budgetaire.entity.Marche;
import ma.mic.sic.budgetaire.repository.MarcheRepository;

@RestController
@RequestMapping(value = "marches")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcheController {
	@Autowired
	private MarcheRepository marcheRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Marche marche) {
		marcheRepository.save(marche);
	}

	@DeleteMapping("/delete/{idMarche}")
	public void Delete(@PathVariable(required = true) String idMarche) {
		Marche marche = marcheRepository.findById(Integer.parseInt(idMarche));
		marcheRepository.delete(marche);
	}

	@GetMapping("/all")
	public List<Marche> findAll() {
		return marcheRepository.findAll();
	}
	
	
	 @GetMapping("/findId/{idMarche}")
		public Marche findMarcheById(@PathVariable(required = true) String idMarche)  {
			return marcheRepository.findById(Integer.parseInt(idMarche));	
		}
		
	@PatchMapping("/marche/{idMarche}")
		public void update(@RequestBody  Marche marche,@PathVariable(required = true) String idMarche ) {
			marcheRepository.save(marche);
		}
		
	

}

