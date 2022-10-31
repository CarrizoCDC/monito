package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Arbol {
    int y; int x;
    Image img;
    public Arbol(int x, int y){
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("arbol.png");
    }

    public void moverse(){
        this.x -= 2; 
    }

    public void dibujarse(Entorno e) {
    	e.dibujarImagen(img, this.x, this.y, 0, 1.5);
    }
    
    //GETTERS
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //SETTERS
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
