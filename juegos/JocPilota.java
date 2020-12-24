/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import figuras.Cercle;
import figuras.Figura;
import figuras.Pilota;
import processing.core.PApplet;

/**
 *
 * @author pere
 */
public class JocPilota extends Joc {

    private int nIteracions;
    private Pilota pilota;

    private final boolean continu;
    private boolean finalJoc;

    public JocPilota(boolean continu, int nIteracions) {
        this.continu = continu;
        finalJoc = false;
        this.nIteracions = nIteracions;
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
        pilota.dibuixa(this);
    }

    @Override
    public void prepararJoc() {
        pilota = new Pilota(this, 20, 20);
    }

    @Override
    public void jugada() {
        if (nIteracions == 0) {
            finalJoc = true;
        } else {
            pilota.mou(this);
            nIteracions--;
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
        JocPilota joc = new JocPilota(true, 10000);
        PApplet.runSketch(processingArgs, joc);
//        JocPilota joc2 = new JocPilota(false, 1000);
//        PApplet.runSketch(processingArgs, joc2);

    }

}
