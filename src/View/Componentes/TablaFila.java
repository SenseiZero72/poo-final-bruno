package View.Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.function.Consumer;

public class TablaFila extends Panel {
	
	private BotonBase btnEditar;
	private String[] valores;
	
	public TablaFila(String[] valores, int gap, Color color, boolean acciones) {
		this.valores = valores;
		
		box("");
		padding(5, 5);
		setBackground(color);

		int columnas = valores.length;
		int height = 40;

		for (int i = 0; i < columnas; i++) {
			
            Panel celda = new Panel();
            celda.setBackground(color);
            celda.setPreferredSize(new Dimension(100, height));
            celda.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
            
            JLabel label = new JLabel(valores[i], SwingConstants.LEFT);
            label.setForeground(Ventana.text);
            label.setFont(Ventana.fuenteNav);
            celda.setLayout(new java.awt.BorderLayout());
            celda.add(label, java.awt.BorderLayout.CENTER);
            add(celda);

            // Gap entre columnas, excepto después de la última            
            if (i < columnas - 1 || (acciones && i == columnas - 1)) {
            	addGap(gap, 0);
            }
        }
		
		if (acciones) {
            Panel celdaAcciones = new Panel();
            celdaAcciones.setBackground(color);
            celdaAcciones.setPreferredSize(new Dimension(100, height));
            celdaAcciones.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
            celdaAcciones.box("");
            
            btnEditar = new BotonBase("Editar");
            btnEditar.setFontLabel(Ventana.fuenteNav);
            btnEditar.setColors(
            		Ventana.boton_editar_normal,
            		Ventana.boton_editar_hover,
            		Ventana.boton_editar_pressed,
            		Ventana.text
            );

            Dimension btnSize = new Dimension(90, 25);
            btnEditar.setPreferredSize(btnSize);

            celdaAcciones.add(btnEditar);
            celdaAcciones.addGap(5, 0);

            add(celdaAcciones);
        }
	}
	
	public void agregarAccionEditar(Consumer<String[]> consumer) {
		if (btnEditar!=null) {
			btnEditar.addActionListener((e) -> consumer.accept(valores));
		}
	}


}
