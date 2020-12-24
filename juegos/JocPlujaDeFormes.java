/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import figuras.Cercle;
import figuras.Figura;
import processing.core.PApplet;

/**
 *
 * @author pere
 */
public class JocPlujaDeFormes extends Joc {

    private final int N_FIGURES;
    private Figura figura;
    private int nFigures;

    private final boolean continu;
    private boolean finalJoc;

    public JocPlujaDeFormes(boolean continu, int nFigures) {
        this.continu = continu;
        finalJoc = false;
        N_FIGURES = nFigures;
    }

    /**
     * Selecciona els valors per defecte d'amplada, fondaria i background.
     */
    @Override
    public void marcSettings() { //settings
        setSize(DEFAULT_AMPLADA, DEFAULT_FONDARIA);
        setBackground(DEFAULT_BACKGROUND);
    }

    /**
     * Inicialitza el background.
     */
    @Override
    public void marcSetup() { //setup
        background(getBackground());
    }

    /**
     * Dibuixa la figura.
     */
    @Override
    public void marcDraw() {
        if (!continu) {
            background(getBackground());
        }
        figura.dibuixa(this);
    }

    @Override
    public void prepararJoc() {
        nFigures = N_FIGURES;
    }

    @Override
    public void jugada() {
        if (nFigures == 0) {
            finalJoc = true;
        } else {
            figura = new Cercle(this, 40, 40);
            nFigures--;
        }
    }

    @Override
    public boolean isFinalJoc() {
        return finalJoc;
    }

    @Override
    public void finalJoc() {
        System.out.println("S'ha acabat");

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Pluja de Formes"};
        JocPlujaDeFormes joc = new JocPlujaDeFormes(true, 100);
        PApplet.runSketch(processingArgs, joc);
//        JocPlujaDeFormes joc2 = new JocPlujaDeFormes(true, 1000);
//        PApplet.runSketch(processingArgs, joc2);

    }

}
