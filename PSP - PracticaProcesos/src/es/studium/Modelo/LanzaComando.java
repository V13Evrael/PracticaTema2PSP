package es.studium.Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class LanzaComando {

	ArrayList<String> lista = new ArrayList<String>();
	String pathActual = "C:\\Users\\jmpla\\git\\PracticaTema2PSP\\PSP - PracticaProcesos";

	public void leeProcesos(String comando) {

		lista = new ArrayList<String>();
		String cadenaGuardar;
		Process p;
		try {

			p = Runtime.getRuntime().exec(comando);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			while ((cadenaGuardar = br.readLine()) != null) {

				lista.add(cadenaGuardar);
			}
			
			br.close();

		} catch (IOException e) {

			System.out.println("No se pudo guardar la salida del comando");
			e.printStackTrace();
		}
	}

	public void ejecutaComando(String comando) throws IOException {

		Process p;
		try {

			p = Runtime.getRuntime().exec(comando);
			p.onExit();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String sacaDatos(int posicionDato, int indiceEnLista) {

		String resultado = "";
		resultado = lista.get(indiceEnLista);
		resultado = resultado.split(",")[posicionDato];
		resultado = resultado.substring(1, resultado.length() - 1);

		return resultado;
	}

	public void rellenaTxtArea(JTextArea jTextArea) {

		for (String cadena : lista) {
			jTextArea.append(cadena + "\n");
		}
		jTextArea.append("\n" + this.pathActual + ">");
	}

	public void rellenaTabla(JTable tabla) {

		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		this.leeProcesos("cmd /C tasklist /FO csv /NH /FI \"Status eq running\"");

		modelo.setNumRows(0);

		for (int i = 0; i < this.lista.size(); i++) {

			Object[] fila = { this.sacaDatos(0, i), this.sacaDatos(1, i) };
			modelo.addRow(fila);
		}
	}
}