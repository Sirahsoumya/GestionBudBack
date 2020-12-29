package ma.mic.sic.budgetaire.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Sponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSponsor;
	private String nomSponsor;
	private String type;

	/*@ManyToMany(mappedBy = "spnosors", fetch = FetchType.LAZY)
    private List<Projet> projets;*/
	@ManyToOne
    private Projet projets;
	public Sponsor() {
		super();
	}

	public int getIdSponsor() {
		return idSponsor;
	}
	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}
	public String getNomSponsor() {
		return nomSponsor;
	}
	public void setNomSponsor(String nomSponsor) {
		this.nomSponsor = nomSponsor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Projet getProjets() {
		return projets;
	}

	public void setProjets(Projet projets) {
		this.projets = projets;
	}

	

}

