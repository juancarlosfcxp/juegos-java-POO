/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

/**
 *
 * @author pere
 */
public interface JocInterface {
    
    //<editor-fold defaultstate="collapsed" desc="ELS METODES ABSTRACTES">
    /**
     * Defineix els setting (que crida el processing) del joc que fem.
     * Ha de contenir com a mínim setSize(width, height).
     * No pot cridar bacground (que cal fer-ho a settup i/o a draw).
     */
    public void marcSettings();
    
    /**
     * Defineix els setup (que crida el processing) del joc que fem.
     * S'executa una única vegada.
     */
    public void marcSetup();
    
    /**
     * Defineix que es mostra en el draw de processing.
     * Es crida de manera indefinida dins que s'activa finalJoc.
     */
    public void marcDraw();
    
    /**
     * Inicialitza el que es necessita per al Joc, abans de començar a jugar.
     */
    public void prepararJoc();
    
    /**
     * Fa una jugada del joc.
     */
    public void jugada();
    
    /**
     *
     * @return si el joc s'ha acabat
     */
    public boolean isFinalJoc();
    
    /**
     * Activa noloop() per a que no es torni a cridar draw i finalitza joc, per
     * exemple, mostrant pantalla de final.
     */
    public void finalJoc();
//</editor-fold>

    
}
