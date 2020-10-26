package ru.vsu.cs.kg2020.nuzhnyh_a_v;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics g;

    public GraphicsPixelDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawPixwl(int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
    }
}
