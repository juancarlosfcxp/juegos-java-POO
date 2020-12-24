package figuras;

import juegos.Joc;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 08-nov-2019
 */
public class PelotaAmpliada extends Pilota{
    
    private boolean activa=true;

    public PelotaAmpliada(float vX, float vY, int radi, float x, float y, int colorR, int colorG, int colorB) {
        super(vX, vY, radi, x, y, colorR, colorG, colorB);
    }
    
    public PelotaAmpliada(Joc joc, int margeX, int margeY) {
        super(joc, margeX, margeY);
    }
    
    public boolean intersec(PelotaAmpliada otraPelota){
        float x1=this.getX();
        float y1=this.getY();
        float x2=otraPelota.getX();
        float y2=otraPelota.getY();
        
        double d = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1+-y2),2));
        
        if(d>this.getRadi()+otraPelota.getRadi()){
            return false;
        }
        else {return true;}
    }
    
    public int join(PelotaAmpliada otraPelota,int cont){
        if(otraPelota.isActiva()){
            if(this.intersec(otraPelota)){
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
       if(this.isActiva()==true) {
           super.dibuixa(joc);
       }
    }
            
            
            
    public static void main(String[] args) {
        PelotaAmpliada p1=new PelotaAmpliada(0,0,50,100,100,0,255,255);
        PelotaAmpliada p2=new PelotaAmpliada(0,0,50,250,100,0,255,255);
        System.out.println(p1.intersec(p2));
        
    }
}
