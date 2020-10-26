package ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.LineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    private PixelDrawer pd;
    private Color color = Color.black;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx)> Math.abs(dy)){
            double k = dy/dx;
            if (x1 > x2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            for (int j = x1; j < x2; j++){
                double i = k * (j - x1) + y1;
                pd.drawPixwl(j, (int)i, color);
            }
        }else{
            double obrk = dx/dy;
            if (y1 > y2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            for (int i = y1; i < y2; i++){
                double j = (i - y1)*obrk + x1;
                pd.drawPixwl((int)j, i, color);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
