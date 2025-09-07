package View.Paneles;

import javax.swing.BorderFactory;

import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;

public class PanelCarreras extends Panel{
	private static final long serialVersionUID = 1L;

	public PanelCarreras() {
		var titulo = new Titulo("Listado de Carreras");
		box("col");
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setBackground(Ventana.background);
		add(titulo);
	}
}
