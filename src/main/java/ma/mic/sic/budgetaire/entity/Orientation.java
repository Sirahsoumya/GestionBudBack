package ma.mic.sic.budgetaire.entity;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orientation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numOrientation;
	private String libelle;
	private String description;
	private String objectif;
	private String resultat;
	private int dureeRealisation;
	private double budget;
	@JsonIgnore
	@OneToMany (mappedBy = "orientation",cascade = CascadeType.ALL)
    private List<Programme> programmes;
	
	public Orientation() {
		super();
	}

	public Orientation(int numOrientation, String libelle, String description, String objectif, String resultat,
			int dureeRealisation, double budget, List<Programme> programmes) {
		super();
		this.numOrientation = numOrientation;
		this.libelle = libelle;
		this.description = description;
		this.objectif = objectif;
		this.resultat = resultat;
		this.dureeRealisation = dureeRealisation;
		this.budget = budget;
		
	}

	public int getNumOrientation() {
		return numOrientation;
	}

	public void setNumOrientation(int numOrientation) {
		this.numOrientation = numOrientation;
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

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
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

	public List<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}
	
	


}

