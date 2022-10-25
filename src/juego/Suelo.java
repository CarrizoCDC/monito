package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Suelo {
    int x; int y;
    Image img;
    public Suelo(){
        img = Herramientas.cargarImagen("rama.png");
    }

    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(img, this.x, this.y, 0, 1);
    }
}
