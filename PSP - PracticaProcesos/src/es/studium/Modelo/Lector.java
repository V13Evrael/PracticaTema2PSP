package es.studium.Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lector {

	FileReader fr; 
	BufferedReader br;
	ArrayList<String> lista = new ArrayList<String>();
	
	public Lector (String archivoTxt) throws IOException {
	
		fr = new FileReader("tempPID.txt");
		br = new BufferedReader(fr);
	}
 
	public void guardaEnLista() {
		
		String cadenaGuardar;
		
		try {
			
			while((cadenaGuardar=br.readLine()) != null) {
				
				lista.add(cadenaGuardar);
			}				
		}
		catch (IOException ioe) {
			
			System.out.println("No se pudieron guardar los datos");
		}
	}
}
