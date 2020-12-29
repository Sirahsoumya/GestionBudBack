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

import ma.mic.sic.budgetaire.entity.Sponsor;
import ma.mic.sic.budgetaire.repository.SponsorRepository;


@RestController
@RequestMapping(value = "sponsors")
@CrossOrigin(origins = "http://localhost:4200")
public class SponsorController {
	@Autowired
	private SponsorRepository sponsorRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Sponsor sponsor) {
		sponsorRepository.save(sponsor);
	}

	@DeleteMapping("/delete/{idSponsor}")
	public void Delete(@PathVariable(required = true) String idSponsor) {
		Sponsor sponsor = sponsorRepository.findById(Integer.parseInt(idSponsor));
		sponsorRepository.delete(sponsor);
	}

	@GetMapping("/all")
	public List<Sponsor> findAll() {
		return sponsorRepository.findAll();

	}
	
	//lister les sponsor d'un projet
	@GetMapping("/listSponsor/{idProjet}")
	public List<Sponsor> findSponsor(@PathVariable int idProjet ) {
		return sponsorRepository.findSponsorByProjetId(idProjet);
	}

	 @GetMapping("/findById/{idSponsor}")
	 public Sponsor findSponsorById(@PathVariable(required = true) String idSponsor)  {
		return sponsorRepository.findById(Integer.parseInt(idSponsor));
				
			}
			
	@PatchMapping("/sponsor/{idSponsor}")
	public void update(@RequestBody  Sponsor sponsor,@PathVariable(required = true) String idSponsor ) {
		sponsorRepository.save(sponsor);
			
			
			}

}
