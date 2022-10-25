package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Depredadores {
    private int x;
    private int y;
    Image img;
    String nombre;
    public Depredadores(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.nombre = name;
        if (name == "serpiente"){
            img = Herramientas.cargarImagen("serpiente.png");
        } else if (name == "puma"){
            img = Herramientas.cargarImagen("puma.png");
        } 
    }

    public void moverse(){
        this.x -= 1;
    }

    public void dibujarse(Entorno e, String name) {
        this.nombre = name;
        if (name == "puma"){
            e.dibujarImagen(img, this.x, this.y, 0, 0.2);
        } else if (name == "serpiente") {
    	    e.dibujarImagen(img, this.x, this.y, 0, 0.05);
        }
    }
}
