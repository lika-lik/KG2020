package ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class BresenthemCircleDrawer {
    private PixelDrawer pd;
    private Color color = Color.black;

    public BresenthemCircleDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawCircle(int x1, int y1, int r){
        int x = 0;
        int y = r;
        int delta = 1 - 2*r;
        int error = 0;
        while(y >= 0){
            pd.drawPixwl(x1 + x, y1 + y, Color.black);
            pd.drawPixwl(x1 + x, y1 - y, Color.black);
            pd.drawPixwl(x1 - x, y1 + y, Color.black);
            pd.drawPixwl(x1 - x, y1 - y, Color.black);
            error = 2 * (delta + y) - 1;
            if(delta < 0 && error <= 0){
                delta += 2 * ++x + 1;
                continue;
            }
            if((delta > 0) && (error > 0)) {
                delta -= 2 * --y + 1;
                continue;
            }
            delta += 2 * (++x - --y);
        }
    }
}
