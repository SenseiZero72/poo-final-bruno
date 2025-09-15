package View.Paneles;

import View.Componentes.*;
import View.Componentes.Label;
import View.Componentes.Panel;
import View.Componentes.TextField;
import View.botones.BotonNuevo;
import View.botones.BotonVolver;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarCarrera extends Panel {
    public PanelAgregarCarrera() {
        border();
        var titulo = new Titulo("Agregar una Carrera");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);

        var contenedorTitulo = new Panel();
        contenedorTitulo.size(1000, 80);
        contenedorTitulo.setMaximumSize(new Dimension(1500, 80));
        contenedorTitulo.border();
        contenedorTitulo.setBorder(Ventana.bordeGeneral);
        contenedorTitulo.setBackground(Ventana.background);
        contenedorTitulo.add(titulo, BorderLayout.EAST);
        add(contenedorTitulo, BorderLayout.NORTH);

        var botonVolver = new BotonVolver("Volver", "Carreras");
        botonVolver.agregarContenedor(contenedorTitulo);

        var formulario = new Panel();
        formulario.setBorder(Ventana.bordeGeneral);
        formulario.box("col");
        formulario.setBackground(Ventana.background);
        add(formulario, BorderLayout.CENTER);

        var labelNombre = new Label("Nombre de la Carrera:");
        var campoNombre = new TextField();
        formulario.add(new FilaFormulario(labelNombre, campoNombre));

        var labelOptativas = new Label("Cantidad de optativas:");
        var campoOptativas = new TextField();
        formulario.add(new FilaFormulario(labelOptativas, campoOptativas));

        var labelPlan = new Label("Tipo de Plan:");
        var comboPlan = new ComboBox(Ventana.planes);
        formulario.add(new FilaFormulario(labelPlan, comboPlan));

        var botonGuardar = new BotonNuevo();
        botonGuardar.addActionListener((e) -> System.out.println("Guardando Carrera"));
        var contenedorGuardar = new Panel();
        contenedorGuardar.border();
        contenedorGuardar.setBackground(Ventana.background);
        contenedorGuardar.add(botonGuardar, BorderLayout.EAST);
        contenedorGuardar.setBorder(Ventana.bordeGeneral);

        add(contenedorGuardar, BorderLayout.SOUTH);
    }
}
