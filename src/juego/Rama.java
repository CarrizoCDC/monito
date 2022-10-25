package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rama {
    int x; int y;
    Image img;
    public Rama(int x, int y){
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("rama.png");
    }
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(img, this.x, this.y, 0, 0.07);
    }
}
