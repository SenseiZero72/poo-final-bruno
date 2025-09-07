package View.Paneles;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import View.Componentes.BotonBase;
import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;

public class PanelCarreras extends Panel{
	private static final long serialVersionUID = 1L;

	public PanelCarreras() {
		box("col");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);
        
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topBar.setOpaque(false); 

        var titulo = new Titulo("Listado de Carreras");

        var botonAgregar = new BotonBase("Agregar Carrera");
        botonAgregar.setFontLabel(Ventana.fuente);
        botonAgregar.size(250, 30); 
        botonAgregar.addActionListener(e -> {
            Ventana.CambiarPanel("AgregarCarrera"); 
        });

        topBar.add(titulo);
        topBar.add(botonAgregar);

        add(topBar);
    }
}
