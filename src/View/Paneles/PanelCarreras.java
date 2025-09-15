package View.Paneles;
import Controller.ControladorCarreras;
import Model.Carrera;
import View.Componentes.*;
import View.Componentes.Panel;
import View.botones.BotonNuevo;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PanelCarreras extends Panel{
	private static final long serialVersionUID = 1L;
	private static Tabla listaCarreras;
    private ControladorCarreras controladorCarreras = new ControladorCarreras();

    public PanelCarreras() {
		box("col");
		var titulo = new Titulo("Listado de Carreras");
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setBackground(Ventana.background);
		
		var contenedorTitulo = new Panel();
		contenedorTitulo.size(1000, 80);
		contenedorTitulo.setMaximumSize(new Dimension(1500, 80));
		contenedorTitulo.border();
		contenedorTitulo.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
		contenedorTitulo.setBackground(Ventana.background);
		contenedorTitulo.add(titulo, BorderLayout.CENTER);
		add(contenedorTitulo);

        var agregar = new BotonNuevo("Agregar Carrera");
        agregar.agregarContenedor(contenedorTitulo);
        agregar.addActionListener((e) -> Ventana.CambiarPanel("Agregar Carrera"));

        Map<String, Carrera> nombresCarreras = controladorCarreras.obtenerNombresCarreras();
        String[][] datos = new String[nombresCarreras.size() + 1][2];
        datos[0] = new String[] {"ID", "Nombre de la Carrera", "Acciones"};

        int i = 1; // empezamos en 1 porque la fila 0 es el encabezado
        for (Carrera c : nombresCarreras.values()) {
            datos[i][0] = String.valueOf(i);    // ID
            datos[i][1] = c.getNombre();         // Nombre de la carrera
            i++;
        }
		
		listaCarreras = new Tabla(datos, 4, (data) -> System.out.println("Editar: " + data[0]));
		ScrollPanel scroll = new ScrollPanel(listaCarreras, Ventana.background, Ventana.backgroundTabla);
		scroll.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
		//scroll.setPreferredSize(new Dimension(600, 400));
		add(scroll);
	}
}
