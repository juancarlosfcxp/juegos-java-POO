package juegos;

import figuras.PelotaAmpliada;
import processing.core.PApplet;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 10-nov-2019
 */
public class Agario extends JuegoDeSupervivencia {
    
    private PelotaAmpliada p1 = new PelotaAmpliada(2,2,30,0,0,255,0,0);
    
    public Agario(int nFiguras){
        super(nFiguras);
        
    }
    @Override
    public void prepararJoc() {
        super.prepararJoc();
        super.pelotas[0]=p1;
    }
    
    
    
    @Override
    public void jugada() {
        if(!this.pelotas[0].isActiva()){
            this.finalJoc=true;
        }
        
        if(pelotas[0].getX()< this.mouseX){
            pelotas[0].setvX(Math.abs(pelotas[0].getvX()));
        }
        if(pelotas[0].getY()< this.mouseY){
            pelotas[0].setvY(Math.abs(pelotas[0].getvY()));
        }
        if(pelotas[0].getX()> this.mouseX){
            pelotas[0].setvX(-Math.abs(pelotas[0].getvX()));
        }
        if(pelotas[0].getY()> this.mouseY){
            pelotas[0].setvY(-Math.abs(pelotas[0].getvY()));
        }
        
        super.jugada();
    }

    public static void main(String[] args) {
        String[] processingArgs = {"Agario"};
        Agario joc = new Agario(10);
        PApplet.runSketch(processingArgs, joc);

    }
}