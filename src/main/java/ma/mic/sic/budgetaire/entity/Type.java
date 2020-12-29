package ma.mic.sic.budgetaire.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize(as = Type.class)
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	private String ligne;
	private String article;
	private String chapitre;
	@JsonIgnore
	@OneToMany (mappedBy = "type",cascade = CascadeType.ALL)
    private List<Recette> recettes;
	
	@JsonIgnore
	@OneToMany(mappedBy="type")
	private List<DemandeBudget> demandesBudget;
	public Type() {
		super();
	}
	
	
	
	public List<DemandeBudget> getDemandesBudget() {
		return demandesBudget;
	}



	public void setDemandesBudget(List<DemandeBudget> demandesBudget) {
		this.demandesBudget = demandesBudget;
	}



	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getChapitre() {
		return chapitre;
	}
	public void setChapitre(String chapitre) {
		this.chapitre = chapitre;
	}
	public List<Recette> getRecettes() {
		return recettes;
	}
	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}
	/*
	public List<DemandeBudget> getDemandesBudget() {
		return demandesBudget;
	}
	public void setDemandesBudget(List<DemandeBudget> demandesBudget) {
		this.demandesBudget = demandesBudget;
	}*/


	

}










