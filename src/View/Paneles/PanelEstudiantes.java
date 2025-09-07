package View.Paneles;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;
import Controller.ControladorEstudiantes;
import Model.Alumno;

import java.util.List;

public class PanelEstudiantes extends Panel {
    private static final long serialVersionUID = 1L;
    private JList<String> listaEstudiantes;
    private DefaultListModel<String> modeloLista;
    private ControladorEstudiantes controlador;

    public PanelEstudiantes(ControladorEstudiantes controlador) {
        this.controlador = controlador;

        var titulo = new Titulo("Listado de Estudiantes");
        box("col");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);

        modeloLista = new DefaultListModel<>();
        listaEstudiantes = new JList<>(modeloLista);
        var scroll = new JScrollPane(listaEstudiantes);

        add(titulo);
        add(scroll);

        cargarDatos();
    }

    public void cargarDatos() {
        modeloLista.clear();
        List<Alumno> alumnos = controlador.obtenerListaAlumnos();
        for (Alumno a : alumnos) {
            modeloLista.addElement(a.getDni() + " - " + a.getNombre());
        }
    }
}
