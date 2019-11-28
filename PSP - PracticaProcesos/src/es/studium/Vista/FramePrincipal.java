package es.studium.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (pantallaSize.width*7)/10, (pantallaSize.height*6)/10);
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
	//
		Border line = BorderFactory.createLineBorder(new Color(204, 204, 204));
		Border emptyTF = new EmptyBorder(0, 3, 0, 0);
		CompoundBorder borderTF = new CompoundBorder(line, emptyTF);
		textField.setBorder(borderTF);
	//
		pnlIzqNorte.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setBackground(new Color(12, 12, 12));
		textField.setForeground(new Color(204, 204, 204));
		textField.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField.setMargin(new Insets(10,10,10,10));
		
		JButton btnEjecutarComando = new JButton("Ejecutar Comando");
		pnlIzqNorte.add(btnEjecutarComando, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		textArea.setCaretColor(new Color(204, 204, 204));
		textArea.setSelectionColor(SystemColor.windowBorder);
		textArea.setSelectedTextColor(new Color(204, 204, 204));
		Border emptyTA = new EmptyBorder(3, 3, 0, 0);
		CompoundBorder borderTA = new CompoundBorder(line, emptyTA);
		textArea.setBorder(borderTA);
		textArea.setBackground(new Color(12, 12, 12));
		textArea.setForeground(new Color(204, 204, 204));
		textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
		pnlIzq.add(textArea, BorderLayout.CENTER);
		
		JPanel pnlDer = new JPanel();
		contentPane.add(pnlDer);
		pnlDer.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnlDerF1C1 = new JPanel();
		pnlDer.add(pnlDerF1C1);
		pnlDerF1C1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnPaint = new JButton("New button");
		pnlDerF1C1.add(btnPaint);
		
		JButton btnBloc = new JButton("New button");
		pnlDerF1C1.add(btnBloc);
		
		JButton btnGestion = new JButton("New button");
		pnlDerF1C1.add(btnGestion);
		
		JButton btnJuego = new JButton("New button");
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Estado del proceso", "Nombre del proceso", "PID del proceso"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
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
		//pnlDerF2C1.add(table, BorderLayout.CENTER);
	}

}