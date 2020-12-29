package ma.mic.sic.budgetaire.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fonctionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFonctionnaire;
	private String nomFonctionnaire;
	@ManyToOne
    private Projet projet1;
	public Fonctionnaire() {
		super();
	}
	public int getIdFonctionnaire() {
		return idFonctionnaire;
	}
	public void setIdFonctionnaire(int idFonctionnaire) {
		this.idFonctionnaire = idFonctionnaire;
	}
	public String getNomFonctionnaire() {
		return nomFonctionnaire;
	}
	public void setNomFonctionnaire(String nomFonctionnaire) {
		this.nomFonctionnaire = nomFonctionnaire;
	}
	public Projet getProjet1() {
		return projet1;
	}
	public void setProjet1(Projet projet1) {
		this.projet1 = projet1;
	}
	

}
