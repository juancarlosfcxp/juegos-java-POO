package figuras;
import juegos.Joc;
/**
 *
 * @author CARLOS FLORES
 * @version 2.0 13-nov-2019
 */
public class Pacman2 extends Pacman{

        private boolean activa=true;
        private static int angulo=100;

    
    
    public Pacman2(float vX, float vY, int radi, float x, float y, int colorR, int colorG, int colorB) {
        super(vX, vY, radi, x, y, colorR, colorG, colorB);
    }
    
    public Pacman2(Joc joc, int margeX, int margeY) {
        super(joc, margeX, margeY);
    }
    
    public boolean intersec(Pacman otraPelota){
        float x1=this.getX();
        float y1=this.getY();
        float x2=otraPelota.getX();
        float y2=otraPelota.getY();
        
        double d = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        
        if(d>this.getRadi()+otraPelota.getRadi()){
            return false;
        }
        else return true;
    }
    
    public int join(Pacman otraPelota,int cont){
        if(otraPelota.isActiva()==true){
            if(this.intersec(otraPelota)==true){
                cont--;
                int nuevoRadio=(int)Math.sqrt((this.area()+otraPelota.area())/Math.PI);
                
                if(this.getRadi()>=otraPelota.getRadi()){
                    otraPelota.setActiva(false);
                    this.setRadi(nuevoRadio);
                }
                else{
                    this.setActiva(false);
                    otraPelota.setRadi(nuevoRadio);
                }
            }
        }
return cont;
    }

    public boolean isActiva() {
        return activa;
    }
    

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    @Override
    public void dibuixa(Joc joc){
        
        float x=this.getX();
        float y=this.getY();
        int radi=this.getRadi();
        
       if(this.isActiva()==true) {
               joc.fill(255, 255, 0);
                joc.ellipse(x, y, 2*radi, 2*radi);
                joc.fill(0);
                joc.ellipse(x,y-(radi/2), 2*(radi/6), 2*(radi/6));
                joc.triangle(x,y,x+radi,y-((radi*angulo)/100), x+radi,y+((radi*angulo)/100));
                             angulo--;
                if(angulo==20){
                    angulo=100;
                }

       }
    }
}
