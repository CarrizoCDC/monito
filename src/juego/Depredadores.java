package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Depredadores {
    private int x;
    private int y;
    Image img;
    String nombre;
    
    int anchoPuma = 100;
    int altoPuma = 71;
    int anchoSer = 44;
    int altoSer = 45;

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

    public void moversePuma(){
        this.x -= 2.5;
    }

    
    public void moverseSerpiente(){
        this.x -= 2;
    }

    public void dibujarse(Entorno e, String name) {
        this.nombre = name;
        if (name == "puma"){
            e.dibujarImagen(img, this.x, this.y, 0, 0.2);
        } else if (name == "serpiente") {
    	    e.dibujarImagen(img, this.x, this.y, 0, 0.05);
        }
    }

    //GETTERS
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int getAnchoSer(){
        return this.anchoSer;
    }

    public int getAltoSer(){
        return this.altoSer;
    }

    public int getAnchoPuma(){
        return this.anchoSer;
    }

    public int getAltoPuma(){
        return this.altoSer;
    }

    //SETTERS
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setAnchoSer(int anchoSer){
        this.anchoSer= anchoSer;
    }

    public void setAltoSer(int altoSer){
        this.altoSer = altoSer;
    }


    public void setAnchoPuma(int anchoPuma){
        this.anchoPuma = anchoPuma;
    }

    public void setAltoPuma(int altoPuma){
        this.altoPuma = altoPuma;
    }

   
}
