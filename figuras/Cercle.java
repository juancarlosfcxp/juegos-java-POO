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
public class Cercle extends Figura {

    /**
     * Mida mínima del radi (quan es genera a l'atzar).
     */
    public final static int MIN_RADI = 5;

    /**
     * Maxim nombre de cercles que podem posar en una linia
     * sense que es toquin (segons la amplada del marc).
     * Serveix per calcular el radi màxim generat a l¡atzar
     */
    public final static int MAX_CERCLES_LINIA = 70; 
 
    
    private int radi;


    public Cercle(int radi, float x, float y, int colorR, int colorG, int colorB) {
        super(x, y, colorR, colorG, colorB);
        this.radi = radi;
    }

    /**
     * Genera un cercle amb color, centre dins del marc i radi a l'atzar.
     * 
     * 
     * @param joc
     * @param margeX
     * @param margeY
     */
    public Cercle(Joc joc, int margeX, int margeY) {
        super(joc, margeX, margeY);
        int maxRadi = (int) (joc.width/(MAX_CERCLES_LINIA / 2));
        if (maxRadi > MIN_RADI){
            radi = Utils.randomValue(MIN_RADI, maxRadi);
        } else {
            radi = MIN_RADI;
        }
        
    }

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    @Override
    public double area() {
        return Math.PI * radi * radi;
    }
    

    /**
     *
     * @param joc Permet obtenir el joc on es dibuixa
     */
    
    
    public void dibuixa(){
        System.out.println(this);
    }
    
    
    @Override
    
    public void dibuixa(Joc joc) {
        //System.out.println(this); si volem veure-ho per consola
        joc.fill(getColorR(), getColorG(), getColorB());
        joc.ellipse(getX(), getY(), 2*radi, 2*radi);
    }

    @Override
    public String toString() {
        return "Cercle{" + "radi=" + radi + '}' + super.toString();
    }
    
    
    public static void main(String[] args) {
        Cercle c = new Cercle(50, 100, 100, 255, 0, 0);
        c.dibuixa();
    }
    
    
}
