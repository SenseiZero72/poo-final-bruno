package View.Componentes;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text) {
        super(text);
        setPreferredSize(new Dimension(300, 60));
        setFont(Ventana.fuenteNav);
        setForeground(Ventana.text);
    }
}
