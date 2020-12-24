package juegos;

import figuras.Pacman;
import processing.core.PApplet;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 10-nov-2019
 */
public class JuegoTodosPacman extends Joc {

     private final int N_FIGURES;
    private Pacman[] pelotas;
    private int nFigures;
    private boolean finalJoc;

    public JuegoTodosPacman( int nFigures) {
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
        pelotas[0]=new Pacman(this,40,40);
        
            for(int i=1;i<pelotas.length;i++){
                boolean same=true;
                do{
                    pelotas[i]=new Pacman(this,40,40);
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
                for(int j=0;j<pelotas.length&& pelotas[i].isActiva();j++){
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
        String[] processingArgs = {"Pluja de Formes"};
        JuegoTodosPacman joc = new JuegoTodosPacman(100);
        PApplet.runSketch(processingArgs, joc);

    }


}
