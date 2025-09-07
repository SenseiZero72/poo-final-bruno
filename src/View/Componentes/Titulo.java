package View.Componentes;

import javax.swing.JLabel;

public class Titulo extends JLabel {

	private static final long serialVersionUID = 1L;

	public Titulo(String text) {
		super(text);
		
		setForeground(Ventana.text);
		setFont(Ventana.fuente);
	}
}
