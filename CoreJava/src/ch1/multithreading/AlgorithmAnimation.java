package ch1.multithreading;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/20
 * Email: billchen01@163.com
 */

public class AlgorithmAnimation {

    public static void main(String[] args){
        JFrame frame = new AnimationFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class AnimationFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    private static final int VALUES_LENGTH = 30;

    public AnimationFrame(){
        ArrayPanel panel = new ArrayPanel();
        add(panel, BorderLayout.CENTER);

        Double[] values = new Double[VALUES_LENGTH];
        final Sorter sorter = new Sorter(values, panel);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setRun();
            }
        });

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setStep();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(runButton);
        buttons.add(stepButton);
        add(buttons, BorderLayout.NORTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        for(int i=0; i<values.length; i++){
            values[i] = new Double(Math.random());
        }

        Thread t = new Thread(sorter);
        t.start();
    }

}

class Sorter implements Runnable {

    private Double[] values;
    private ArrayPanel panel;
    private Semaphore gate;
    private static final int DELAY = 100;
    private boolean run;

    public Sorter(Double[] values, ArrayPanel panel) {
        this.values = values;
        this.panel = panel;
        this.gate = new Semaphore(1);
        this.run = false;
    }

    @Override
    public void run() {
        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                panel.setValues(values, o1, o2);
                try{
                    if(run){
                        Thread.sleep(DELAY);
                    }else {
                        gate.acquire();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(values, comp);
        panel.setValues(values, null, null);
    }

    public void setRun(){
        run = true;
        gate.release();
    }

    public void setStep(){
        run = false;
        gate.release();
    }
}

class ArrayPanel extends JPanel {
    private Double marked1;
    private Double marked2;
    private Double[] values;

    public void paintComponent(Graphics g){
        if(values == null){
            return;
        }
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth() / values.length;
        for(int i=0; i<values.length; i++){
            double height = values[i] * getHeight();
            Rectangle2D bar = new Rectangle2D.Double(width*i, 0, width, height);
            if(values[i] == marked1 || values[i] == marked2){
                g2.fill(bar);
            }else {
                g2.draw(bar);
            }
        }
    }

    public void setValues(Double[] values, Double marked1, Double marked2){
        this.values = values;
        this.marked1 = marked1;
        this.marked2 = marked2;
        repaint();
    }

}
