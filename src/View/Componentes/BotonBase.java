package View.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotonBase extends Panel {
    private JLabel label;
    private boolean hovered = false;
    private boolean pressed = false;

    // Colores personalizables
    private Color colorNormal = new Color(0x404040);
    private Color colorHover = new Color(0x505050);
    private Color colorPressed = new Color(0x303030);
    private Color textColor = new Color(0xe0e0e0);
    
    private ActionListener actionListener;

    public BotonBase(String text) {
        border();
        setBackground(colorNormal);

        // JLabel centrado
        label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(textColor);
        add(label, BorderLayout.CENTER);

        // Cursor de mano
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Mouse listener para hover y click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                updateBackground();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                pressed = false;
                updateBackground();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                updateBackground();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                updateBackground();
                if (hovered && actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, label.getText()));
                }
            }
        });
    }

    private void updateBackground() {
        if (pressed) {
            setBackground(colorPressed);
        } else if (hovered) {
            setBackground(colorHover);
        } else {
            setBackground(colorNormal);
        }
        repaint();
    }

    public void setColors(int normal, int hover, int pressed, int text) {
        colorNormal = new Color(normal);
        colorHover = new Color(hover);
        colorPressed = new Color(pressed);
        textColor = new Color(text);
        label.setForeground(textColor);
        updateBackground();
    }
    
    public void setColors(Color normal, Color hover, Color pressed, Color text) {
        colorNormal = normal;
        colorHover = hover;
        colorPressed = pressed;
        textColor = text;
        label.setForeground(textColor);
        updateBackground();
    }
    
    public void setFontLabel(String nombre, int estilo, int tamaño) {
        label.setFont(new Font(nombre, estilo, tamaño));
    }
    
    public void setFontLabel(Font font) {
        label.setFont(font);
    }


    public void setText(String text) {
        label.setText(text);
    }
    
    public void addActionListener(ActionListener listener) {
        this.actionListener = listener;
    }
}
