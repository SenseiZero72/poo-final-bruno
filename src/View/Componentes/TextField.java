package View.Componentes;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
    public TextField() {
        setBackground(Ventana.backgroundTabla);
        setForeground(Ventana.text);
        setBorder(BorderFactory.createLineBorder(Ventana.backgroundEncabezadoTabla));
        setFont(Ventana.fuenteNav);
        setCaretColor(Ventana.text);

        var dimension = new Dimension(600, 60);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }
}
