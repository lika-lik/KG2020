package ru.vsu.cs.kg2020.nuzhnyh_a_v;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers.BresenthemLineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers.DDALineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers.GraphicsLineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers.WuLineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new BresenthemLineDrawer(pd);
        bi_g.setColor(Color.white);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);

        drawAll(pd);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(PixelDrawer pd){
       // DrawUtils.drawCircle(getWidth()/2, getHeight()/2, getWidth()/4, pd);
       // DrawUtils.drawEllipse(getWidth()/2, getHeight()/2, getWidth()/2 + getWidth()/500,
       //         getHeight()/2 - getHeight()/4, pd);
       // DrawUtils.drawArc(getWidth()/2, getHeight()/2, 45, 180, getWidth()/4, pd);
        //DrawUtils.drawCircleWu(getWidth()/2, getHeight()/2, getWidth()/4, pd);
        DrawUtils.drawSnowflake(new WuLineDrawer(pd), getWidth()/2, getHeight()/2, getWidth()/8, 25);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
