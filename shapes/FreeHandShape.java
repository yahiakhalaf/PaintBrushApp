package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class FreeHandShape extends Shape {

    public FreeHandShape(Color color, int x1, int y1, int x2, int y2) {
        super(color, false, false, x1, y1, x2, y2);
    }

 
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2)); // Simple stroke for freehand
        g2d.drawLine(x1, y1, x2, y2);
    }
}
