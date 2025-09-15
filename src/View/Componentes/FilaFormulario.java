package View.Componentes;

import java.awt.*;

public class FilaFormulario extends Panel {
    public FilaFormulario(Label label, Component campo) {
        Dimension size = new Dimension(Integer.MAX_VALUE, 60);
        border();
        setBackground(Ventana.background);
        setPreferredSize(size);
        setMaximumSize(size);
        add(label, BorderLayout.WEST);
        add(campo, BorderLayout.EAST);
    }
}
