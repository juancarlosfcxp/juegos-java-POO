package juegos;

import figuras.Fantasma;
import figuras.Pacman;
import figuras.Pacman2;
import processing.core.PApplet;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 13-nov-2019
 */
public class JuegoPacFant extends Joc{
    private final int N_FIGURES;
    public Pacman[] pelotas;
    private int nFigures;
    public boolean finalJoc;

    public JuegoPacFant( int nFigures) {
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
            background(getBackground());
            for(int i=0;i<pelotas.length;i++){
                pelotas[i].dibuixa(this);
            }
    }

    @Override
    public void prepararJoc() {
        nFigures = N_FIGURES;
        pelotas = new Pacman[N_FIGURES];
        pelotas[0]=new Pacman2(2,2,30,0,0,255,255,0);
        
            for(int i=1;i<pelotas.length;i++){
                boolean same=true;
                do{
                    pelotas[i]=new Fantasma(this,40,40);
                    for(int j=0;j<i;j++){
                        if(!pelotas[i].intersec(pelotas[j])){
                            same=false;
                        }
                    }
                    
                }while(same);
                
                
            }
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
            for(int i=0;i<pelotas.length;i++){
                pelotas[i].mou(this);
            }
            for(int i=0;i<pelotas.length;i++){
                if(pelotas[i].isActiva()){
                for(int j=0;j<pelotas.length && pelotas[i].isActiva() ;j++){
                    if(i!=j){
                        nFigures=pelotas[i].join(pelotas[j],nFigures);
                    }
                    
                }
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
        JuegoPacFant joc = new JuegoPacFant(20);
        PApplet.runSketch(processingArgs, joc);
//        JocPlujaDeFormes joc2 = new JocPlujaDeFormes(true, 1000);
//        PApplet.runSketch(processingArgs, joc2);

    }
}
