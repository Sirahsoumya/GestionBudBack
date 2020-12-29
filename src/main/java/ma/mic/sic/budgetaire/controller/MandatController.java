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

import ma.mic.sic.budgetaire.entity.Mandat;
import ma.mic.sic.budgetaire.entity.Orientation;
import ma.mic.sic.budgetaire.repository.MandatRepository;


@RestController
@RequestMapping(value = "mandats")
@CrossOrigin(origins = "http://localhost:4200")
public class MandatController {
	@Autowired
	private  MandatRepository mandatRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Mandat mandat) {
		mandatRepository.save(mandat);
	}

	@DeleteMapping("/delete/{numMandat}")
	public void Delete(@PathVariable(required = true) String numMandat) {
		 Mandat mandat =mandatRepository.findById(Integer.parseInt(numMandat));
		mandatRepository.delete(mandat);
	}

	@GetMapping("/all")
	public List<Mandat> findAll() {
		return mandatRepository.findAll();
	}
	
	  
	@GetMapping("/findMandatById/{numMandat}")
	 public Mandat findMandatById(@PathVariable(required = true) String numMandat)  {
		return mandatRepository.findById(Integer.parseInt(numMandat));
				
			}
			
	@PatchMapping("/mandat/{numMandat}")
	public void update(@RequestBody  Mandat mandat,@PathVariable(required = true) String numMandat ) {
		mandatRepository.save(mandat);
			
			
			}
			


}
