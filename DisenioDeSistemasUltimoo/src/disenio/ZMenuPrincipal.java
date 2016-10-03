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
	public static void main(Terminal sistema) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZMenuPrincipal frame = new ZMenuPrincipal(sistema);
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
	public ZMenuPrincipal(Terminal sistema) {
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
				ZLoguinAdmin logueo = new ZLoguinAdmin(sistema);
				logueo.setVisible(true);
				dispose();
			}
		});
		btnMenuAdministrador.setBounds(50, 98, 159, 23);
		contentPane.add(btnMenuAdministrador);
		
		JButton btnMenuUsuario = new JButton("Menu Usuario");
		btnMenuUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZLoguinUsuario logue = new ZLoguinUsuario(sistema);
				logue.setVisible(true);
				dispose();
			}
		});
		btnMenuUsuario.setBounds(254, 98, 112, 23);
		contentPane.add(btnMenuUsuario);
		
		JButton btnRegistrarse = new JButton("Registrate ");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZRegistrarse regist = new ZRegistrarse(sistema);
				regist.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setBounds(50, 167, 159, 23);
		contentPane.add(btnRegistrarse);
		
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
