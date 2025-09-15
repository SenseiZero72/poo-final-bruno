package View.botones;

import View.Componentes.BotonBase;
import View.Componentes.Ventana;

import javax.swing.*;
import java.awt.*;

public class BotonNuevo extends BotonBase {

    public BotonNuevo() {
        this("Nuevo");
    }

    public BotonNuevo(String titulo) {
        super(titulo);
        size(200, 80);
        setFontLabel(Ventana.fuenteNav);
        setColors(Ventana.boton_nuevo_normal, Ventana.boton_nuevo_hover, Ventana.boton_nuevo_pressed, Ventana.text);
    }

    public void agregarContenedor(JPanel contenedor) {
        contenedor.add(this, BorderLayout.EAST);
    }
}
