package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entities.Personnel;
import modele.PersonnelHome;
//troisieme comit de ousseynou

@ManagedBean(name="connexionBean")
@SessionScoped
public class ConnexionBean {
	public Personnel user;
	 
	public String message;
	public Personnel getUser() {
		return user;
	}
	public void setUser(Personnel user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ConnexionBean(){
		user=new Personnel();
	}
	public String connexion(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String login=user.getLogin();
		String password=user.getPassword();
		if(PersonnelHome.connexion(login, password)!=null){
			try {
				ec.redirect("welcome.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				ec.redirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "login";
		}
		return login;
	}
}
