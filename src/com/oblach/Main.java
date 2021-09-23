package com.oblach;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args)
    {
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class DrawFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    public DrawFrame()
    {
        setTitle("1 / 3 ^ (x + 1)");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        add(new DrawPanel());
    }
}

class DrawPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        double shX = 100;
        double shY = 50;
        for(int x = -6; x < 6; ++x)
            g2.draw
                    (
                            new Line2D.Double
                                    (
                                            x + shX,
                                            DrawFrame.DEFAULT_HEIGHT - (Math.pow(3, -x - 1) + shY),
                                            x + 1 + shX,
                                            DrawFrame.DEFAULT_HEIGHT - (Math.pow(3, -x - 2) + shY)
                                    )
                    );
    }
}