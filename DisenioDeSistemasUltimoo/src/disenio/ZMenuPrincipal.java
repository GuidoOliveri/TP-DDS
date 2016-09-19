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

public class ZMenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZMenuPrincipal frame = new ZMenuPrincipal();
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
	public ZMenuPrincipal() {
		setTitle("Sistema de POIs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema de POIs, eliga una opcion:");
		lblBienvenidoAlSistema.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBienvenidoAlSistema.setBounds(63, 22, 361, 23);
		contentPane.add(lblBienvenidoAlSistema);
		
		JButton btnMenuAdministrador = new JButton("Menu Administrador");
		btnMenuAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZLoguinAdmin logueo = new ZLoguinAdmin();
				logueo.setVisible(true);
				dispose();
			}
		});
		btnMenuAdministrador.setBounds(50, 98, 132, 23);
		contentPane.add(btnMenuAdministrador);
		
		JButton btnMenuUsuario = new JButton("Menu Usuario");
		btnMenuUsuario.setBounds(254, 98, 112, 23);
		contentPane.add(btnMenuUsuario);
		
		JButton btnNewButton = new JButton("Registrate ");
		btnNewButton.setBounds(50, 167, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(254, 167, 108, 23);
		contentPane.add(btnSalir);
	}
}
