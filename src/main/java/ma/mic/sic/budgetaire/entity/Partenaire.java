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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Partenaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPartenaire;
	private String nomPartenaire;
	private String description;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="idProjet", nullable=false)
    private Projet projet;*/
	@ManyToOne
	private Projet projetp;
	public Partenaire() {
		super();
	}
	
	

	public int getIdPartenaire() {
		return idPartenaire;
	}
	public void setIdPartenaire(int idPartenaire) {
		this.idPartenaire = idPartenaire;
	}
	public String getNomPartenaire() {
		return nomPartenaire;
	}
	public void setNomPartenaire(String nomPartenaire) {
		this.nomPartenaire = nomPartenaire;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public Projet getProjetp() {
		return projetp;
	}



	public void setProjetp(Projet projetp) {
		this.projetp = projetp;
	}




	

}
