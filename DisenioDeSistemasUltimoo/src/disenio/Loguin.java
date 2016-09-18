package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPasswordField;

public class Loguin extends JFrame {
	public static JTextField txt_usuario;
	public Loguin() {

		JFrame frame = new JFrame();
		frame.setBounds(100,100,485,407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Evento de logueo");
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(101, 37, 62, 14);
		getContentPane().add(lblUsuario);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(206, 36, 86, 20);
		getContentPane().add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
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
		
		pss_contraseña = new JPasswordField();
		pss_contraseña.setBounds(206, 84, 86, 20);
		getContentPane().add(pss_contraseña);
		Cancelar canc = new Cancelar();
		btnCancelar.addActionListener(canc);
		
		
		Loguearse melogueo= new Loguearse();
		
		btnLoguearse.addActionListener(melogueo);
		
	
	}
	
	final DatosUsuario data = new DatosUsuario();
	public static JPasswordField pss_contraseña;
	private class EventoLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(data.probarPass()==1){
				JOptionPane.showMessageDialog(null, "Bienvenido al sistema de POIs Admin!");
			}else{
				JOptionPane.showMessageDialog(null, "ERROR, usuario o contraseña incorrectos");
			}
		}
	}
	
	private class Loguearse implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//iniciarsesion
			//verificar que el logueo coincida con lo nuestro y hacer un if para q se haga
			//lo que sigue abajo
			
			
	
			
			}
	}
	
	private class Cancelar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	
    }
}
