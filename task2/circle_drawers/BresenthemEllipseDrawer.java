package ru.vsu.cs.kg2020.nuzhnyh_a_v.circle_drawers;

import ru.vsu.cs.kg2020.nuzhnyh_a_v.PixelDrawer;

import java.awt.*;

public class BresenthemEllipseDrawer {
    private PixelDrawer pd;
    private Color color = Color.black;

    public BresenthemEllipseDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawEllipse(int x1, int y1, int xRad, int yRad) {
        int twoASquare = 2 * xRad * xRad;
        int twoBSquare = 2 * yRad * yRad;
        int x = xRad;
        int y = 0;
        int xChange = yRad * yRad * (1-2*xRad);
        int yChange = xRad * xRad;
        int ellipseError = 0;
        int xStopping = twoBSquare * xRad;
        int yStopping = 0;
        while (xStopping >= yStopping){
            draw4EllipsePoints(x, y, x1, y1);
            y++; yStopping += twoASquare;
            ellipseError += yChange; yChange += twoASquare;
            if((2*ellipseError + xChange) > 0){
                x--; xStopping -= twoBSquare;
                ellipseError += xChange; xChange += twoBSquare;
            }
        }
        x = 0;
        y = yRad;
        xChange = yRad * yRad;
        yChange = xRad * xRad * (1 - 2 * yRad);
        ellipseError = 0;
        xStopping = 0;
        yStopping = twoASquare * yRad;
        while (xStopping <=yStopping){
            draw4EllipsePoints(x, y, x1, y1);
            x++; xStopping += twoBSquare;
            ellipseError += xChange; xChange += twoBSquare;
            if ((2 * ellipseError + yChange) > 0){
                y--;
                yStopping -= twoASquare;
                ellipseError += yChange;
                yChange += twoASquare;
            }
        }
    }

    private void draw4EllipsePoints(int x, int y, int x1, int y1){
        pd.drawPixwl(x1 + x, y1 + y, color);
        pd.drawPixwl(x1 - x, y1 + y, color);
        pd.drawPixwl(x1 - x, y1 - y, color);
        pd.drawPixwl(x1 + x, y1 - y, color);
    }
}
