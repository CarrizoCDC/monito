package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.util.Random;
import java.awt.Rectangle;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Mono mono;
	Piedra piedra;
	Fondo fondo;
	Puntos marcador;
	double tope;
	double piso;
	double monoY;
	double sube;
	double puntos;
	int x;
	Random numero;
	int distancia;
	int ramasBajas;
	int ramasAltas;
	int posicionxnull;
	int topeRama;
	boolean juegoTerminado;

	//RECTANGULOS DE OBJETOS PARA COLISIONES
	Rectangle rmono; 
	Rectangle rpuma;
	Rectangle rpiedra;
	Rectangle rserpiente;
	Rectangle rrama;

	//ARREGLOS DE OBJETOS
	Arbol[] arboles;
	Depredadores[] pumas;
	Depredadores[] serpientes;
	Rama[] ramas;
	


	// Metodos a utilizar

	public int ramasYAzar(int minimo, int maximo){  // Devuelve un numero azar (que usaremos como coordenada y)
		int YAzar = minimo + numero.nextInt(maximo+1 - minimo);
		return YAzar;
	}

	public int xAzar(int minimo, int maximo){  // Devuelve un numero azar (que usaremos como coordenada y)
		int xAzar = minimo + numero.nextInt(maximo+1 - minimo);
		return xAzar;
	}

	Juego() {

		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Cuidando a los Monos Capuchinos - Grupo 5", 800, 600);

		// Inicializar lo que haga falta para el juego
		distancia = 1000;
		x = 0;
		posicionxnull = 0;
		numero = new Random();
		sube = 0;
		piso = 470;
		tope = 0;
		monoY = 0;
		ramasBajas = 400;
		ramasAltas = 280;
		topeRama = 0;
		juegoTerminado = false;

		marcador = new Puntos();
		mono = new Mono(100, 470);
		fondo = new Fondo(400, 300);

		//INSTANCIAMOS RECTANGULOS DE OBJETOS
		rmono = new Rectangle();
		rpuma = new Rectangle();
		rserpiente = new Rectangle();
		rrama = new Rectangle();
		rpiedra = new Rectangle();

		//INSTANCIAMOS ARBOLES
		arboles = new Arbol[4];
		for (int i = 0; i < arboles.length; i++) {
			arboles[i] = new Arbol (distancia, 338);
			distancia = distancia + 300;
		}
		distancia = 1000;

		

		//INSTANCIAMOS PUMAS
		pumas = new Depredadores[3];
		for (int i = 0; i < pumas.length; i++) {
			pumas[i] = new Depredadores (xAzar(1000, 1500) + 200, 470, "puma");
		}


		//INSTANCIAMOS RAMAS Y SERPIENTES
		ramas = new Rama[4];
		serpientes = new Depredadores[3];
		for (int i = 0; i < ramas.length; i++) {
			ramas[i] = new Rama (arboles[i].getX(),ramasYAzar(ramasAltas, ramasBajas)); //alturas ramas:350 (mas baja) y 280 (mas alta)
		}
		for (int i = 0; i < serpientes.length; i++){
			serpientes[i] = new Depredadores(arboles[i].getX(), ramas[i].getY()-40, "serpiente");
		}

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
		marcador.dibujarse(entorno);
	
		// rmono.x = mono.getX();
		// rmono.y = mono.getY();
		// rmono.width = mono.getAncho();
		// rmono.height = mono.getAlto();

		// Se verifica si se presiona la flecha arriba o la W.
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) || entorno.estaPresionada('W')) {
			if (tope == 0) {   		// Ver que comentar aca con Emir
				tope = piso - 250;
				sube = 1;
			}
		}
		if (tope != 0) {
                monoY = mono.getY();
                if (monoY >= tope && sube == 1) {
                    mono.saltar();
                    for (int i = 0; i < ramas.length; i++) {
                        rrama.x = ramas[i].getX();
                        rrama.y = ramas[i].getY();
                        rrama.width = ramas[i].getAncho();
                        rrama.height = ramas[i].getAlto() + ramas[i].getAlto() / 2;
                        if (rrama.intersects(rmono)) {
                            tope = monoY;
                        }
                    }
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
		

		//DIBUJAMOS ARBOLES Y RAMAS 
		for (int i = 0; i < arboles.length; i++){  // Recorremos el arreglo de arboles

			if (arboles[i].getX() < (-100)) {  // Verificamos si la x de cada arbol es menor a -100
				distancia = 825 + 350;         // Si llega a ser menor, se setea la variable distancia, para que se reinicie el ciclo de los arboles
				arboles[i].setX(arboles[i].getX() + distancia);  // Seteamos las x de los arboles, para que cada puma tenga una x distinto y no salgan en la misma coordenada x
				
				ramas[i].setX(arboles[i].getX());  // Seteamos las x de las ramas en base a los arboles, para que se muevan con ellos. 		
				ramas[i].setY(ramasYAzar(ramasAltas, ramasBajas));  // Seteamos las y de las ramas en azar, en torno a las medidas de ramas bajas y ramas altas
			}

			rrama.x = ramas[i].getX();
			rrama.y = ramas[i].getY();
			rrama.width = ramas[i].getAncho();
			rrama.height = ramas[i].getAlto();
		
			arboles[i].dibujarse(entorno);
			ramas[i].dibujarse(entorno);
			arboles[i].moverse();
			ramas[i].moverse();
		}

		//DIBUJAMOS PUMAS Y SERPIENTES
		for (int i = 0; i < pumas.length; i++) {  // Recorremos el arreglo de pumas
			if (pumas[i].getX() < (-100)) {  // Verificamos si la x de cada puma es menor a -100
		     	pumas[i].setX(xAzar(1000,1500) + 200);  // Si llega a ser menor, se setea la variable distancia, para que se reinicie el ciclo de los pumas
				 			 											// Si ocurre esto, entonces, le seteamos valores al azar de X.
			}

			if (serpientes[i].getX() < (-100)){			 // Verificamos si las x de cada serpiente es menor a -100
				serpientes[i].setX(arboles[i].getX());   // Si ocurre esto, seteamos las x de las serpiente en base a la x de los arboles + 50
				serpientes[i].setY(ramas[i].getY()-40);  // Y seteamos las y de las serpientes en base a la de las ramas -40
			}			
			
			pumas[i].dibujarse(entorno, "puma");
			serpientes[i].dibujarse(entorno, "serpiente");
			pumas[i].moversePuma();
			serpientes[i].moverseSerpiente();
			
			// rserpiente.x = serpientes[i].getX();
			// rserpiente.y = serpientes[i].getY();
			// rserpiente.width = serpientes[i].getAnchoSer();
			// rserpiente.height = serpientes[i].getAltoSer();

			// rpuma.x = pumas[i].getX();
			// rpuma.y = pumas[i].getY();
			// rpuma.width = pumas[i].getAnchoPuma();
			// rpuma.height = pumas[i].getAltoPuma();

		}

		if (mono != null){
			rmono.x = mono.getX();
			rmono.y = mono.getY();
			rmono.width = mono.getAncho();
			rmono.height = mono.getAlto();
			
			mono.dibujarse(entorno);
			
			for (int i = 0; i < pumas.length; i++){
				rserpiente.x = serpientes[i].getX();
				rserpiente.y = serpientes[i].getY();
				rserpiente.width = serpientes[i].getAnchoSer();
				rserpiente.height = serpientes[i].getAltoSer();

				rpuma.x = pumas[i].getX();
				rpuma.y = pumas[i].getY();
				rpuma.width = pumas[i].getAnchoPuma();
				rpuma.height = pumas[i].getAltoPuma();
				if (rpuma.intersects(rmono)){
					pumas[i] = null;
					mono = null;
				}
				
				if (pumas[i] == null) {
					pumas[i] = new Depredadores(xAzar(1000, 1500) + 500, 470, "puma");
				}

				if (rserpiente.intersects(rmono)){
					serpientes[i] = null;
					mono = null;
				}

				if (serpientes[i] == null) {
					serpientes[i] = new Depredadores(posicionxnull, 900,"serpiente");
				}
			}
		// mono.dibujarse(entorno);
		}
		if (mono == null){
			for (int i = 0; i < pumas.length; i ++){
				pumas[i] = null;
				serpientes[i] = null;
			}
			marcador.cartelFinal(entorno);
			entorno.removeAll();

		}

		


		if (piedra == null){
			// Se verifica si se presiona la flecha derecha o la D, se lanza la piedra.
			if (entorno.estaPresionada(entorno.TECLA_DERECHA) || entorno.estaPresionada('D')) {	
				piedra = new Piedra(mono.getX(), mono.getY());	// Si piedra es igual a null, se crea una nueva piedra.
			}
		}
		
		if (piedra != null) {
			rpiedra.x = piedra.getX();
			rpiedra.y = piedra.getY();
			rpiedra.width = piedra.getAncho();
			rpiedra.height = piedra.getAlto();

			piedra.dibujarse(entorno); // Si piedra es distinto de null, se dibuja y se arroja
			piedra.arrojar();
			if (piedra.getX() > 800) {  //Si la x de piedra en un momento es mayor a 800, pìedra se evuelve null
				piedra = null;
			}
			for (int i = 0; i < pumas.length; i++){
				
// En cada iteracion se asigna a cada rectangulo de objeto, los valores que deberia tener en base al objeto.
				rpuma.x = pumas[i].getX();
				rpuma.y = pumas[i].getY();
				rpuma.width = pumas[i].getAnchoPuma();
				rpuma.height = pumas[i].getAltoPuma();

				if (rpiedra.intersects(rpuma)){
					piedra = null;
					pumas[i] = null;
					marcador.sumarPuntosPuma();
				}

				if (pumas[i] == null){
					pumas[i] = new Depredadores(xAzar(1000, 1500) + 200, 470, "puma");
				}

				rserpiente.x = serpientes[i].getX();
				rserpiente.y = serpientes[i].getY();
				rserpiente.width = serpientes[i].getAnchoSer();
				rserpiente.height = serpientes[i].getAltoSer();

				rmono.x = mono.getX();
				rmono.y = mono.getY();
				rmono.width = mono.getAncho();
				rmono.height = mono.getAlto();
				
				if (rpiedra.intersects(rserpiente)){
					piedra = null;
					posicionxnull = serpientes[i].getX();
					serpientes[i] = null;
					marcador.sumarPuntosSerpiente();

				}
				if (serpientes[i] == null){
					serpientes[i] = new Depredadores(posicionxnull, 900, "serpiente");
				}
			}
		}
	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
