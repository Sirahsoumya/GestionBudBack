package ma.mic.sic.budgetaire.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jayway.jsonpath.internal.Path;

import ma.mic.sic.budgetaire.entity.Compagne;
import ma.mic.sic.budgetaire.entity.Type;
import ma.mic.sic.budgetaire.repository.CompagneRepository;





@RestController
@RequestMapping(value = "compagne")
@CrossOrigin(origins = "http://localhost:4200")
public class CompagneController {
	@Autowired
	private  CompagneRepository compagneRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Compagne compagne) {
		compagneRepository.save(compagne);
	}

	@DeleteMapping("/delete/{idCompagne}")
	public void Delete(@PathVariable(required = true) String idCompagne) {
		Compagne compagne =compagneRepository.findById(Integer.parseInt(idCompagne));
		compagneRepository.delete(compagne);
	}

	@GetMapping("/all")
	public List<Compagne> findAll() {
		return compagneRepository.findAll();
	}
	
	
		@GetMapping("/findId/{idCompagne}")
		public Compagne findCompagneById(@PathVariable(required = true) int idCompagne)  {
			return compagneRepository.findById(idCompagne);
			
		}
		
		@PatchMapping("/compagn/{idCompagne}")
		public void update(@RequestBody  Compagne compagne,@PathVariable(required = true) int idCompagne ) {
			compagneRepository.save(compagne);
		
		
		}
		
		

}
