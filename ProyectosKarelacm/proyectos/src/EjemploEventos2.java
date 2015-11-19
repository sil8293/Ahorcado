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


public class EjemploEventos2 extends GraphicsProgram {

	GOval circulo;

	public void init(){
		setSize(400,400);
		// digo que va a ultilizar el raton
		addMouseListeners();

		

	}
// es llamado cada vez que se mueva
	public void mouseMoved(MouseEvent evento){
//		circulo.setLocation(evento.getX(),300);
		
	}
	//es llamado cada vez que se click
	public void mouseClicked(MouseEvent evento){
		circulo=new GOval(70,40);
		circulo.setFillColor(Color.MAGENTA);
		circulo.setFilled(true);
		add(circulo, evento.getX(),evento.getY());
		
	}
}
