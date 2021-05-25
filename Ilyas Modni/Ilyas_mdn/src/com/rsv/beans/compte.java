package com.rsv.beans;

public class compte {
	private String cne;
	private String nom;
	private String prenom;
    //Constructor 
    public compte()
    {
    	this.cne="R1248484";
    	this.nom="modni";
    	this.prenom="ilyas";
    }
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
