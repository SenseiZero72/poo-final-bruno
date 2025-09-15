package View.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;

import Controller.ControladorEstudiantes;
import Model.*;
import View.Paneles.*;

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
		paneles.put("Agregar Carrera", new PanelAgregarCarrera());
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
	public static Color backgroundEncabezadoTabla = new Color(0x202020);
	public static Color backgroundTabla = new Color(0x404040);
	public static Color nav = new Color(0x404040);
	public static Color text = new Color(0xe0e0e0);
	public static Font fuenteTitulo = new Font("Arial", Font.BOLD, 30);
	public static Font fuenteNav = new Font("Arial", Font.BOLD, 20);
	
	public static Color boton_editar_normal  = new Color(76, 175, 80);
    public static Color boton_editar_hover   = new Color(102, 187, 106);
    public static Color boton_editar_pressed = new Color(56, 142, 60);
    
    public static final Color boton_eliminar_normal  = new Color(244, 67, 54);
    public static final Color boton_eliminar_hover = new Color(229, 115, 115);
    public static final Color boton_eliminar_pressed = new Color(211, 47, 47);

	public static final Color boton_nuevo_normal  = new Color(140, 47, 211);
	public static final Color boton_nuevo_hover = new Color(162, 115, 229);
	public static final Color boton_nuevo_pressed = new Color(127, 54, 244);

	public static final Color boton_volver_normal  = new Color(153, 151, 156);
	public static final Color boton_volver_hover = new Color(173, 171, 176);
	public static final Color boton_volver_pressed = new Color(112, 112, 115);

	public static final String[] planes = new String[] { "A", "B", "C", "D", "E" };
	public static final Border bordeGeneral = BorderFactory.createEmptyBorder(10,100,10,100);
	
}
