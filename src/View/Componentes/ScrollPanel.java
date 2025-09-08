package View.Componentes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollPanel extends JScrollPane {

    public ScrollPanel(Component view, Color trackColor, Color thumbColor) {
        super(view);
        setBorder(null); // sin borde
        setOpaque(false);
        getViewport().setOpaque(false);
        getVerticalScrollBar().setUnitIncrement(15);

        // Ocultar scrollbars hasta que hagan falta
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Personalizar barras de scroll
        getVerticalScrollBar().setUI(new RoundedScrollBarUI(trackColor, thumbColor));
        getHorizontalScrollBar().setUI(new RoundedScrollBarUI(trackColor, thumbColor));
        
        // Ajustar ancho/alto de scrollbars
        getVerticalScrollBar().setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
    }

    // Scrollbar redondeado y configurable
    private static class RoundedScrollBarUI extends BasicScrollBarUI {
        private final int arc = 15; // redondeo
        private final Color trackColor;
        private final Color thumbColor;

        public RoundedScrollBarUI(Color trackColor, Color thumbColor) {
            this.trackColor = trackColor;
            this.thumbColor = thumbColor;
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if (!c.isEnabled() || thumbBounds.width <= 0 || thumbBounds.height <= 0) {
                return;
            }
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, arc, arc);

            g2.dispose();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(trackColor);
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);

            g2.dispose();
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }
}
