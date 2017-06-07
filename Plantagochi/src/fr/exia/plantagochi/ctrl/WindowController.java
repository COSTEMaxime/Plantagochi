package fr.exia.plantagochi.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import fr.exia.plantagochi.model.Plante;
import fr.exia.plantagochi.model.Serre;
import fr.exia.plantagochi.view.Window;

public class WindowController implements Runnable, Observer, ActionListener{

	private Serre model;
	private Window vue;
	
	public WindowController(Serre serre) {
		this.model = serre;
		for (Plante plante : serre.getPlantes()){
			plante.addObserver(this);
		}
	}

	public Serre getModel() {
		return model;
	}


	public Window getVue() {
		return vue;
	}
	
	@Override
	public void run() {
		if(!SwingUtilities.isEventDispatchThread()){
			System.err.println("Erreur, le lancement du controlleur doit se faire dans le thread de l'IHM");
		}
		this.vue = new Window();
		this.vue.getBoutonAllumer().addActionListener(this);
		this.vue.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof Plante)	{
			Plante plante = (Plante) o;
			
			//TODO
			if(plante.getIDPlante() != 1){
				return;
			}
			String text = String.format("%.1f %%", plante.getHumiditeAir());
			vue.getLabelHumiditeAir().setText(text);
			text = String.format("%.1f %%", plante.getHumiditeSol());
			vue.getLabelHumiditeSol().setText(text);
			text = String.format("%.1f %%", plante.getTemperatureAir());
			vue.getLabelTemperatureAir().setText(text);
			
			if(plante.getTauxLuminosite() < 50)	{
				vue.getBoutonAllumer().setText("Allumer");
				vue.getIconeLuminosite().setIcon(new ImageIcon(Window.class.getResource("/fr/exia/plantagochi/view/icon-moon.jpg")));
			}	else	{
				vue.getBoutonAllumer().setText("Eteindre");
				vue.getIconeLuminosite().setIcon(new ImageIcon(Window.class.getResource("/fr/exia/plantagochi/view/icon-sun.jpg")));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Eteindre"))	{
			this.model.getPlante(1).setTauxLuminosite(0);
		} else	{
			this.model.getPlante(1).setTauxLuminosite(100);
		}
		
		this.model.getPlante(1).hasBeenChanged();
		this.model.getPlante(1).notifyObservers(1);
	}	
}
