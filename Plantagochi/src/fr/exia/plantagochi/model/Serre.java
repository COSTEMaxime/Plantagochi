package fr.exia.plantagochi.model;

import java.util.ArrayList;
import java.util.List;

public class Serre {

	private List<Plante> plantes;

	public Serre() {
		this.plantes = new ArrayList<>();
	}

	public List<Plante> getPlantes() {
		return plantes;
	}

	public void addPlante(Plante plante) {
		this.plantes.add(plante);
	}

	public void removePlante(Plante plante) {
		this.plantes.remove(plante);
	}

	public List<Plante> getPlantesByEspece(Espece espece) {

		List<Plante> output = new ArrayList<>();

		for (Plante p : plantes) {
			if (p.getEspece() == espece)
				output.add(p);
		}

		return output;
	}

	public Plante getPlante(int i) {
		for (Plante plante : plantes){
			if (plante.getIDPlante() == i)	{
				return plante;
			}
		}
		return null;
	}

}
