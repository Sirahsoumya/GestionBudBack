package ma.mic.sic.budgetaire.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Indicateur {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idIndicateur;
		private String libelle;
		private String description;
		private String objectif;
		private String cible;
		private String actuel;
		@ManyToOne
	    private Projet projet;
		public Indicateur() {
			super();
		}
		
		public int getIdIndicateur() {
			return idIndicateur;
		}
		public void setIdIndicateur(int idIndicateur) {
			this.idIndicateur = idIndicateur;
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
		public String getCible() {
			return cible;
		}
		public void setCible(String cible) {
			this.cible = cible;
		}
		public String getActuel() {
			return actuel;
		}
		public void setActuel(String actuel) {
			this.actuel = actuel;
		}
		public Projet getProjet() {
			return projet;
		}
		public void setProjet(Projet projet) {
			this.projet = projet;
		}
		
		
}

