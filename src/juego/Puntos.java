package juego;

import entorno.Entorno;
import java.awt.Color;
import java.awt.Rectangle;

public class Puntos {
    private int puntos = 0;
    public void sumarPuntosPuma() {
        this.puntos = this.puntos + 100;
    }

    public void sumarPuntosSerpiente() {
        this.puntos = this.puntos + 50;
    }


    public void sumarPuntosRama(){
        this.puntos = this.puntos + 25;
    }
    
    public void dibujarse(Entorno entorno) {
       entorno.cambiarFont(null, 20,Color.white);
       entorno.escribirTexto("HI SCORE: " + puntos,650, 25);
   }

   public void cartelFinal(Entorno entorno){
    Rectangle rfinal = new Rectangle(370, 300, entorno.getWidth()/2, entorno.getHeight()/2); 
    entorno.dibujarRectangulo(rfinal.x, rfinal.y, rfinal.width, rfinal.height, 0, Color.white);
    entorno.cambiarFont(null, 60, Color.black);
    entorno.escribirTexto("GAME OVER" ,rfinal.x/2, rfinal.y);
    
    int contCifras = 0;
    while(puntos != 0){             //mientras a n le queden cifras
            puntos = puntos/10;         //le quitamos el último dígito
            contCifras += 1;          //sumamos 1 al contador de cifras
    }
    if (contCifras == 0){
            entorno.escribirTexto("" + puntos,rfinal.x - 20, rfinal.getHeight() + 50);
    }
    if (contCifras == 1){
            entorno.escribirTexto("" + puntos,rfinal.x - 30, rfinal.getHeight() + 50);
    }
    if (contCifras == 2){
            entorno.escribirTexto("" + puntos,rfinal.x - 20, rfinal.getHeight() + 50);
    }
    if (contCifras == 3){
            entorno.escribirTexto("" + puntos,rfinal.x - 10, rfinal.getHeight() + 50);
    }
    if (contCifras == 4){
            entorno.escribirTexto("" + puntos,rfinal.x, rfinal.getHeight() + 50);
    }

}

   //GETTER
   public int getPuntos(){
        return this.puntos;
   }

   //SETTER
   public void setPuntos(int puntos){
        this.puntos = puntos;
   }
   
   
}
