package View.Paneles;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.List;

import Controller.ControladorMateria;
import View.Componentes.BotonBase;
import View.Componentes.Panel;
import View.Componentes.ScrollPanel;
import View.Componentes.Tabla;
import View.Componentes.Titulo;
import View.Componentes.Ventana;

public class PanelMaterias extends Panel {
    private static final long serialVersionUID = 1L;
    private ControladorMateria controladorMateria = new ControladorMateria();

    public PanelMaterias() {
        box("col");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);

        // Top bar con título y botón
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topBar.setOpaque(false);

        var titulo = new Titulo("Listado de Materias");
        var botonAgregar = new BotonBase("Agregar Materia");
        botonAgregar.setFontLabel(Ventana.fuenteNav);
        botonAgregar.size(250, 30);
        botonAgregar.addActionListener(e -> Ventana.CambiarPanel("AgregarMateria"));

        topBar.add(titulo);
        topBar.add(botonAgregar);
        add(topBar);

        // Datos de materias desde el controlador
        List<String> materias = controladorMateria.getTodasLasMaterias();

        // Construir matriz de datos para la tabla
        String[][] datos = new String[materias.size() + 1][2]; // 1 fila encabezado + N materias
        datos[0] = new String[] {"ID", "Nombre de la Materia", "Acciones"};

        for (int i = 0; i < materias.size(); i++) {
            datos[i + 1][0] = String.valueOf(i + 1);       // ID
            datos[i + 1][1] = materias.get(i);             // Nombre de la materia
        }

        // Crear tabla
        Tabla tablaMaterias = new Tabla(datos, 4, data ->
                System.out.println("Editar materia: " + data[1])
        );

        ScrollPanel scroll = new ScrollPanel(tablaMaterias, Ventana.background, Ventana.backgroundTabla);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        add(scroll);
    }
}
