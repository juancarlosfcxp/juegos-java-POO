package figuras;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 12-nov-2019
 */

import juegos.Joc;
import utils.Utils;



public class Ladrillo extends Figura {
    
    private float base;
    private float altura;
    private boolean activo = true;
    
    public Ladrillo(float x, float y, float base, float altura,int colorR, int colorG, int colorB) {
        super(x, y, colorR, colorG, colorB);
        this.base =base;
        this.altura=altura;
    }

    @Override
    public double area() {
        
        return (base * altura);
    }

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void colicion(Pilota c) {
     
    float distX = Math.abs((c.getX()-c.getRadi()) - this.getX());
    float distY = Math.abs((c.getY()-c.getRadi())  - this.getY());

    if (distX <= (this.getBase()/2) && distY <= (this.getAltura()/2)) {
        this.setActivo(false); 
        c.setvY(-Math.abs(c.getvY()));} 
    
    }

    @Override
    public void dibuixa(Joc joc) {
        if(this.activo){
        joc.fill(this.getColorR(),this.getColorG(),this.getColorB());
        joc.rect((float)this.getX(),(float)this.getY(),base,altura);
        }
    }
}