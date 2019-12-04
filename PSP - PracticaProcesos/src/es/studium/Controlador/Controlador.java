package es.studium.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import es.studium.Modelo.LanzaComando;
import es.studium.Vista.FramePrincipal;

public class Controlador implements ActionListener {

	FramePrincipal frame;
	LanzaComando lc = new LanzaComando();
	int pidGestion = -1;
	int pidJuego = -1;
	int pidPaint = -1;
	int pidBloc = -1;
	

	public Controlador() {

		frame = new FramePrincipal();
		frame.setVisible(true);

		lc.rellenaTabla(frame.getTable());
		frame.getTextArea().setText("Microsoft Windows [Versión 10.0.18362.476]\r\n"
				+ "(c) 2019 Microsoft Corporation. Todos los derechos reservados.\n");

		lc.leeProcesos("cmd /C");
		lc.rellenaTxtArea(frame.getTextArea());

		frame.getBtnPaint().addActionListener(this);
		frame.getBtnBloc().addActionListener(this);
		frame.getBtnJuego().addActionListener(this);
		frame.getBtnGestion().addActionListener(this);
		frame.getBtnReload().addActionListener(this);
		frame.getBtnParaProceso().addActionListener(this);
		frame.getBtnEjecutarComando().addActionListener(this);
		frame.getTextField().addActionListener(this);
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
				Thread.sleep(100);
				lc.rellenaTabla(frame.getTable());
				pidPaint = Integer.parseInt((String)(frame.getTable().getModel().getValueAt(frame.getTable().getRowCount()-1, frame.getTable().getColumnCount()-1)));
				frame.getBtnPaint().setEnabled(false);
			} catch (IOException e1) {

				e1.printStackTrace();
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(frame.getBtnBloc())) {

			try {

				lc.ejecutaComando("cmd /C notepad");
				Thread.sleep(100);
				lc.rellenaTabla(frame.getTable());
				pidBloc = Integer.parseInt((String)(frame.getTable().getModel().getValueAt(frame.getTable().getRowCount()-1, frame.getTable().getColumnCount()-1)));
				frame.getBtnBloc().setEnabled(false);
			} catch (IOException e1) {

				e1.printStackTrace();
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(frame.getBtnJuego())) {

			String path = Controlador.class.getResource("/jars/Dobble.jar").getPath();
			path = path.substring(1);
			path = path.replace("%20", " ");
			path = '"' + path + '"';
			try {
				lc.ejecutaComando("cmd /C java -jar " + path);
				Thread.sleep(100);
				lc.rellenaTabla(frame.getTable());
				pidJuego = Integer.parseInt((String)(frame.getTable().getModel().getValueAt(frame.getTable().getRowCount()-1, frame.getTable().getColumnCount()-1)));
				frame.getBtnJuego().setEnabled(false);
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
				pidGestion = Integer.parseInt((String)(frame.getTable().getModel().getValueAt(frame.getTable().getRowCount()-1, frame.getTable().getColumnCount()-1)));
				frame.getBtnGestion().setEnabled(false);
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
					
					if (Integer.parseInt(pid) == pidBloc) {
						frame.getBtnBloc().setEnabled(true);
					}
					else if (Integer.parseInt(pid) == pidPaint) {
						frame.getBtnPaint().setEnabled(true);
					}
					else if (Integer.parseInt(pid) == pidJuego) {
						frame.getBtnJuego().setEnabled(true);
					}
					else if (Integer.parseInt(pid) == pidGestion) {
						frame.getBtnGestion().setEnabled(true);
					}
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}
		}

		if (e.getSource().equals(frame.getBtnEjecutarComando()) | e.getSource().equals(frame.getTextField())) {

			String comando = frame.getTextField().getText();
			frame.getTextField().setText(null);
			
			if (comando.equals("clear")) {

				frame.getTextArea().setText("");
				frame.getTextArea().setText("Microsoft Windows [Versión 10.0.18362.476]\r\n"
						+ "(c) 2019 Microsoft Corporation. Todos los derechos reservados.\n");

				lc.leeProcesos("cmd /C");
				lc.rellenaTxtArea(frame.getTextArea());
				
			} else {
				
				frame.getTextArea().append(" " + comando + "\n");

				lc.leeProcesos("cmd + /C " + comando);
				lc.rellenaTxtArea(frame.getTextArea());
			}
		}
	}
}