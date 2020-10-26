package ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.LineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class BresenthemLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    private Color color = Color.black;

    public BresenthemLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = (x2 - x1 >= 0 ? 1 : -1);
        int dy = (y2 - y1 >= 0 ? 1 : -1);
        int lengthX = Math.abs(x2-x1);
        int lengthY = Math.abs(y2-y1);
        int length = Math.max(lengthX, lengthY);

        if (length == 0){
            pd.drawPixwl(x1, y1, color);
        }
        if(lengthY<=lengthX){
            int x = x1;
            int y = y1;
            int d = -lengthX;

            length++;
            while ((length--)>0){
                pd.drawPixwl(x, y, color);
                x += dx;
                d += 2* lengthY;
                if (d > 0){ 
                    d -=2*lengthX;
                    y += dy;
                }
            }
        }else{
            int x = x1;
            int y = y1;
            int d = - lengthY;

            length++;
            while ((length--)>0){
                pd.drawPixwl(x, y, color);
                y += dy;
                d += 2 * lengthX;
                if (d > 0){
                    d -= 2 * lengthY;
                    x += dx;
                }
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
