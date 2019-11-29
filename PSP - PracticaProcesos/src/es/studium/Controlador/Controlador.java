package es.studium.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import es.studium.Modelo.LanzaComando;
import es.studium.Vista.FramePrincipal;

public class Controlador implements ActionListener {

	FramePrincipal frame;
	LanzaComando lc = new LanzaComando();

	public Controlador() {

		frame = new FramePrincipal();
		frame.setVisible(true);

		lc.rellenaTabla(frame.getTable());

		frame.getBtnPaint().addActionListener(this);
		frame.getBtnBloc().addActionListener(this);
		frame.getBtnJuego().addActionListener(this);
		frame.getBtnGestion().addActionListener(this);
		frame.getBtnReload().addActionListener(this);
		frame.getBtnParaProceso().addActionListener(this);
	}

	public FramePrincipal getFrame() {
		return frame;
	}

	public void setFrame(FramePrincipal frame) {
		this.frame = frame;
	}

	public LanzaComando getLc() {
		return lc;
	}

	public void setLc(LanzaComando lc) {
		this.lc = lc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(frame.getBtnPaint())) {

			try {

				lc.ejecutaComando("cmd /C mspaint");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(frame.getBtnBloc())) {

			try {

				lc.ejecutaComando("cmd /C notepad");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(frame.getBtnJuego())) {
			
			String path = Controlador.class.getResource("/jars/Dobble.jar").getPath();
			path = path.substring(1);
			path = path.replace("%20", " ");
			path = '"' + path + '"';
			System.out.println(path);
			try {
				lc.ejecutaComando("cmd /C java -jar " + path);
				Thread.sleep(100);
				lc.rellenaTabla(frame.getTable());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(frame.getBtnGestion())) {

			String path = Controlador.class.getResource("/jars/tiendaJuegos.jar").getPath();
			path = path.substring(1);
			path = path.replace("%20", " ");
			path = '"' + path + '"';
			System.out.println(path);
			try {
				lc.ejecutaComando("cmd /C java -jar " + path);
				Thread.sleep(100);
				lc.rellenaTabla(frame.getTable());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		if (e.getSource().equals(frame.getBtnReload())) {

			lc.rellenaTabla(frame.getTable());
		}

		if (e.getSource().equals(frame.getBtnParaProceso())) {

			if (frame.getTable().getSelectedRow() != -1) {
				String pid = (String) frame.getTable().getModel().getValueAt(frame.getTable().getSelectedRow(), 1);
				try {
					lc.ejecutaComando("cmd /C taskkill /F /PID " + pid);
					Thread.sleep(100);
					lc.rellenaTabla(frame.getTable());
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}
		}
	}
}
