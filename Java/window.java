package Java;
import java.awt.*;
import javax.swing.*;

public class window {
     public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        DrawBoard board = new DrawBoard();
        frame.add(board);
        frame.setVisible(true);
    }
}
class DrawBoard extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw a simple grid
        int width = getWidth();
        int height = getHeight();
        int gridSize = 50;
        g.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < width; x += gridSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += gridSize) {
            g.drawLine(0, y, width, y);
        }

    }
    protected void mouseDragged(java.awt.event.MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(e.getX(), e.getY(), 10, 10);
    }
}






