package View.Paneles;

import javax.swing.BorderFactory;

import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;

public class PanelMaterias extends Panel{
	private static final long serialVersionUID = 1L;
	
	public PanelMaterias() {
		var titulo = new Titulo("Listado de Materias");
		box("col");
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setBackground(Ventana.background);
		add(titulo);
	}
}
