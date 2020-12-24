package juegos;

import figuras.PelotaAmpliada;
import processing.core.PApplet;
/**
 *
 * @author CARLOS FLORES
 * @version 2.0 09-nov-2019
 */
public class JuegoDeSupervivencia extends Joc {
    private final int N_FIGURES;
    public PelotaAmpliada[] pelotas;
    private int nFigures;
    public boolean finalJoc;

    public JuegoDeSupervivencia( int nFigures) {
        finalJoc = false;
        N_FIGURES = nFigures;
    }

    /**
     * Selecciona els valors per defecte d'amplada, fondaria i background.
     */
    @Override
    public void marcSettings() { //settings
        setSize(DEFAULT_AMPLADA, DEFAULT_FONDARIA);
        setBackground(255);
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
            marcSetup();
            for(int i=0;i<pelotas.length;i++){
                pelotas[i].dibuixa(this);
            }
    }

    @Override
    public void prepararJoc() {
        nFigures = N_FIGURES;
        pelotas = new PelotaAmpliada[N_FIGURES];
        pelotas[0]=new PelotaAmpliada(this,40,40);
        
            for(int i=1;i<pelotas.length;i++){
                boolean same=true;
                do{
                    pelotas[i]=new PelotaAmpliada(this,40,40);
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
        if (nFigures == 1) {
            finalJoc = true;
        } else {
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
        String[] processingArgs = {"Juego de supervivencia"};
        JuegoDeSupervivencia joc = new JuegoDeSupervivencia(100);
        PApplet.runSketch(processingArgs, joc);

    }


}
