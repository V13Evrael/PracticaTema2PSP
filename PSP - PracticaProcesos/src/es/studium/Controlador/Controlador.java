package es.studium.Controlador;

import es.studium.Vista.FramePrincipal;

public class Controlador {

	FramePrincipal frame;
	
	public Controlador() {
		frame = new FramePrincipal();
		frame.setVisible(true);
	}
}
