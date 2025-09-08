package View.Paneles;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import View.Componentes.BotonBase;
import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;
import Controller.ControladorEstudiantes;
import java.awt.FlowLayout;

public class PanelEstudiantes extends Panel {
    private static final long serialVersionUID = 1L;
    
    public PanelEstudiantes(ControladorEstudiantes controlador) {
    	box("col");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);
        
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topBar.setOpaque(false); 

        var titulo = new Titulo("Listado de Estudiantes");

        var botonAgregar = new BotonBase("Agregar Estudiante");
        botonAgregar.setFontLabel(Ventana.fuenteNav);
        botonAgregar.size(250, 30); 
        botonAgregar.addActionListener(e -> {
            Ventana.CambiarPanel("AgregarCarrera"); 
        });

        topBar.add(titulo);
        topBar.add(botonAgregar);

        add(topBar);
    }
}
