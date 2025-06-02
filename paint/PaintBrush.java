package paint;

import shapes.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PaintBrush extends Applet implements MouseListener, MouseMotionListener, ActionListener {
	//initializing the parameters
    private ArrayList<shapes.Shape> shapes = new ArrayList<>();
    private String currentShapeType = "FreeHand";
    private Color currentColor = Color.BLACK;
    private boolean filled = false;
    private boolean dotted = false;
    private int startX, startY, endX, endY;

   private BufferedImage offscreenImage; 
    private Graphics2D offscreenGraphics; 
    //initializing  buttons and checkboxes
    private Button btnRed, btnGreen, btnBlue, btnYellow, btnBlack, btnWhite, btnCyan;
    private Button btnMagenta, btnOrange, btnPink, btnDarkGray, btnLightGray;
    private Button btnClear, btnUndo;
    private Button btnRect, btnOval, btnLine, btnFreeHand, btnEraser;
    private Button btnSave, btnOpen;
    private Checkbox chkDotted, chkFilled;

    public void init() {
		
		setSize(1920,1080); // Set preferred applet siz
        // Initialize the offscreen image and graphics
        offscreenImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        offscreenGraphics = offscreenImage.createGraphics();
        offscreenGraphics.setColor(Color.WHITE); // Fill background with white
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());
		
		//creating buttons for colors
        btnRed = new Button(" ");
        btnGreen = new Button(" ");
        btnBlue = new Button(" ");
        btnYellow = new Button(" ");
        btnBlack = new Button(" ");
        btnWhite = new Button(" ");
        btnCyan = new Button(" ");
        btnMagenta = new Button(" ");
        btnOrange = new Button(" ");
        btnPink = new Button(" ");
        btnDarkGray = new Button(" ");
        btnLightGray = new Button(" ");
 
        btnClear = new Button("Clear All");
        btnUndo  = new Button("Undo");
        btnRect  = new Button("Rectangle");
        btnOval  = new Button("Oval");
        btnLine  = new Button("Line");
        btnFreeHand = new Button("FreeHand");
        btnEraser = new Button("Eraser");
        btnSave  = new Button("Save");
        btnOpen  = new Button("Open");

        btnRed.setBackground(Color.RED);
        btnGreen.setBackground(Color.GREEN);
        btnBlue.setBackground(Color.BLUE);
        btnYellow.setBackground(Color.YELLOW);
        btnBlack.setBackground(Color.BLACK);
        btnWhite.setBackground(Color.WHITE);
        btnCyan.setBackground(Color.CYAN);
        btnMagenta.setBackground(Color.MAGENTA);
        btnOrange.setBackground(Color.ORANGE);
        btnPink.setBackground(Color.PINK);
        btnDarkGray.setBackground(Color.DARK_GRAY);
        btnLightGray.setBackground(Color.LIGHT_GRAY);

        add(btnRed);
        add(btnGreen);
        add(btnBlue);
        add(btnYellow);
        add(btnBlack);
        add(btnWhite);
        add(btnCyan);
        add(btnMagenta);
        add(btnOrange);
        add(btnPink);
        add(btnDarkGray);
        add(btnLightGray);
        
        add(new Label("  "));
        
        add(btnLine);
        add(btnRect);
        add(btnOval);
        add(new Label("  "));
        add(btnFreeHand);
        add(btnEraser);
        add(btnUndo);
        add(new Label("  "));
        add(btnClear);
        add(btnSave);
        add(btnOpen);
        add(new Label("  "));
        
        chkDotted = new Checkbox("Dotted");
        chkFilled = new Checkbox("Filled");
        add(chkDotted);
        add(chkFilled);

        btnRed.addActionListener(this);
        btnGreen.addActionListener(this);
        btnBlue.addActionListener(this);
        btnYellow.addActionListener(this);
        btnBlack.addActionListener(this);
        btnWhite.addActionListener(this);
        btnCyan.addActionListener(this);
        btnMagenta.addActionListener(this);
        btnOrange.addActionListener(this);
        btnPink.addActionListener(this);
        btnDarkGray.addActionListener(this);
        btnLightGray.addActionListener(this);
        
        btnLine.addActionListener(this);
        btnRect.addActionListener(this);
        btnOval.addActionListener(this);
        btnFreeHand.addActionListener(this);
        btnClear.addActionListener(this);
        btnUndo.addActionListener(this);
        btnEraser.addActionListener(this);
        btnSave.addActionListener(this);
        btnOpen.addActionListener(this);

        chkDotted.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                dotted = chkDotted.getState();
            }
        });

        chkFilled.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                filled = chkFilled.getState();
            }
        });

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void update(Graphics g) {
        paint(g);  
    }

	public void paint(Graphics g) {
        // Clear the offscreen buffer
        offscreenGraphics.setColor(Color.WHITE);
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw all shapes on the offscreen buffer
        for (shapes.Shape shape : shapes) {
            shape.draw(offscreenGraphics);
        }

        // Draw the offscreen buffer on the screen
        g.drawImage(offscreenImage, 0, 0, this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRed) {
            currentColor = Color.RED;
        } else if (e.getSource() == btnGreen) {
            currentColor = Color.GREEN;
        } else if (e.getSource() == btnBlue) {
            currentColor = Color.BLUE;
        } else if (e.getSource() == btnYellow) {
            currentColor = Color.YELLOW;
        } else if (e.getSource() == btnBlack) {
            currentColor = Color.BLACK;
        } else if (e.getSource() == btnWhite) {
            currentColor = Color.WHITE;
        } else if (e.getSource() == btnCyan) {
            currentColor = Color.CYAN;
        } else if (e.getSource() == btnMagenta) {
            currentColor = Color.MAGENTA;
        } else if (e.getSource() == btnOrange) {
            currentColor = Color.ORANGE;
        } else if (e.getSource() == btnPink) {
            currentColor = Color.PINK;
        } else if (e.getSource() == btnDarkGray) {
            currentColor = Color.DARK_GRAY;
        } else if (e.getSource() == btnLightGray) {
            currentColor = Color.LIGHT_GRAY;
        } else if (e.getSource() == btnLine) {
            currentShapeType = "Line";
        } else if (e.getSource() == btnRect) {
            currentShapeType = "Rectangle";
        } else if (e.getSource() == btnOval) {
            currentShapeType = "Oval";
        } else if (e.getSource() == btnFreeHand) {
            currentShapeType = "FreeHand";
        } else if (e.getSource() == btnSave) {
            saveDrawing();
        } else if (e.getSource() == btnOpen) {
            openImage();
        } else if (e.getSource() == btnEraser) {
            currentShapeType = "FreeHand";
            currentColor = Color.WHITE;
        } else if (e.getSource() == btnClear) {
            shapes.clear();
            repaint();
        } else if (e.getSource() == btnUndo) {
            if (!shapes.isEmpty()) {
                shapes.remove(shapes.size() - 1);
            }
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        shapes.Shape shape = null;

        switch (currentShapeType) {
            case "Rectangle":
                shape = new RectangleShape(currentColor, filled, dotted, startX, startY, endX, endY);
                break;
            case "Oval":
                shape = new OvalShape(currentColor, filled, dotted, startX, startY, endX, endY);
                break;
            case "Line":
                shape = new LineShape(currentColor, false, dotted, startX, startY, endX, endY);
                break;
        }

        if (shape != null) {
            shapes.add(shape);
        }
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        if (currentShapeType.equals("FreeHand") || currentShapeType.equals("Eraser")) {
            endX = e.getX();
            endY = e.getY();
            shapes.Shape shape = null;

            if (currentShapeType.equals("FreeHand")) {
                shape = new FreeHandShape(currentColor, startX, startY, endX, endY);
            } else if (currentShapeType.equals("Eraser")) {
                shape = new EraserShape(startX, startY, endX, endY);
            }

            if (shape != null) {
                shapes.add(shape);
                startX = endX;
                startY = endY;
                repaint();
            }
        }
    }

    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    private void saveDrawing() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();

        try {
            FileDialog fileDialog = new FileDialog((Frame) null, "Save", FileDialog.SAVE);
            fileDialog.setFile("drawing.png");
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory() + fileDialog.getFile();

            if (filePath != null) {
                File file = new File(filePath);
                ImageIO.write(image, "png", file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void openImage() {
        try {
            FileDialog fileDialog = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String filePath = fileDialog.getDirectory() + fileDialog.getFile();

            if (filePath != null) {
                Image image = Toolkit.getDefaultToolkit().getImage(filePath);
                shapes.clear();
                shapes.add(new shapes.Shape(currentColor, false, false, 0, 0, 0, 0) {
                    public void draw(Graphics g) {
                        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                    }
                });
                repaint();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
