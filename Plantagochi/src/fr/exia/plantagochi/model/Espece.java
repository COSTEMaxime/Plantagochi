package fr.exia.plantagochi.model;

public class Espece {
	
	private String nomCommun;
	private String nomScientifique;
	
	
	public Espece(String nomCommun, String nomScientifique) {
		this.nomCommun = nomCommun;
		this.nomScientifique = nomScientifique;
	}

	public String getNomCommun() {
		return nomCommun;
	}

	public String getNomScientifique() {
		return nomScientifique;
	}
}
