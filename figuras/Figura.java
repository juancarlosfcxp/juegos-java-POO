/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import juegos.Joc;
import utils.Utils;

/**
 *
 * @author pere
 */
public abstract class Figura {

    private float x; //posició x
    private float y; //posició y
    private int colorR; //0 a 255
    private int colorG;
    private int colorB;
    //private int colorRGB; //color format 0xFFFFFF

//<editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    /**
     *
     * @param x
     * @param y
     * @param colorR
     * @param colorG
     * @param colorB
     */
    public Figura(float x, float y, int colorR, int colorG, int colorB) {
        this.x = x;
        this.y = y;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    /**
     * Genera una figura amb posició a l'atzar (dins del marc i mantenint els
     * marges) i color a l'atzar.
     *
     * @param joc el joc de referència per a la posició de la figura
     * @param margeX separació de l'eix X
     * @param margeY separació de l'eix Y
     */
    public Figura(Joc joc, int margeX, int margeY) {
        x = Utils.randomValue(margeX, joc.width - margeX);
        y = Utils.randomValue(margeY, joc.height - margeY);
        colorR = Utils.randomSimpleColor();
        colorG = Utils.randomSimpleColor();
        colorB = Utils.randomSimpleColor();
        //colorR = 255;
        //colorG =255;
       // colorB =255;
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="METODES ABSTRACTES">
    /**
     *
     * @return area de la figura
     */
    abstract public double area();

    /**
     * Es dibuixa en el Joc.
     *
     * @param joc
     */
    abstract public void dibuixa(Joc joc);

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="GETTERS/SETTERS">
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getColorR() {
        return colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public int getColorB() {
        return colorB;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="TO_STRING">
    @Override
    public String toString() {
        return "Figura{" + "x=" + x + ", y=" + y + ", colorR=" + colorR + ", colorG=" + colorG + ", colorB=" + colorB + '}';
    }
//</editor-fold>

}
