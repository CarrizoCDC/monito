package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Arbol {
    int y;
    int x;
    Image img;
    public Arbol(int x, int y){
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("arbol.png");
    }

    void moverse(){
        this.x -= 1; 
    }

    public void dibujarse(Entorno e) {
    	e.dibujarImagen(img, this.x, this.y, 0, 1);
    }
    
}
