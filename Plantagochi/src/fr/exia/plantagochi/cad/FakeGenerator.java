package fr.exia.plantagochi.cad;

import fr.exia.plantagochi.model.Plante;
import fr.exia.plantagochi.model.Serre;

public class FakeGenerator implements CAD {

	private Serre model;

	@Override
	public void setModel(Serre serre) {
		this.model = serre;
	}

	@Override
	public float getTemperatureAIr(int IDPlante) {
		return (float) (Math.random() * 40);
	}

	@Override
	public float getHumiditeAir(int IDPlante) {
		return (float) (Math.random() * 100);
	}

	@Override
	public float getHumiditeSol(int IDPlante) {
		return (float) (Math.random() * 100);
	}

	@Override
	public float getLuminosite(int IDPlante) {
		return (float) (Math.random() * 100);
	}

	public void run() {

		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}

			int i = 1;

			for (Plante plante : model.getPlantes()) {
				plante.setHumiditeAir(getHumiditeAir(i));
				plante.setHumiditeSol(getHumiditeSol(i));
				//plante.setTauxLuminosite(getLuminosite(i));
				plante.setTemperatureAir(getTemperatureAIr(i));

				plante.hasBeenChanged();
				plante.notifyObservers(i);
				i++;
			}
		}
	}
}
