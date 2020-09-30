package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        Car car = new Car(getWidth() / 7, getHeight() / 2, getWidth() / 2, getHeight() / 2, Color.red);
        Sign sign = new Sign((int) (getWidth() / 7 * 4.5), getHeight() / 2, getHeight() / 2, "STOP");
        Road road = new Road(0, getHeight() / 2 + (int) (0.2 * getHeight()), getWidth(), getHeight());
        road.draw(gr);
        car.draw(gr);
        sign.draw(gr);
    }
}
