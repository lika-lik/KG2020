package ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class BresenthemArcDrawer {
        private PixelDrawer pd;
        private Color color = Color.black;

        public BresenthemArcDrawer(PixelDrawer pd) {
            this.pd = pd;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void drawArc(int x0, int y0, int angel1, int angel2, int r) {
            int x = 0;
            int y = r;
            double[] xyByAngel1 = findXYAngel(angel1, r, x0, y0);
            double[] xyByAngel2 = findXYAngel(angel2, r, x0, y0);
            int delta = 1 - 2 * r;
            int error = 0;
            while (y >= 0) {
                drawPixelIfPointBelongArc(x0 + x, y0 + y, xyByAngel1, xyByAngel2, pointQuarter(x0 + x, y0 + y, x0, y0, r));
                drawPixelIfPointBelongArc(x0 + x, y0 - y, xyByAngel1, xyByAngel2, pointQuarter(x0 + x, y0 - y, x0, y0, r));
                drawPixelIfPointBelongArc(x0 - x, y0 + y, xyByAngel1, xyByAngel2, pointQuarter(x0 - x, y0 + y, x0, y0, r));
                drawPixelIfPointBelongArc(x0 - x, y0 - y, xyByAngel1, xyByAngel2, pointQuarter(x0 - x, y0 - y, x0, y0, r));
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

        private void drawPixelIfPointBelongArc(int x, int y, double[] xyAngel1, double[] xyAngel2, int pointQuarter){
            int quarter1 = (int)xyAngel1[2]; int quarter2 = (int)xyAngel2[2];
            if (quarter1 > quarter2)
                quarter2 += 4;
            if (pointQuarter > quarter1 && pointQuarter < quarter2)
                pd.drawPixwl(x, y, color);
            else {
                switch (pointQuarter) {
                    case (1):
                        if (quarter1 == 1 && x < xyAngel1[0])
                            pd.drawPixwl(x, y, color);
                        if (quarter2 == 1 && x > xyAngel2[0])
                            pd.drawPixwl(x, y, color);
                        break;
                    case (2):
                        if (quarter1 == 2 && x < xyAngel1[0])
                            pd.drawPixwl(x, y, color);
                        if (quarter2 == 2 && x > xyAngel2[0])
                            pd.drawPixwl(x, y, color);
                        break;
                    case (3):
                        if (quarter1 == 3 && x > xyAngel1[0])
                            pd.drawPixwl(x, y, color);
                        if (quarter2 == 3 && x < xyAngel2[0])
                            pd.drawPixwl(x, y, color);
                        break;
                    case (4):
                        if (quarter1 == 4 && x > xyAngel1[0])
                            pd.drawPixwl(x, y, color);
                        if (quarter2 == 4 && x < xyAngel2[0])
                            pd.drawPixwl(x, y, color);
                        break;
                }
            }
        }

        private double[] findXYAngel(int angel, int r, int x0, int y0) {
            double xy[] = new double[3];
            double angelRad;
            if (angel > 360)
                angel = angel - angel * (angel / 360);
            if (angel < 0)
                angel = 360 - angel;
            if (angel <= 90) {
                angelRad = Math.toRadians(angel);
                xy[0] = x0 + (Math.cos(angelRad)) * r;
                xy[1] = y0 - Math.sin(angelRad) * r;
                xy[2] = 1;
                return xy;
            }
            else if (angel <= 180)
            {
                angelRad = Math.toRadians(180-angel);
                xy[0] = x0 - Math.cos(angelRad) * r ;
                xy[1] = y0 - Math.sin(angelRad) * r;
                xy[2] = 2;
                return xy;
            }
            else if (angel <= 270)
            {
                angelRad = Math.toRadians(angel - 180);
                xy[0] = x0 - Math.cos(angelRad) * r;
                xy[1] = y0 + Math.sin(angelRad) * r;
                xy[2] = 3;
                return xy;
            }
            angelRad = Math.toRadians(360-angel);
            xy[0] = x0 + Math.cos(angelRad) * r ;
            xy[1] = y0 + Math.sin(angelRad) * r ;
            xy[2] = 4;
            return xy;
        }

        private int pointQuarter(int x, int y, int x0, int y0, int r){
            if (x > x0)
                return  (y > y0) ? 4 : 1;
            else
                return  (y > y0) ? 3 : 2;
        }
}
