package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class RectangleShape extends Shape {

    public RectangleShape(Color color, boolean filled, boolean dotted, int x1, int y1, int x2, int y2) {
        super(color, filled, dotted, x1, y1, x2, y2);
    }

  
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        if (dotted) {
            float[] dash = {5, 5};
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dash, 0));
        } else {
            g2d.setStroke(new BasicStroke(2));
        }
        if (filled) {
            g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else {
            g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }
}
