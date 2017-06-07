package fr.exia.plantagochi.cad;

import fr.exia.plantagochi.model.Serre;

public interface CAD extends Runnable{

	public void setModel(Serre serre);
	public float getTemperatureAIr(int IDPlante);
	public float getHumiditeAir(int IDPlante);
	public float getHumiditeSol(int IDPlante);
	public float getLuminosite(int IDPlante);
}
