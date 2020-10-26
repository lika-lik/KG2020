package ru.vsu.cs.kg2020.nuzhnyh_a_v.line_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.LineDrawer;
import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    private Color color = Color.black;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        if (x2 < x1){
            int temp = x2; x2 = x1; x1 = temp;
            temp = y2; y2 = y1; y1 = temp;
        }
        int dx = x2-x1;
        int dy = y2-y1;
        if (dx == 0 || dy == 0) {
            if(dx == 0) {
                for (int j = y1; j < dy; j++) {
                    pd.drawPixwl(x1, j, color);
                    return;
                }
            }else{
                for (int i = x1; i < dx; i++){
                    pd.drawPixwl(i, y1, color);
                }
            }
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float interY = y1 + gradient;
            pd.drawPixwl(x1, y1, color);
            for (int x = x1; x < x2; ++x) {
                pd.drawPixwl(x, (int)interY, new Color(0, 0, 0, (int) (255 - (interY - (int)interY) * 255)));
                pd.drawPixwl(x, (int)interY + 1, new Color(0, 0, 0, (int) (interY - (int)interY) * 255));
                interY += gradient;
            }
            pd.drawPixwl(x2, y2, color);
        }else {
            gradient = (float) dx / dy;
            float interX = x1 + gradient;
            pd.drawPixwl(x1, y1, color);
            for (int y = y1; y < y2; ++y) {
                pd.drawPixwl((int)interX, y, new Color(0, 0, 0, (int) (255 - (interX - (int)(interX)) * 255)));
                pd.drawPixwl((int)interX + 1, y, new Color(0, 0, 0, (int) (interX - (int)interX) * 255));
                interX += gradient;
            }
            pd.drawPixwl(x2, y2, color);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
