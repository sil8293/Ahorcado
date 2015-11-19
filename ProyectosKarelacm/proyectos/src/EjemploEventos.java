import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;
/*
 * Autor Sivlia Sassa
 * ----------------------
 * 
 *  Este programa es un ejmplo como 
 * 	utilizar los eventos de ratón
 *   
 */


public class EjemploEventos extends GraphicsProgram {

	GRect rectangulo;

	public void init(){
		setSize(400,400);
		// digo que va a ultilizar el raton
		addMouseListeners();

		rectangulo=new GRect(70,40);
		rectangulo.setFillColor(Color.MAGENTA);
		rectangulo.setFilled(true);
		add(rectangulo);

	}

	public void mouseMoved(MouseEvent evento){
		rectangulo.setLocation(evento.getX(),300);
		
	}
}
