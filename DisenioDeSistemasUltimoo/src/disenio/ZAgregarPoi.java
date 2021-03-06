package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZAgregarPoi extends JFrame {

	private JPanel contentPane;
	private Terminal sistema;
	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZAgregarPoi(Terminal sistema,Administrador yo) {
		this.sistema= sistema;
		setTitle("Tipo de POI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAQuCategoria = new JLabel("A que categoria pertenece el POI ? ");
		lblAQuCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAQuCategoria.setBounds(72, 11, 282, 25);
		contentPane.add(lblAQuCategoria);
		
		JButton btnBanco = new JButton("Banco");
		btnBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes banco = new ZDatosComunes(sistema,yo);
				banco.setVisible(true);
				dispose();
			}
		});
		btnBanco.setBounds(30, 83, 89, 23);
		contentPane.add(btnBanco);
		
		JButton btnNewButton = new JButton("CGP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes cgp = new ZDatosComunes(sistema,yo);
				cgp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(142, 83, 145, 23);
		contentPane.add(btnNewButton);
		
		JButton btnKiosco = new JButton("Kiosco");
		btnKiosco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes kiosco = new ZDatosComunes(sistema,yo);
				kiosco.setVisible(true);
				dispose();
			}
		});
		btnKiosco.setBounds(297, 83, 89, 23);
		contentPane.add(btnKiosco);
		
		JButton btnLibreria = new JButton("Libreria");
		btnLibreria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes lib = new ZDatosComunes(sistema,yo);
				lib.setVisible(true);
				dispose();
			}
		});
		btnLibreria.setBounds(30, 150, 89, 23);
		contentPane.add(btnLibreria);
		
		JButton btnParadaColectivo = new JButton("Parada Colectivo");
		btnParadaColectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes bondi = new ZDatosComunes(sistema,yo);
				bondi.setVisible(true);
				dispose();
			}
		});
		btnParadaColectivo.setBounds(142, 150, 145, 23);
		contentPane.add(btnParadaColectivo);
		
		JButton btnOtro = new JButton("Otro");
		btnOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZDatosComunes otro = new ZDatosComunes(sistema,yo);
				otro.setVisible(true);
				dispose();
			}
		});
		btnOtro.setBounds(297, 150, 89, 23);
		contentPane.add(btnOtro);
		
		JButton btnNewButton_1 = new JButton("Volver\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuAdmin volver = new ZMenuAdmin(sistema,yo);
				volver.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(157, 207, 107, 23);
		contentPane.add(btnNewButton_1);
	}

}
