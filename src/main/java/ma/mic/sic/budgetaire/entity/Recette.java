package ma.mic.sic.budgetaire.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Recette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecette;
	private String codeEconomique;
	private Double montant;
	@Temporal(TemporalType.DATE)
	private Date date; 
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	private Devision division;
	@ManyToOne
	private Type type;
	public Recette() {
		super();
	}
	public int getIdRecette() {
		return idRecette;
	}
	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}
	public String getCodeEconomique() {
		return codeEconomique;
	}
	public void setCodeEconomique(String codeEconomique) {
		this.codeEconomique = codeEconomique;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Devision getDivision() {
		return division;
	}
	public void setDivision(Devision division) {
		this.division = division;
	}
	
	
	
}
