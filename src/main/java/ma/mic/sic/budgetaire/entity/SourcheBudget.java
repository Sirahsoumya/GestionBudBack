package ma.mic.sic.budgetaire.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SourcheBudget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSourceBudget;
	private String libelle;
	
	@OneToMany (mappedBy = "sourceBudget",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Projet> projet;
	public SourcheBudget() {
		super();
	}
	public SourcheBudget(int idSourceBudget, String libelle) {
		super();
		this.idSourceBudget = idSourceBudget;
		this.libelle = libelle;
	}
	public int getIdSourceBudget() {
		return idSourceBudget;
	}
	public void setIdSourceBudget(int idSourceBudget) {
		this.idSourceBudget = idSourceBudget;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Projet> getProjet() {
		return projet;
	}
	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}
	
	

}
