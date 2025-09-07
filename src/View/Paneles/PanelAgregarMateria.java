package View.Paneles;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import View.Componentes.BotonBase;
import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;
import Model.Materia;

public class PanelAgregarMateria extends Panel {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombre;
    private JComboBox<Materia.Tipo> comboTipo;
    private JCheckBox chkPromocion;

    public PanelAgregarMateria() {
        box("col");
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);

        // Título
        var titulo = new Titulo("Agregar Materia");
        add(titulo);

        // Panel formulario
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3, 2, 10, 10));
        form.setOpaque(false);

        // Nombre
        form.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        form.add(txtNombre);

        // Tipo (Obligatoria / Optativa)
        form.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(Materia.Tipo.values());
        form.add(comboTipo);

        form.add(new JLabel("¿Tiene promoción?:"));
        chkPromocion = new JCheckBox();
        chkPromocion.setOpaque(true);
        form.add(chkPromocion);

        add(form);

        
        BotonBase btnGuardar = new BotonBase("Guardar");
        btnGuardar.size(120, 35);
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            Materia.Tipo tipo = (Materia.Tipo) comboTipo.getSelectedItem();
            boolean tienePromo = chkPromocion.isSelected();

            JOptionPane.showMessageDialog(this,
                    "Materia creada:\nNombre: " + nombre +
                    "\nTipo: " + tipo +
                    "\nPromoción: " + tienePromo,
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            Ventana.CambiarPanel("Materias");
        });
        add(btnGuardar);
    }
}
