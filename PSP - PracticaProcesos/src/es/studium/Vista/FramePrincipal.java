package es.studium.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;

	private Toolkit herramientas = Toolkit.getDefaultToolkit();
	private Dimension pantallaSize = herramientas.getScreenSize();
	private JTable table;

	private JButton btnEjecutarComando;

	private JTextArea textArea;

	private JButton btnPaint;

	private JButton btnBloc;

	private JButton btnGestion;

	private JButton btnJuego;

	private JButton btnReload;

	private JButton btnParaProceso;

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (pantallaSize.width * 7) / 10, (pantallaSize.height * 6) / 10);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel pnlIzq = new JPanel();
		contentPane.add(pnlIzq);
		pnlIzq.setLayout(new BorderLayout(0, 0));

		JPanel pnlIzqNorte = new JPanel();
		pnlIzq.add(pnlIzqNorte, BorderLayout.NORTH);
		pnlIzqNorte.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();

		textField.setCaretColor(new Color(204, 204, 204));
		
		Border line = BorderFactory.createLineBorder(new Color(204, 204, 204));
		Border emptyTF = new EmptyBorder(0, 3, 0, 0);
		CompoundBorder borderTF = new CompoundBorder(line, emptyTF);
		textField.setBorder(borderTF);
		
		pnlIzqNorte.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setBackground(new Color(12, 12, 12));
		textField.setForeground(new Color(204, 204, 204));
		textField.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField.setMargin(new Insets(10, 10, 10, 10));

		btnEjecutarComando = new JButton("Ejecutar Comando");
		pnlIzqNorte.add(btnEjecutarComando, BorderLayout.EAST);
		Border emptyTA = new EmptyBorder(3, 3, 0, 0);
		CompoundBorder borderTA = new CompoundBorder(line, emptyTA);

		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		pnlIzq.add(scrollPane_1, BorderLayout.CENTER);

		textArea.setCaretColor(new Color(204, 204, 204));
		textArea.setSelectionColor(SystemColor.windowBorder);
		textArea.setSelectedTextColor(new Color(204, 204, 204));
		textArea.setBorder(borderTA);
		textArea.setBackground(new Color(12, 12, 12));
		textArea.setForeground(new Color(204, 204, 204));
		textArea.setFont(new Font("Consolas", Font.PLAIN, 16));

		JPanel pnlDer = new JPanel();
		contentPane.add(pnlDer);
		pnlDer.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel pnlDerF1C1 = new JPanel();
		pnlDer.add(pnlDerF1C1);
		pnlDerF1C1.setLayout(new GridLayout(2, 2, 0, 0));

		btnPaint = new JButton();

		ImageIcon paintIcon = new ImageIcon(FramePrincipal.class.getResource("/img/paintIcon.png"));
		Image imgPaint = paintIcon.getImage();
		Image newimgPaint = imgPaint.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		paintIcon = new ImageIcon(newimgPaint);
		btnPaint.setIcon(paintIcon);
		pnlDerF1C1.add(btnPaint);

		btnBloc = new JButton();
		ImageIcon blocIcon = new ImageIcon(FramePrincipal.class.getResource("/img/notePadIcon.png"));
		Image imgBloc = blocIcon.getImage();
		Image newimgBloc = imgBloc.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		blocIcon = new ImageIcon(newimgBloc);
		btnBloc.setIcon(blocIcon);
		pnlDerF1C1.add(btnBloc);

		btnGestion = new JButton();
		ImageIcon gestionIcon = new ImageIcon(FramePrincipal.class.getResource("/img/gestionIcon.png"));
		Image imgGestion = gestionIcon.getImage();
		Image newimgGestion = imgGestion.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
		gestionIcon = new ImageIcon(newimgGestion);
		btnGestion.setIcon(gestionIcon);
		pnlDerF1C1.add(btnGestion);

		btnJuego = new JButton();
		ImageIcon juegoIcon = new ImageIcon(FramePrincipal.class.getResource("/img/juegoIcon.png"));
		Image imgJuego = juegoIcon.getImage();
		Image newimgJuego = imgJuego.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		juegoIcon = new ImageIcon(newimgJuego);
		btnJuego.setIcon(juegoIcon);
		pnlDerF1C1.add(btnJuego);

		JPanel pnlDerF2C1 = new JPanel();
		pnlDer.add(pnlDerF2C1);

		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del proceso", "PID del proceso"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		pnlDerF2C1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlDerF2C1.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de procesos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(Color.BLACK, 1, true));
		pnlDerF2C1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel pnlBotonesProcesos = new JPanel();
		pnlDerF2C1.add(pnlBotonesProcesos, BorderLayout.SOUTH);
		
		btnReload = new JButton("Refrescar");
		btnReload.setPreferredSize(new Dimension(100, 23));
		btnReload.setMinimumSize(new Dimension(100, 23));
		btnReload.setMaximumSize(new Dimension(100, 23));
		pnlBotonesProcesos.add(btnReload);
		
		btnParaProceso = new JButton("Stop");
		btnParaProceso.setPreferredSize(new Dimension(100, 23));
		btnParaProceso.setMinimumSize(new Dimension(100, 23));
		btnParaProceso.setMaximumSize(new Dimension(100, 23));
		pnlBotonesProcesos.add(btnParaProceso);
	}

	public JButton getBtnReload() {
		return btnReload;
	}

	public JButton getBtnParaProceso() {
		return btnParaProceso;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtnEjecutarComando() {
		return btnEjecutarComando;
	}

	public JButton getBtnPaint() {
		return btnPaint;
	}

	public JButton getBtnBloc() {
		return btnBloc;
	}

	public JButton getBtnGestion() {
		return btnGestion;
	}

	public JButton getBtnJuego() {
		return btnJuego;
	}

}