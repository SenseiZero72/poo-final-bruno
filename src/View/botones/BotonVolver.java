package View.botones;

import View.Componentes.BotonBase;
import View.Componentes.Ventana;

import javax.swing.*;
import java.awt.*;

public class BotonVolver extends BotonBase {

    public BotonVolver() {
        this("Volver", "");
    }

    public BotonVolver(String titulo, String dondeVuelve) {
        super(titulo);
        size(200, 80);
        setFontLabel(Ventana.fuenteNav);
        setColors(Ventana.boton_volver_normal, Ventana.boton_volver_hover, Ventana.boton_volver_pressed, Ventana.text);
        addActionListener((e) -> Ventana.CambiarPanel(dondeVuelve));
    }

    public void agregarContenedor(JPanel contenedor) {
        contenedor.add(this, BorderLayout.WEST);
    }
}
