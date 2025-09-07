package View.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

import Controller.ControladorEstudiantes;
import Model.Facultad;
import View.Paneles.NavBar;
import View.Paneles.PanelAgregarMateria;
import View.Paneles.PanelCarreras;
import View.Paneles.PanelEstudiantes;
import View.Paneles.PanelMaterias;

public class Ventana extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final Panel body = new Panel();
	private static Map<String, Panel> paneles = new HashMap<String, Panel>();
	private static Panel panelActual;
	
	public Ventana() {
		setTitle("facultad");
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		init();
		setVisible(true);
	}
	
	public void init() {
		body.border();
		add(body, BorderLayout.CENTER);
		body.setBackground(background);
		var nav = new NavBar();
		body.add(nav, BorderLayout.NORTH);
		panelActual = new PanelCarreras();
		paneles.put("Carreras",panelActual);
		paneles.put("Materias",new PanelMaterias());
		paneles.put("AgregarMateria",new PanelAgregarMateria());
		ControladorEstudiantes ctrlEstudiantes = new ControladorEstudiantes(Facultad.getInstanciaFacultad());
		paneles.put("Estudiantes", new PanelEstudiantes(ctrlEstudiantes));
		body.add(panelActual, BorderLayout.CENTER);
	}
	public static void CambiarPanel(String p) {
		var panel = paneles.get(p);
		if (panel==null) return;
		body.remove(panelActual);
		panelActual= panel;
		body.add(panelActual, BorderLayout.CENTER);
		body.revalidate();
		body.repaint();
	}
	
	public static Color background = new Color(0x303030);
	public static Color nav = new Color(0x404040);
	public static Color text = new Color(0xe0e0e0);
	public static Font fuente = new Font("Arial", Font.BOLD, 20);
	public static Font fuenteNav = new Font("Arial", Font.BOLD, 20);
	
}
