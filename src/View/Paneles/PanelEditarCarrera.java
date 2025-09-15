package View.Paneles;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Materia;
import Model.Carrera;
import View.Componentes.Panel;
import View.Componentes.Titulo;
import View.Componentes.Ventana;

public class PanelEditarCarrera extends Panel {
    private static final long serialVersionUID = 1L;
    private Carrera carrera;

    public PanelEditarCarrera(Carrera carrera) {
        this.carrera = carrera;

        box("col"); // Layout vertical
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Ventana.background);

        // Contenedor principal vertical
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setOpaque(false);
        contenedor.setAlignmentX(LEFT_ALIGNMENT);

        // --- Título ---
        Titulo titulo = new Titulo(carrera.getNombre());
        titulo.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(titulo);
        contenedor.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- Datos de la carrera ---
        JLabel lblOptativas = new JLabel("Cantidad de optativas necesarias: " + carrera.getCantidadOptativasNecesarias());
        lblOptativas.setForeground(new Color(0xcccccc));
        lblOptativas.setFont(new Font("Arial", Font.BOLD, 18));
        lblOptativas.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(lblOptativas);
        contenedor.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel lblTipoPlan = new JLabel("Tipo de plan: " + carrera.getTipoPlan());
        lblTipoPlan.setForeground(new Color(0xcccccc));
        lblTipoPlan.setFont(new Font("Arial", Font.BOLD, 18));
        lblTipoPlan.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(lblTipoPlan);
        contenedor.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- ComboBox de materias ---
        JLabel lblMaterias = new JLabel("Materias de la carrera:");
        lblMaterias.setForeground(new Color(0xcccccc));
        lblMaterias.setFont(new Font("Arial", Font.BOLD, 18));
        lblMaterias.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(lblMaterias);
        contenedor.add(Box.createRigidArea(new Dimension(0, 5)));

        List<Materia> materias = carrera.getPlan().getMaterias();
        String[] nombresMaterias = new String[materias.size()];
        for (int i = 0; i < materias.size(); i++) {
            nombresMaterias[i] = materias.get(i).getNombre();
        }

        JComboBox<String> comboMaterias = new JComboBox<>(nombresMaterias);
        comboMaterias.setMaximumSize(new Dimension(400, 30));
        comboMaterias.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(comboMaterias);
        contenedor.add(Box.createRigidArea(new Dimension(0, 10)));

        // --- Etiqueta de correlativas ---
        JLabel lblCorrelativas = new JLabel();
        lblCorrelativas.setForeground(new Color(0xcccccc));
        lblCorrelativas.setFont(new Font("Arial", Font.BOLD, 16));
        lblCorrelativas.setAlignmentX(LEFT_ALIGNMENT);
        contenedor.add(lblCorrelativas);

        // --- Map de correlativas de prueba ---
        Map<String, String[]> correlativasPrueba = new HashMap<>();
        correlativasPrueba.put("Matemática I", new String[]{"Física I", "Introducción a la Programación"});
        correlativasPrueba.put("Física I", new String[]{"Matemática I"});
        correlativasPrueba.put("Programación", new String[]{"Matemática I", "Lógica"});

        // Listener para actualizar correlativas reales
        comboMaterias.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            Materia materiaObj = null;

            // Buscar la materia en la lista de la carrera
            for (Materia m : carrera.getPlan().getMaterias()) {
                if (m.getNombre().equalsIgnoreCase(materiaSeleccionada)) {
                    materiaObj = m;
                    break;
                }
            }

            if (materiaObj != null) {
                List<Materia> correlativas = carrera.getPlan().getCorrelativas(materiaObj);
                if (correlativas.isEmpty()) {
                    lblCorrelativas.setText("Correlativas: Ninguna");
                } else {
                    String texto = correlativas.stream()
                            .map(Materia::getNombre)
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("");
                    lblCorrelativas.setText("Correlativas: " + texto);
                }
            } else {
                lblCorrelativas.setText("Correlativas: Ninguna");
            }
        });
        if (comboMaterias.getItemCount() > 0) {
            comboMaterias.setSelectedIndex(0);
            comboMaterias.getActionListeners()[0].actionPerformed(null); // dispara el listener para la primera materia
        } else {
            lblCorrelativas.setText("No hay correlativas disponibles");
        }

        // --- Agregar contenedor al panel principal ---
        add(contenedor);
    }
}
