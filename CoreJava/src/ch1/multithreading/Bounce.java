package ch1.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Bounce{
    public static void main(String[] args){
        JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Ball{
    public void move(Rectangle2D bounds){
        x += dx;
        y += dy;
        if(x < bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }

        if(x + XSIZE > bounds.getMaxX()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }

        if(y < bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }

        if(y + YSIZE > bounds.getMaxY()){
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
}

class BallPanel extends JPanel{
    public void add(Ball b){
        balls.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls){
            g2.fill(b.getShape());
        }
    }

    private List<Ball> balls = new ArrayList<Ball>();
}

class BounceFrame extends JFrame{
    public BounceFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Bounce");

        panel = new BallPanel();
        add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Start",
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addBall();
                    }
                });

        addButton(buttonPanel, "Close",
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

        add(buttonPanel, BorderLayout.SOUTH);

    }

    public void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /*Adds a bouncing ball to the panel and makes
    it bounce 1,000 times*/
    public void addBall(){
        try{
            Ball ball = new Ball();
            panel.add(ball);

            for(int i = 1; i<= STEPS; i++){
                ball.move(panel.getBounds());
                panel.paint(panel.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private BallPanel panel;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
}