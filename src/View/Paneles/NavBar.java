package View.Paneles;

import View.Componentes.BotonBase;
import View.Componentes.Panel;
import View.Componentes.Ventana;

public class NavBar extends Panel {
	private static final long serialVersionUID = 1L;
	
	public NavBar() {
		box("");
		size(0,50);
		setBackground(Ventana.nav);
		
		var botonEstudiantes= new BotonBase("Estudiantes");
		botonEstudiantes.size(100,0);
		botonEstudiantes.setFontLabel(Ventana.fuenteNav);
		add(botonEstudiantes);
		botonEstudiantes.addActionListener((e) -> Ventana.CambiarPanel("Estudiantes"));
		
		var botonCarreras= new BotonBase("Carreras");
		botonCarreras.size(100,0);
		botonCarreras.setFontLabel(Ventana.fuenteNav);
		add(botonCarreras);
		botonCarreras.addActionListener((e) -> Ventana.CambiarPanel("Carreras"));

		
		var botonMaterias= new BotonBase("Materias");
		botonMaterias.size(100,0);
		botonMaterias.setFontLabel(Ventana.fuenteNav);
		add(botonMaterias);
		botonMaterias.addActionListener((e) -> Ventana.CambiarPanel("Materias"));

	}
	
	
}
