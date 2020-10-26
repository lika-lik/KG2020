package ru.vsu.cs.kg2020.nuzhnyh_a_v.utils;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.LineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers.BresenthemArcDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers.BresenthemCircleDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers.BresenthemEllipseDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers.WuCircleDrawer;

public class DrawUtils {
    public static void drawSnowflake(
            LineDrawer ld, int  x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0 ; i < n; i++) {
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            ld.drawLine(x, y, x + (int)dx, y + (int)dy);
        }
    }

    public static void drawCircle (int x, int y, int r, PixelDrawer pd){
        BresenthemCircleDrawer cd = new BresenthemCircleDrawer(pd);
        cd.drawCircle(x, y, r);
    }

    public static void drawEllipse (int x, int y, int xRad, int yRad, PixelDrawer pd){
        BresenthemEllipseDrawer ed = new BresenthemEllipseDrawer(pd);
        ed.drawEllipse(x, y, xRad, yRad);
    }

    public static void drawArc(int x, int y, int angel1, int angel2, int r, PixelDrawer pd){
        BresenthemArcDrawer ad = new BresenthemArcDrawer(pd);
        ad.drawArc(x, y, angel1, angel2, r);
    }

    public static void drawCircleWu (int x, int y, int r, PixelDrawer pd){
        WuCircleDrawer wd = new WuCircleDrawer(pd);
        wd.drawCircle(x, y, r);
    }
}
