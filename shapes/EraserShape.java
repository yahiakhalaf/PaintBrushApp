package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class EraserShape extends Shape {

    public EraserShape(int x1, int y1, int x2, int y2) {
        super(Color.WHITE, false, false, x1, y1, x2, y2);
    }

    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
       // g2d.setStroke(new BasicStroke(10)); 
        //g2d.drawLine(x1, y1, x2, y2);
		g2d.fillRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x2-x1),Math.abs(y2-y1));
    }
}
