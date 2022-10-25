package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Mono {
    int x;
    int y;
    Image img;
    Piedra p;
    int puntos;

    public Mono(int x, int y) {
        this.x = x;
        this.y = y;

        img = Herramientas.cargarImagen("mono.png");
    }

    public double getY() {
        return this.y;
    }

    public void saltar() {
        this.y -= 4;
    }

    public void bajar() {
        this.y += 4;
    }

    public boolean arrojarPiedra() {
        boolean lanzar = true;
        if (lanzar == true) {
            p.arrojar();
        }
        return lanzar;
    }

    public void aciertoPiedra() {
        if (arrojarPiedra() == true) {
            puntos = +10;
        }
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(img, this.x, this.y, 0, 0.05);
    }
}
