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
import ma.mic.sic.budgetaire.entity.Indicateur;
import ma.mic.sic.budgetaire.repository.IndicateurRepository;


@RestController
@RequestMapping(value = "indicateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class IndicateurController {
	@Autowired
	private IndicateurRepository indicateurRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Indicateur indicateur) {
		indicateurRepository.save(indicateur);
	}

	@DeleteMapping("/delete/{idIndicateur}")
	public void Delete(@PathVariable(required = true) String idIndicateur) {
		Indicateur indicateur = indicateurRepository.findById(Integer.parseInt(idIndicateur));
		indicateurRepository.delete(indicateur);
	}

	@GetMapping("/all")
	public List<Indicateur> findAll() {
		return indicateurRepository.findAll();

	}
	
	 @GetMapping("/findId/{idIndicateur}")
		public Indicateur findIndicateurById(@PathVariable(required = true) int idIndicateur)  {
			return indicateurRepository.findById(idIndicateur);	
		}
		
    @PatchMapping("/ind/{idIndicateur}")
		public void update(@RequestBody  Indicateur indicateur,@PathVariable(required = true) int idIndicateur ) {
			indicateurRepository.save(indicateur);
		}

}

