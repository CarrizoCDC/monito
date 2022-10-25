package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Piedra {
    public static Object arrojar;
    int x; int y;
    Image img;
    Mono m;
     
    public Piedra(int x, int y){
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("piedra.png");
    }

    public void arrojar(){
        this.x += 1;
    }

    public void moverse(){
        this.x += 1;
        
    }

    public void dibujarse(Entorno e) {
        if (m.arrojarPiedra() == true){
            e.dibujarImagen(img, this.x, this.y, 0, 0.02);
        }
    	
    }
}
