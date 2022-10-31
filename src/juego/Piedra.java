package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Piedra {
    int x; int y;
    Image img;
    Mono m;
    double puntos; 
    int ancho = 30;
    int alto = 17;
   
    public Piedra(int x, int y){
        this.x = x;
        this.y = y;
        img = Herramientas.cargarImagen("piedra.png");
    }

    public void arrojar(){
        this.x += 5;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(img, this.x, this.y, 0, 0.01);
    }
    
    //GETTERS
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

    //SETTERS
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public void setAncho(int ancho){
        this.ancho = ancho;
    }

    public void setAlto(int alto){
        this.alto = alto;
    }
}
