package View.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;

	public void backgroundColor(int hex) {
		setBackground(new Color(hex));
	}
	
	public void border() {
		setLayout(new BorderLayout());
	}
	
	public void flow() {
		setLayout(new FlowLayout());
	}
	
	public void flow(int align) {
	    setLayout(new FlowLayout(align));
	}
	public void size(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	public void box(String type) {
		if (type.equalsIgnoreCase("col")) {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		} else {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		}
	}
}
