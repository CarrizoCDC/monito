package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.awt.Color;
import java.awt.Image;
import java.awt.*;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Depredadores puma;
	Depredadores serpiente;
	Mono mono;
	Piedra piedra;
	Fondo fondo;
	Rama rama;
	Arbol arbol;
	double tope;
	double piso;
	double monoY;
	double sube;

	// Metodos a utilizar
	void dibujarRectangulo(double x, double y, double ancho, double alto, double angulo, Color color) {
		// Dibuja un rectangulo centrado en el punto (x,y) de la pantalla, rotado en el
		// angulo dado{
		// Rectangle r = new Rectangle();
	}

	void dibujarTriangulo(double x, double y, int altura, int base, double angulo, Color color) {
		// Dibuja un triangulo centrado en el punto (x,y) de la pantalla, rotado en el
		// angulo dado.
	}

	void dibujarCirculo(double x, double y, double diametro, Color color) {
		// Dibuja un cırculo centrado en el punto (x,y) de la pantalla, del tamanio
		// dado.
	}

	void dibujarImagen(Image imagen, double x, double y, double ang) {
		// Dibuja la imagen centrada en el punto (x,y) de la pantalla rotada en el
		// angulo dado.
	}
	// boolean sePresiono(char t){
	// //Indica si la tecla t fue presionada en este instante de tiempo (es decir,
	// no estaba presionada
	// //en la ultima llamada a tick(), pero sı en esta). Este metodo puede ser util
	// para identificar
	// //eventos particulares en un unico momento, omitiendo tick() futuros en los
	// cuales el usuario
	// //mantenga presionada la tecla en cuestion.
	// }

	void escribirTexto(String texto, double x, double y) {
		// Escribe el texto en las coordenadas x e y de la pantalla.
	}

	void cambiarFont(String font, int tamano, Color color) {
		// Cambia la fuente para las pr´oximas escrituras de texto seg´un los
		// par´ametros recibidos.
	}

	Juego() {

		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Cuidando a los Monos Capuchinos - Grupo 5", 800, 600);

		// Inicializar lo que haga falta para el juego
		// ...
		sube = 0;
		piso = 450;
		tope = 0;
		monoY = 0;
		puma = new Depredadores(760, 450, "puma");
		serpiente = new Depredadores(800, 350, "serpiente");
		mono = new Mono(100, 450);
		fondo = new Fondo(400, 300);
		piedra = new Piedra(0, 500);
		arbol = new Arbol(760, 360);

		rama = new Rama(700, 365);
		// fondo = new Fondo(800, 600);

		// Inicia el juego!
		entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y
	 * por lo tanto es el método más importante de esta clase. Aquí se debe
	 * actualizar el estado interno del juego para simular el paso del tiempo
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...

		fondo.dibujarse(entorno);

		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			if (tope == 0) {
				tope = piso - 160;
				sube = 1;
			}
		}
		if (tope != 0) {
			monoY = mono.getY();
			if (monoY >= tope && sube == 1) {
				mono.saltar();
			} else if (piso >= monoY) {
				sube = 2;
				if (monoY == piso) {
					sube = 0;
					tope = 0;
				} else {
					mono.bajar();
				}

			}
		}
		mono.dibujarse(entorno);
		arbol.dibujarse(entorno);
		rama.dibujarse(entorno);
		serpiente.dibujarse(entorno, serpiente.nombre);
		puma.dibujarse(entorno, puma.nombre);
		piedra.dibujarse(entorno);
		// arbol.moverse();
		// puma.moverse();
		// serpiente.moverse();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
