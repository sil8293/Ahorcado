import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

/*
 * Autor Silvia Sassa
 * 
 * La clase Animación2 realiza la animación pero con un buble while
 * 
 */

public class Animacion2 extends GraphicsProgram {
	int velocidadX = 1;
	int velocidadY = 2;

	public void run (){
		GOval pelota = new GOval (50,50);
		pelota.setFilled(true);
		pelota.setFillColor(Color.MAGENTA);
		add(pelota);
		while (true){
			pelota.move(velocidadX,velocidadY);
			pause (5);
			//si la posicion x de la pelota es superior a 1024 
			//es que ha tocado la pared derecha y tiene que volver
			if(pelota.getLocation().getX()>1870|| (pelota.getLocation().getX()<0)){
				velocidadX= velocidadX * (-1);
				//si la posicion y de la pelota es superior a 1024 
				//es que ha tocado la pared derecha y tiene que volver
			}
			if (pelota.getLocation().getY()>960 || (pelota.getLocation().getY()<0)){

				velocidadY= velocidadY * (-1);}
			
		}


	}

}
