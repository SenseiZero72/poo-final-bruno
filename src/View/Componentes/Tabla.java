package View.Componentes;

import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class Tabla extends Panel {
	
	private String[] columnas;
	private String[][] filas;
	
	public Tabla(String[][] filas, int gap, Consumer<String[]> editar, Consumer<String[]> eliminar) {
		box("col");
		setBackground(Ventana.background);
		
		TablaFila encabezado = new TablaFila(filas[0], gap, Ventana.backgroundEncabezadoTabla, false);
		encabezado.setAlignmentX(LEFT_ALIGNMENT);
		add(encabezado);
		
		for (int i = 1; i < filas.length; i++) {
            TablaFila fila = new TablaFila(filas[i], gap, Ventana.backgroundTabla, true);
            fila.agregarAccionEditar(editar);
            fila.agregarAccionEliminar(eliminar);
            fila.setAlignmentX(LEFT_ALIGNMENT);
            add(fila);

        }
		
		padding(10, 0);
	}
}
