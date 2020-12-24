package juegos;

import figuras.Ladrillo;
import figuras.Pilota;
import processing.core.PApplet;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 13-nov-2019
 */
public class JuegoLadrillos extends Joc {

    private Pilota pilota;
    private boolean finalJoc;
    private Ladrillo[]ladrillos = new Ladrillo[20];
    public JuegoLadrillos() {
        finalJoc = false;
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
            background(getBackground());
        pilota.dibuixa(this);
        for(int i=0;i<ladrillos.length;i++){
            ladrillos[i].dibuixa(this);
        }
    }

    @Override
    public void prepararJoc() {
        pilota = new Pilota(this, 40, 40);
        pilota.setvX(5);
        pilota.setvX(-5);
        float x=0;
        float y=0;
        float base=100;
        float altura=50;
        for(int i=0;i<ladrillos.length;i++){
            ladrillos[i]=new Ladrillo(x,y,base,altura,0,255,0);
            x=x+base;
            if(x>=this.width){
                x=0;
                y=y+altura;
            }
        }
    }

    @Override
    public void jugada() {
            pilota.mou(this);
            for(int i=0; i<ladrillos.length;i++){
                if(ladrillos[i].isActivo()){
                    ladrillos[i].colicion(pilota);
                }
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
        JuegoLadrillos joc = new JuegoLadrillos();
        PApplet.runSketch(processingArgs, joc);
//        JocPilota joc2 = new JocPilota(false, 1000);
//        PApplet.runSketch(processingArgs, joc2);

    }
}
