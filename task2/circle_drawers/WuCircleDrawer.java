package ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class WuCircleDrawer {
    private PixelDrawer pd;

    public WuCircleDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void drawCircle(int x1, int y1, int r) {
        int x = 0;
        int y = r;
        int delta = 1 - 2 * r;
        double error;
        double gradient = 1.0;
        while (y >= 0) {
            double interY = y1 + gradient;
            pd.drawPixwl(x1 + x, y1 + y, new Color(0, 0, 0, (int) (255 - (interY - (int)interY) * 255)));
            pd.drawPixwl(x1 + x, y1 - y, new Color(0, 0, 0, (int) (255 - (interY - (int)interY) * 255)));
            pd.drawPixwl(x1 - x, y1 + y, new Color(0, 0, 0, (int) (255 - (interY - (int)interY) * 255)));
            pd.drawPixwl(x1 - x, y1 - y, new Color(0, 0, 0, (int) (255 - (interY - (int)interY) * 255)));

            pd.drawPixwl(x1 + x, y1 + y + 1, new Color(0, 0, 0, (int) (interY - (int)interY) * 255));
            pd.drawPixwl(x1 + x, y1 - y + 1, new Color(0, 0, 0, (int) (interY - (int)interY) * 255));
            pd.drawPixwl(x1 - x, y1 + y + 1, new Color(0, 0, 0, (int) (interY - (int)interY) * 255));
            pd.drawPixwl(x1 - x, y1 - y + 1, new Color(0, 0, 0, (int) (interY - (int)interY) * 255));
            error = 2 * (delta + y) - 1;
            if (delta < 0 && error <= 0) {
                delta += 2 * ++x + 1;
                continue;
            }
            if ((delta > 0) && (error > 0)) {
                delta -= 2 * --y + 1;
                continue;
            }
            delta += 2 * (++x - --y);
        }
    }
}
