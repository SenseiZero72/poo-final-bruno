package View.Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class Celda extends Panel {

    private String texto;

    public Celda(String texto) {
        this.texto = texto;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 15; // radio de las esquinas
        Shape round = new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, arc, arc);

        // fondo
        g2.setColor(Color.WHITE);
        g2.fill(round);

        // borde
        g2.setColor(Color.LIGHT_GRAY);
        g2.draw(round);

        g2.dispose();

        // dibujar texto centrado
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(texto)) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g.setColor(Color.BLACK);
        g.drawString(texto, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 30);
    }
}
