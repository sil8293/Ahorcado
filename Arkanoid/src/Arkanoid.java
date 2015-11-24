
/*
 * *********************************
 * 		Autor:Silvia Sassa         *
 * *********************************
 * Este el es juago de Arcanoid
 */
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;




public class Arkanoid extends GraphicsProgram {
	private static final int ANCHO_PANTALLA =700;
	private static final int ALTO_PANTALLA = 800;

	//contantes para el rectangulo
	private static int N_FILAS =10;
	private static int N_COLUMNAS =2;
	//constantes para la pirámide


	private static final int LADRILLOS_BASE = 9;
	//tamaño de la pelota
	int ANCHO_LADRILLO ;
	int ALTO_LADRILLO;
	int alto_pelota ;
	int ANCHO_CURSOR;
	int ALTO_CURSOR;

	GImage fondo = new GImage("ImagenArkanoid/nivel1.jpg");


	GImage pelota = new GImage("ImagenArkanoid/pelota.png");

	GImage inicio = new GImage("ImagenArkanoid/inicio.jpg");
	GImage nivel1 = new GImage("ImagenArkanoid/nivel1.jpg");

	GImage nivel2 = new GImage("ImagenArkanoid/nivel2.jpg");
	GImage nivel3 = new GImage("ImagenArkanoid/nivel3.jpg");
	GImage cursor = new GImage("ImagenArkanoid/pez-muerto.png");

	GImage perro1 = new GImage("ImagenArkanoid/perro1.png");
	GImage perro2 = new GImage("ImagenArkanoid/perro2.png");
	GImage perro3 = new GImage("ImagenArkanoid/perro3.png");


	GImage pulgoso = new GImage("ImagenArkanoid/pulgoso.gif");
	GImage pulgosoEnfadado = new GImage("ImagenArkanoid/pulgosoEnfadado.gif");


	//velocidad en el eje x
	double xVelocidad = 3;  
	//velocidad en el eje y
	double yVelocidad = -3;  


	public void init(){
		alto_pelota=(int) pelota.getHeight();

		ANCHO_CURSOR=(int) cursor.getWidth();
		ALTO_CURSOR=(int) cursor.getHeight();


		ANCHO_LADRILLO=(int) perro1.getWidth();
		ALTO_LADRILLO=(int) perro1.getHeight();



		//cambio el tamaño de la ventana
		setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
		fondo.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
		add(fondo);

		
		
		
		//añado a pulgoso
		
		add(pulgoso,200, 50);
		
		
		add(cursor, 0, ALTO_PANTALLA-100);


		add(pelota, 0, ALTO_PANTALLA-130);

		//pintaPiramide();
		pintaRectangulo();

		addMouseListeners();
	}

	public void run(){
		while(true){
			pelota.move(xVelocidad, yVelocidad);
			chequeaColision();
			pause(15);
		}
	}

	private void pintaPiramide(){
		int x= -(ANCHO_PANTALLA - LADRILLOS_BASE*ANCHO_LADRILLO) /2;

		//utiliza 240 para que aprezca por debajo del dibujo de pulgoso
		int y= 240;

		for (int j=0; j<LADRILLOS_BASE; j++){
			for (int i=j; i<LADRILLOS_BASE; i++){
				GImage perro1 = new GImage("ImagenArkanoid/perro1.png");
				add (perro1,i*ANCHO_LADRILLO-x,y+j*ALTO_LADRILLO);
				pause(60);
			}
			x = x+ANCHO_LADRILLO/2;
		}
	}
	private void pintaRectangulo(){
		int x= -(ANCHO_PANTALLA-N_FILAS *ANCHO_LADRILLO) /2;
		int y= 240;

				
				for(int k=0;k<N_COLUMNAS*2;k++){
					for(int l=0;l< N_FILAS; l ++){
				GImage perro1 = new GImage("ImagenArkanoid/perro1.png");
				add (perro1,l*ANCHO_LADRILLO-x,y+k*ALTO_LADRILLO);
				pause(60);
			}
			
					
		}

				for(int j=0;j<N_COLUMNAS;j++){
					for(int i=0;i< N_FILAS; i ++){
						GImage perro2 = new GImage("ImagenArkanoid/perro2.png");
						add (perro2,i*ANCHO_LADRILLO-x,y+j*ALTO_LADRILLO);
						pause(60);
				
					
					}
					}	

	}




	private void chequeaColision(){
		if (chequeaPared()){
			//chequeo si toca con el cursor
			if(!chequeaCursor()){
				//chequeaLadrillos();
			}
		}

	}
	private boolean chequeaPared(){
		boolean auxiliar = true;
		//si toca el techo
		if (pelota.getY() <= 0){
			yVelocidad = -yVelocidad;
			auxiliar = false;
		}

		//si toca la pared derecha
		if (pelota.getX() >= ANCHO_PANTALLA-15 - alto_pelota){
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}

		//si toca la pared izquierda
		if (pelota.getX() <= 0){
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}
		return auxiliar;
	}


	//chequeaCursor devolverá true si ha chocado el cursor con la pelota
	// y false si no ha chocado.
	private boolean chequeaCursor(){
		if (getElementAt(pelota.getX(), pelota.getY()+alto_pelota)==cursor){
			yVelocidad = -yVelocidad;	
		}
		else if (getElementAt(pelota.getX()+alto_pelota, pelota.getY()+alto_pelota)==cursor){
			yVelocidad = -yVelocidad;	
		}
		else if (getElementAt(pelota.getX(), pelota.getY())==cursor){
			xVelocidad = -xVelocidad;	
		}
		else if (getElementAt(pelota.getX()+alto_pelota, pelota.getY())==cursor){
			xVelocidad = -xVelocidad;	
		}else {
			return false;
		} 
		return true;
	}


	//mueve el cursor siguiendo la posición del ratón
	public void mouseMoved (MouseEvent evento){
		if( (evento.getX()+ANCHO_CURSOR) <= ANCHO_PANTALLA-15){
			cursor.setLocation(evento.getX(),ALTO_PANTALLA-100);
		}
	}


}
