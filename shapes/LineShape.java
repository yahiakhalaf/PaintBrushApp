package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class LineShape extends Shape {

    public LineShape(Color color, boolean filled, boolean dotted, int x1, int y1, int x2, int y2) {
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
        g2d.drawLine(x1, y1, x2, y2);
    }
}
