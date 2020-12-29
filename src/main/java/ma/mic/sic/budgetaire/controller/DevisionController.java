package ma.mic.sic.budgetaire.controller;

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
import ma.mic.sic.budgetaire.entity.Devision;
import ma.mic.sic.budgetaire.repository.DevisionRepository;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping(value = "divisions")
@CrossOrigin(origins = "http://localhost:4200")
public class DevisionController {
	@Autowired
	private DevisionRepository devisionRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Devision devision) {
		devisionRepository.save(devision);
	}

	@DeleteMapping("/delete/{idDevision}")
	public void Delete(@PathVariable(required = true) String idDevision) {
		Devision devision = devisionRepository.findById(Integer.parseInt(idDevision));
		devisionRepository.delete(devision);
	}

	@GetMapping("/all")
	public List<Devision> findAll() {
		return devisionRepository.findAll();

	}
	@GetMapping("/findId/{idDevision}")
		public Devision findDevisionById(@PathVariable(required = true) int idDevision)  {
			return devisionRepository.findById(idDevision);	
		}
		
   @PatchMapping("/div/{idDevision}")
		public void update(@RequestBody  Devision devision,@PathVariable(required = true) int idDevision ) {
			devisionRepository.save(devision);
		}
}
