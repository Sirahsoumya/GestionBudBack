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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Devision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDevision;
	private String libelle;
	
	@OneToMany (mappedBy = "devision",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Projet> projet;
	
	@JsonIgnore
	@OneToMany (mappedBy = "devision",cascade = CascadeType.ALL)
    private List<Depense> depenses;
	
	@JsonIgnore
	@OneToMany (mappedBy = "division",cascade = CascadeType.ALL)
    private List<Recette> recettes;

	
	//
	@JsonIgnore
	@OneToOne(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private DemandeTransfert  demandeTransfert;
	
	public Devision() {
		super();
	}
	public int getIdDevision() {
		return idDevision;
	}
	
	public void setIdDevision(int idDevision) {
		this.idDevision = idDevision;
	}
	
	public List<Projet> getProjet() {
		return projet;
	}
	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Depense> getDepenses() {
		return depenses;
	}
	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}
	public List<Recette> getRecettes() {
		return recettes;
	}
	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}
	
	

}
