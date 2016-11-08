package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPasswordField;

public class ZLoguinAdmin extends JFrame {
	
	private JPanel contentPane;
	private Terminal sistema;
	public static JTextField txt_usuario;
	
	// OJO CON ESTE MAIN AGREGADO
	public void main() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZLoguinAdmin frame = new ZLoguinAdmin(sistema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public ZLoguinAdmin(Terminal sistema) {
		this.sistema=sistema;
		setTitle("Evento de logueo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(101, 37, 62, 14);
		getContentPane().add(lblUsuario);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(206, 36, 86, 20);
		getContentPane().add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrasenia:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(75, 85, 103, 14);
		getContentPane().add(lblContrasea);
		
		JButton btnLoguearse = new JButton("Loguearse");
		btnLoguearse.setBounds(93, 177, 118, 42);
		getContentPane().add(btnLoguearse);
		EventoLog eventolog =new EventoLog();
		btnLoguearse.addActionListener(eventolog);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(257, 177, 103, 42);
		getContentPane().add(btnCancelar);
		
		pss_contrasenia = new JPasswordField();
		pss_contrasenia.setBounds(206, 84, 86, 20);
		getContentPane().add(pss_contrasenia);
		Cancelar canc = new Cancelar();
		btnCancelar.addActionListener(canc);
			
	}
	

	public static JPasswordField pss_contrasenia;
	private class EventoLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Boolean logueado=false;
				Administrador yo = sistema.logueoAdmin(txt_usuario.getText(), pss_contrasenia.getText());
				if(yo!=null)
				{
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema de POIs Admin!");
					ZMenuAdmin admin = new ZMenuAdmin(sistema,yo);
					admin.setVisible(true);
					dispose();
					logueado=true;
				}
				else
				{
					Usuario yo2 = sistema.logueoUsu(txt_usuario.getText(), pss_contrasenia.getText());
					if(yo2!=null)
					{
						JOptionPane.showMessageDialog(null, "Bienvenido al sistema de POIs!");
						ZMenuUsuario admin = new ZMenuUsuario(sistema,yo2);
						admin.setVisible(true);
						dispose();
						logueado=true;
					}
				}
				if(!logueado)
					JOptionPane.showMessageDialog(null, "ERROR, usuario o contrasenia incorrectos");
			
		}
	}
	
	
	private class Cancelar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ZMenuPrincipal mio = new ZMenuPrincipal(sistema);
			mio.setVisible(true);
			dispose();
			
		}
	
    }
}
