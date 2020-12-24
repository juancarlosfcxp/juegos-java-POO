/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import juegos.Joc;
import juegos.JocPilota;
import utils.Utils;

/**
 *
 * @author pere
 */
public class Pilota extends Cercle {

    final static int MIN_VELOCITAT = 1;
    final static int MAX_VELOCITAT = 3;

    private float vX;
    private float vY;
    //private float acceleracio;

    /**
     *
     * @param vX
     * @param vY
     * @param radi
     * @param x
     * @param y
     * @param colorR
     * @param colorG
     * @param colorB
     */
    public Pilota(float vX, float vY, int radi, float x, float y, int colorR, int colorG, int colorB) {
        super(radi, x, y, colorR, colorG, colorB);
        this.vX = vX;
        this.vY = vY;
    }

    /**
     * Crrem una pilota amb veelocitat vX i vY a l'atzar entre MIN_VELOCITAT i
     * MAX_VELOCITAT i la resta a l'atzar.
     *
     * @param joc
     * @param margeX
     * @param margeY
     */
    public Pilota(Joc joc, int margeX, int margeY) {
        super(joc, margeX, margeY);
        vX = Utils.velocitatAtzar(MIN_VELOCITAT, MAX_VELOCITAT);
        vY = Utils.velocitatAtzar(MIN_VELOCITAT, MAX_VELOCITAT);
    }

    public void mou(Joc joc) {
        setX(getX() + vX);
        setY(getY() + vY);

        if (getX() <= getRadi()) {
            vX = Math.abs(vX);
        }
        if (getY() <= getRadi()) {
            vY = Math.abs(vY);
        }
        if (getX() + getRadi() >= joc.width){
            vX = -Math.abs(vX);            
        }
        if (getY() + getRadi() >= joc.height){
            vY = -Math.abs(vY);            
        }

    }

    public void setvX(float vX) {
        this.vX = vX;
    }

    public void setvY(float vY) {
        this.vY = vY;
    }

    public float getvX() {
        return vX;
    }

    public float getvY() {
        return vY;
    }
    
    

}
