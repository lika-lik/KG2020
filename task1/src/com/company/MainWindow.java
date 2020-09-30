package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        DrawPanel dp = new DrawPanel();
        this.add(dp);
        this.setBackground(Color.CYAN);
    }
}
