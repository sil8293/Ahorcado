import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/*
 * Autor: Silvia Sassa
 * --------------------
 * este programa muestra tecnica básica de animación
 * va a mover un GRect desde la coordenada 0,0 
 * hasta la esquia inferior derecha
 */

public class Animacion1 extends GraphicsProgram{

	private static int LADO=20;
	//numero de pasos en los que recorre la distancia
	private static int N_PASOS =50000;
	public void run(){
		RandomGenerator aleatorio=new RandomGenerator();
		//creamos el rectangulo
		
		for (int i=0;i<N_PASOS;i++){
			int anchoCirculo=aleatorio.nextInt(50);
			GOval circulo =new GOval (anchoCirculo,anchoCirculo);
			// lo pintamos de un color
			circulo.setFilled(true);
			circulo.setFillColor(aleatorio.nextColor());
			add(circulo,aleatorio.nextInt(1920),aleatorio.nextInt(1080));
			pause(10);
		}
		

		//		for (int i=0; i< N_PASOS;i++){
		//			cuadrado.move(aleatorio.nextInt(-2,2),aleatorio.nextInt(-2,2));
		//			pause(5);
		//			
		//		}
		//		

	}
}
