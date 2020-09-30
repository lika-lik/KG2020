package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Car implements Drawable {

    private int x, y, width, height;
    private Color color;

    public Car(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        drawCar(g, x, y, width, height, color);
    }

    private static void drawCar(Graphics2D g, int x, int y, int width, int height, Color color){
        drawBody(g, x, y, width, height, color);
        drawLights(g, x, y, width, height);
        drawDoor(g, x, y, width, height);
        drawWindows(g, x, y, width, height);
        drawWheel(g, x, y, width);
        drawPipe(g, x, y, width, height);
    }

    private static void drawWheel(Graphics2D g, int x, int y, int width) {
        int r = width / 6;
        y = (int) (y + 1.5 * r);
        g.setColor(Color.BLACK);
        g.fillOval(x + r, y, r, r);
        g.fillOval(x + width - 2 * r, y, r, r);
        r = (int)( 0.75 * r); // детализация колес, серыми кругами внутри
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x - width / 6 + (int)(2.9*r), y + (int)(0.2*r), r, r);
        g.fillOval(x + width - (int)(2.6*r), y + (int)(0.2*r), r, r);
        g.setColor(Color.black);
        drawWheelCover(g, 8, (int)(0.6*r), x + (int)(0.87*x), (int)(1.085*y));
        drawWheelCover(g, 8, (int)(0.6*r), x + (int)(2.617*x), (int)(1.085*y));
    }

    private static void drawWheelCover(Graphics2D g, int n, int r, int x, int y){
        double d = 2 * Math.PI / n;
        for (int i = 0; i < n; i ++){
            double dx = r * Math.cos(d * i);
            double dy =r * Math.sin(d * i);
            drawBezierCurve(g, x, y, (int)(1.01*x + 0.2*dx),(int)(1.01*y + (0.9*dy)), x + (int)dx, y + (int)dy);
        }
    }

    private static void drawBezierCurve(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3){
        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.curveTo(x1, y1, x2, y2, x3, y3);
        g.draw(path);
    }

    private  static void drawBody(Graphics2D g, int x, int y, int width, int height, Color color){
        drawUpperBody(g, x, y, width, height, color);
        drawLowBody(g, x, y, width, height, color);
    }

    private  static void drawUpperBody(Graphics2D g, int x, int y, int width, int height, Color color){
        y = y - (int)(0.5*height);
        g.setColor(color);
        g.fillRect(x+(int)(0.5*width), y, (int)(0.25*width), (int)(0.5*height));
        g.fillRect(x+(int)(0.25*width), y, (int)(0.25*width), (int)(0.5*height));
        g.fillArc(x+(int)(0.155*width), y,(int)(0.2*width), height, 90, 180);
        int xTr = x+(int)(0.75*width);
        Polygon triangle = new Polygon(new int[]{xTr, xTr, xTr + (int)(0.15*width)}, new int[]{y, y + (int)(0.5*height), y + (int)(0.5*height)}, 3);
        g.draw(triangle);
        g.fill(triangle);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawLine(x+(int)(0.25*width), y, x+(int)(0.75*width), y);
        g.drawLine(xTr, y, xTr + (int)(0.15*width), y + (int)(0.5*height));
        g.drawLine(x+(int)(0.5*width), y, x+(int)(0.5*width), y + height/2);
        g.drawArc(x+(int)(0.155*width), y,(int)(0.2*width), height, 90, 180);
    }

    public static void drawDoor(Graphics2D g, int x, int y, int width, int height){
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawLine(x+(int)(0.5*width), y + (int) (0.1 * height) , x+(int)(0.5*width), y + (int) (0.3 * height));
        g.drawLine(x+(int)(0.52*width), y + (int) (0.1 * height) , x+(int)(0.52*width), y + (int) (0.3 * height));
        g.drawLine(x+(int)(0.45 * width), y + (int) (0.1 * height) , x+(int)(0.48*width), y + (int) (0.1 * height));
        g.drawLine(x+(int)(0.54 * width), y + (int) (0.1 * height) , x+(int)(0.57*width), y + (int) (0.1 * height));
    }

    private static void drawLowBody(Graphics2D g, int x, int y, int width, int height, Color color){
        g.setColor(color);
        g.fillRect(x, y,width, height/2);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawRect(x, y,width, height/2);
    }

    private static void drawLights(Graphics2D g, int x, int y, int width, int height){
        x = x + (int)(0.93*width);
        y = (int)(y + 0.1*height);
        width = (int)(0.2*height);
        height = (int)(0.2*height);
        g.setColor(Color.yellow);
        g.fillArc(x, y, width, height, 0, -90);
        g.fillArc(x, y, width, height,0, 90);
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        g.drawArc(x, y, width, height, 0, -90);
        g.drawArc(x, y, width, height, 0, 90);
    }

    private static void drawWindows(Graphics2D g, int x, int y, int width, int height){
        g.setColor(Color.cyan);
        int windowWidth =(int)(width / 3.0);
        int windowHeight =(int)(height/ 3.0);
        g.fillRect(x + (int)(0.5*width) + (int)(0.2*windowWidth), y - (int)(1.2*windowHeight), windowWidth/2, windowHeight);
        int xTr = x + (int)(0.5*width) + windowWidth/2 + (int)(0.2 * windowWidth);
        int yTr = y - (int)(1.2*windowHeight);
        Polygon tr = new Polygon(new int[]{xTr, xTr, xTr + (int)(0.3 * windowWidth)}, new int[]{yTr, yTr + windowHeight, yTr + windowHeight}, 3);
        g.fill(tr);
        g.fillRect(x + (int)(0.9*windowWidth), y - (int)(1.2*windowHeight), windowWidth/2, windowHeight);
        g.fillArc(x + (int)(0.65*windowWidth), y - (int)(1.2*windowHeight),(int)(0.5*windowWidth), windowHeight, 90, 180);
        g.fillPolygon(new int[]{x + (int)(0.65*windowWidth), x + (int)(0.65*windowWidth), x + (int)(0.9*windowWidth)},
                new int[]{y - (int)(1.2*windowHeight) + windowHeight/2, y - (int)(1.2*windowHeight) + windowHeight, y - (int)(1.2*windowHeight) + windowHeight}, 3);
    }

    private static void drawPipe(Graphics2D g, int x, int y, int width, int height){
        g.setColor(Color.black);
        width = (int)(width*0.08);
        height = (int)(height*0.1);
        g.fillRect(x - width, y + height, width, height);
    }
}
