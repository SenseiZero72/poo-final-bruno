package View.Componentes;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String> {
    public ComboBox(String[] items) {
        super(items);

        setBackground(Ventana.backgroundTabla);
        setForeground(Ventana.text);
        setFont(Ventana.fuenteNav);
        setBorder(BorderFactory.createLineBorder(Ventana.backgroundEncabezadoTabla));

        var size = new Dimension(600, 60);
        setPreferredSize(size);
        setMaximumSize(size);

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                label.setFont(Ventana.fuenteNav);

                if (index == -1) {
                    // Ítem visible cuando el combo está cerrado
                    if (hasFocus()) {
                        label.setBackground(Ventana.backgroundEncabezadoTabla); // o algún color de foco suave
                        label.setForeground(Ventana.text); // el color del texto cuando enfocado
                    } else {
                        label.setBackground(Ventana.backgroundTabla);
                        label.setForeground(Ventana.text);
                    }
                } else {
                    // Ítems del menú desplegable
                    if (isSelected) {
                        label.setBackground(Ventana.backgroundEncabezadoTabla);
                        label.setForeground(Ventana.text);
                    } else {
                        label.setBackground(Ventana.backgroundTabla);
                        label.setForeground(Ventana.text);
                    }
                }

                return label;
            }
        });


    }
}
