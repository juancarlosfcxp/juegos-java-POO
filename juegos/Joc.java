/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import processing.core.PApplet;

/**
 *
 * @author pere
 */
public abstract class Joc extends PApplet implements JocInterface {
    
    
//<editor-fold defaultstate="collapsed" desc="VALORS PER DEFECTE DE PRESENTACIÓ">
    /**
     * Color negre format RGB
     */
    final public static int NEGRE = 0x000000;
    
    /**
     * Amplada per defecte del marc (width)
     */
    final public static int DEFAULT_AMPLADA = 1200;
    
    /**
     * Fondària per defecte del marc (height)
     */
    final public static int DEFAULT_FONDARIA = 700;
    
    /**
     * Background per defecte NEGRE
     */
    final public static int DEFAULT_BACKGROUND = NEGRE;
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GESTIÓ DEL BACKGROUND">
    private int background;  //El background no el podem utilitzar a settings

    /**
     * Defineix el background del marc
     *
     * @param background
     */
    public void setBackground(int background) {
        this.background = background;
    }

    /**
     *
     * @return el background del marc
     */
    public int getBackground() {
        return background;
    }

//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="FUNCIONAMENT PER DEFECTE D'UN JOC">
    /**
     * Processing el crida 1 vegada a l'inici, abans de crear un objecte PApplet.
     */
    @Override
    public void settings() {
        marcSettings();
    }
    
    /**
     * Processing el crida una vegada l'objecte PApplet està disponible.
     */
    @Override
    public void setup() {
        prepararJoc();
        marcSetup();
    }
    
    /**
     * Processing el crida de manera indefinida.
     */
    @Override
    public void draw() {
        if (!isFinalJoc()) {
            jugada();
            marcDraw();
        } else {
            noLoop(); //finalitza draw
            finalJoc();
        }
    }
//</editor-fold>
}
