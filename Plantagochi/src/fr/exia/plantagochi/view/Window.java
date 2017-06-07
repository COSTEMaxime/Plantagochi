package fr.exia.plantagochi.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class Window extends JFrame {

	private JPanel contentPane;
	private JLabel bg;
	private JLabel labelTemperatureAir;
	private JLabel labelHumiditeAir;
	private JLabel labelHumiditeSol;
	private JLabel IconeLuminosite;
	private JButton boutonAllumer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setTitle("Plantagochi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IconeLuminosite = new JLabel("");
		IconeLuminosite.setIcon(new ImageIcon(Window.class.getResource("/fr/exia/plantagochi/view/icon-moon.jpg")));
		IconeLuminosite.setBounds(23, 22, 50, 48);
		contentPane.add(IconeLuminosite);
		
		labelTemperatureAir = new JLabel("0 T\u00B0");
		labelTemperatureAir.setForeground(new Color(0, 128, 0));
		labelTemperatureAir.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelTemperatureAir.setBounds(349, 70, 81, 25);
		contentPane.add(labelTemperatureAir);
		
		labelHumiditeAir = new JLabel("0 %");
		labelHumiditeAir.setForeground(new Color(0, 0, 255));
		labelHumiditeAir.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelHumiditeAir.setBounds(349, 134, 83, 25);
		contentPane.add(labelHumiditeAir);
		
		labelHumiditeSol = new JLabel("0 %");
		labelHumiditeSol.setForeground(Color.BLUE);
		labelHumiditeSol.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelHumiditeSol.setBounds(268, 474, 81, 25);
		contentPane.add(labelHumiditeSol);
		
		boutonAllumer = new JButton("Allumer");
		boutonAllumer.setBounds(23, 479, 89, 23);
		contentPane.add(boutonAllumer);
		
		bg = new JLabel("");
		bg.setIcon(new ImageIcon(Window.class.getResource("/fr/exia/plantagochi/view/background-plante.png")));
		bg.setBounds(23, 24, 356, 481);
		contentPane.add(bg);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getBg() {
		return bg;
	}

	public JLabel getLabelTemperatureAir() {
		return labelTemperatureAir;
	}

	public JLabel getLabelHumiditeAir() {
		return labelHumiditeAir;
	}

	public JLabel getLabelHumiditeSol() {
		return labelHumiditeSol;
	}

	public JLabel getIconeLuminosite() {
		return IconeLuminosite;
	}

	public JButton getBoutonAllumer() {
		return boutonAllumer;
	}

	public void setIconeLuminosite(JLabel iconeLuminosite) {
		IconeLuminosite = iconeLuminosite;
	}
}
