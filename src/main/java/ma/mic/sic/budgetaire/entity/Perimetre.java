package ma.mic.sic.budgetaire.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Perimetre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerimetre;
	private String quartier;
	private String adresse;
	private String localisation;
	@JsonIgnore
	@OneToMany(mappedBy = "perimetre",cascade = CascadeType.ALL)
	private List<Projet>projet;
	public Perimetre() {
		super();
	}
	public Perimetre(String quartier, String adresse, String localisation) {
		super();
		this.quartier = quartier;
		this.adresse = adresse;
		this.localisation = localisation;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public int getIdPerimetre() {
		return idPerimetre;
	}
	public void setIdPerimetre(int idPerimetre) {
		this.idPerimetre = idPerimetre;
	}
	public List<Projet> getProjet() {
		return projet;
	}
	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}
	
	

}

