package ma.mic.sic.budgetaire.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Programme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numProgramme;
	private String libelle;
	private String description;
	private String resultat;
	private int dureeRealisation;
	private double budget;
	
	@ManyToOne
    private Orientation orientation;
	@JsonIgnore
	@OneToMany (mappedBy = "programme",cascade = CascadeType.ALL)
    private List<Projet> projet;
	public Programme() {
		super();
	}
	public Programme(int numProgramme, String libelle, String description, String resultat, int dureeRealisation,
			double budget, Orientation orientation) {
		super();
		this.numProgramme = numProgramme;
		this.libelle = libelle;
		this.description = description;
		this.resultat = resultat;
		this.dureeRealisation = dureeRealisation;
		this.budget = budget;
		this.orientation = orientation;
	}
	public int getNumProgramme() {
		return numProgramme;
	}
	public void setNumProgramme(int numProgramme) {
		this.numProgramme = numProgramme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public int getDureeRealisation() {
		return dureeRealisation;
	}
	public void setDureeRealisation(int dureeRealisation) {
		this.dureeRealisation = dureeRealisation;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public List<Projet> getProjet() {
		return projet;
	}
	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}
	
	


}

