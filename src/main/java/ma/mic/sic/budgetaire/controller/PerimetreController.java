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

import ma.mic.sic.budgetaire.entity.Perimetre;
import ma.mic.sic.budgetaire.repository.PerimetreRepository;



@RestController
@RequestMapping(value = "perimetres")
@CrossOrigin(origins = "http://localhost:4200")
public class PerimetreController{
	@Autowired
	private PerimetreRepository perimetreRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Perimetre perimetre) {
		perimetreRepository.save(perimetre);
	}

	@DeleteMapping("/delete/{idPerimetre}")
	public void Delete(@PathVariable(required = true) String idPerimetre) {
		Perimetre perimetre = perimetreRepository.findById(Integer.parseInt(idPerimetre));
		perimetreRepository.delete(perimetre);
	}

	@GetMapping("/all")
	public List<Perimetre> findAll() {
		return perimetreRepository.findAll();
	}
	@GetMapping("/findById/{idPerimetre}")
	 public Perimetre findPerimetreById(@PathVariable(required = true) int idPerimetre)  {
		return perimetreRepository.findById(idPerimetre);
				
			}
			
 @PatchMapping("/Perimetr/{idPerimetre}")
	public void update(@RequestBody  Perimetre Perimetre,@PathVariable(required = true) int idPerimetre ) {
		System.out.println("update Perimetre ca marche ou pas");
		perimetreRepository.save(Perimetre);
			
			
			}
}
	