package View.Paneles;

import java.awt.*;

import javax.swing.BorderFactory;

import View.Componentes.*;
import View.Componentes.Panel;
import View.botones.BotonNuevo;

public class PanelCarreras extends Panel{
	private static final long serialVersionUID = 1L;
	private static Tabla listaCarreras;
	
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
		
		String[][] datos = new String[10][4];
		
		datos[0] = new String[] {"ID", "Nombre", "Apellido", "Edad", "Acciones"};

		for (int i = 1; i < datos.length; i++) {
		    datos[i][0] = String.valueOf(i + 1);          // ID
		    datos[i][1] = "Nombre_" + (i + 1);            // Nombre
		    datos[i][2] = "Apellido_" + (i + 1);          // Apellido
		    datos[i][3] = String.valueOf(18 + (i % 50));  // Edad entre 18 y 67
		}

		listaCarreras = new Tabla(datos, 4, (data) -> System.out.println("Editar: " + data[0]), (data) -> System.out.println("Eliminar: " + data[0]));
		ScrollPanel scroll = new ScrollPanel(listaCarreras, Ventana.background, Ventana.backgroundTabla);
		scroll.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
		//scroll.setPreferredSize(new Dimension(600, 400));
		add(scroll);
	}
}
