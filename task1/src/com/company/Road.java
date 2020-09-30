package com.company;

import java.awt.*;

public class Road implements Drawable {
    private int x1, y1, x2, y2;

    public Road(int x, int y, int x2, int y2){
        this.x1 = x;
        this.y1 = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(new int[]{x1, x1, x2, x2}, new int[]{y1, y2, y2, y1}, 4);
        g.setColor(Color.white);
        int st = (x2 - x1)/5;
        for (int i = 0; i < 5; i ++){
            g.fillRect(x1, (int)(0.85*y2), st, (int)(0.03*y1));
            x1 += 2*st;
        }
    }
}
