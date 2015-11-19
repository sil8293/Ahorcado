
import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class HolaMundo extends acm.program.GraphicsProgram{
	
	public void run(){
		
//		GLabel etiqueta = new GLabel("HOLA MUNDO!!");
//		etiqueta.setLocation(80,120);
//		add(etiqueta);
		
		GRect rectangulo = new GRect(40,90);
		rectangulo.setColor(Color.MAGENTA);
		rectangulo.setFillColor(Color.lightGray);
		rectangulo.setFilled(true);
		rectangulo.setLocation(20, 50);
		
		add(rectangulo);
		
	}

}
