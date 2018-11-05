package entities;

// Generated 1 mai 2018 20:54:31 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Personnel generated by hbm2java
 */
@Entity
@Table(name = "personnel", catalog = "employ�")
public class Personnel implements java.io.Serializable {

	private String malte;
	private String prenom;
	private String nom;
	private int telephone;
	private String login;
	private String password;

	public Personnel() {
	}

	public Personnel(String malte, String prenom, String nom, int telephone,
			String login, String password) {
		this.malte = malte;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
	}

	@Id
	@Column(name = "Malte", unique = true, nullable = false, length = 30)
	public String getMalte() {
		return this.malte;
	}

	public void setMalte(String malte) {
		this.malte = malte;
	}

	@Column(name = "Prenom", nullable = false, length = 40)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "Nom", nullable = false, length = 20)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Telephone", nullable = false)
	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Column(name = "login", nullable = false, length = 30)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
