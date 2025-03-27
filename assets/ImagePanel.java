package assets;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    ImageIcon image = new ImageIcon("C:\\Users\\daodp\\OneDrive\\Desktop\\FiCAD");

    final int IMG_WIDTH = image.getIconWidth();
    final int IMG_HEIGHT = image.getIconHeight();

    Point image_corner;
    Point previousPoint;

    ImagePanel() {

        image_corner = new Point(0, 0);

        ClickListener ClickListener = new ClickListener();
        this.addMouseListener(ClickListener);

        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);

    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        image.paintIcon(this, g, (int)image_corner.getX(), (int)image_corner.getY());
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent evt) {
            previousPoint = evt.getPoint();
        }

    }


    private class DragListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent evt) {

            Point currentPoint = evt.getPoint();

            image_corner.translate(
                (int)(currentPoint.getX() - previousPoint.getX()) , 
                (int)(currentPoint.getY() - previousPoint.getY())
                );
            
            previousPoint = currentPoint;
            repaint();
        }

    }
}