package com.company;

import java.awt.*;

public class Sign implements Drawable {
    private int x, y; // значения правого верхнего края знака
    private int height;
    private String string;

    public Sign(int x, int y, int height, String string){
        this.x = x;
        this.y = y;
        this.height = height;
        this.string = string;
    }

    @Override
    public void draw(Graphics2D g) {
        drawSign(g, x, y, height);
    }

    private static void drawSign(Graphics2D g, int x, int y, int height){
        g.setColor(Color.BLACK);
        g.fillRect(x + (int)(0.5*height), y - (int)(height * 0.45), (int)(0.1 * height), height);
        g.setColor(Color.red);
        int r1 = height/2;
        g.fillOval(x + (int)(0.3*height),y - r1, r1, r1);
        g.setColor(Color.white);
        int r2 = (int)(height / 2.5);
        g.fillOval(x + (int)(0.35*height),y - (int)(0.9*r1), r2, r2);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.drawString("STOP",x + (int)(0.35*height),y - (int)(0.4*r1));
    }
}
