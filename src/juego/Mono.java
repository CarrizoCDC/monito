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
    int ancho = 64;
    int alto = 76;

    public Mono(int x, int y) {
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("mono.png");

    }

    // GETTERS
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    // SETTERS
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setAncho(int ancho){
        this.ancho = ancho;
    }

    public void setAlto(int alto){
        this.alto = alto;
    }

    public void saltar() {
        this.y -= 3;
    }

    public void bajar() {
        this.y += 3;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(img, this.x, this.y, 0, 0.05);

    }
}
