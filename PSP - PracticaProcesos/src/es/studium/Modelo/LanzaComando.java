package es.studium.Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LanzaComando {

	ArrayList<String> lista = new ArrayList<String>();
	
	public void leeProcesos (String comando) {
	
		String cadenaGuardar;
		Process p;
		try {
			
			p = Runtime.getRuntime().exec(comando);	
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((cadenaGuardar=br.readLine()) != null) {
				
				lista.add(cadenaGuardar);
			}
		} 
		catch (IOException e) {
			
			System.out.println("No se pudo guardar la salida del comando");
			e.printStackTrace();
		}	
	}
	
	public String sacaDatos(int posicionDato, int indiceEnLista) {
		
		String resultado = "";
		
		resultado = lista.get(indiceEnLista);
		resultado = resultado.split(",")[posicionDato];
		resultado = resultado.substring(1,resultado.length()-2);
		
		return resultado;
	}
}
