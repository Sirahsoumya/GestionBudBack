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
public class StatutProjet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStatut;
	private String libelle;
	@JsonIgnore
	@OneToMany (mappedBy = "statutProjet",cascade = CascadeType.ALL)
    private List<Projet> projet;
	public StatutProjet() {
		super();
	}
	public StatutProjet(int idStatut, String libelle, List<Projet> projet) {
		super();
		this.idStatut = idStatut;
		this.libelle = libelle;
		this.projet = projet;
	}
	public int getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
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

