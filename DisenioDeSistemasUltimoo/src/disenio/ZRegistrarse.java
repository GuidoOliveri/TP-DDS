package disenio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;

public class ZRegistrarse extends JFrame {
	
	private Terminal sistema;
	public static JTextField pss_contrasenia;
	public static JTextField txt_usuario;
	
	public ZRegistrarse(Terminal sistema) {
		this.sistema=sistema;
		setBounds(100, 100, 450, 300);
		setTitle("Registro de un nuevo Usuario");
		getContentPane().setLayout(null);
		
		JLabel lblIngreseUnNombre = new JLabel("Ingrese un nombre de usuario");
		lblIngreseUnNombre.setBounds(134, 27, 197, 25);
		getContentPane().add(lblIngreseUnNombre);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(134, 63, 143, 20);
		getContentPane().add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lblIngreseUnaContrasea = new JLabel("Ingrese una contrasenia");
		lblIngreseUnaContrasea.setBounds(134, 127, 177, 14);
		getContentPane().add(lblIngreseUnaContrasea);
		
		pss_contrasenia = new JPasswordField();
		pss_contrasenia.setBounds(134, 167, 143, 20);
		getContentPane().add(pss_contrasenia);
		pss_contrasenia.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(307, 211, 89, 23);
		//Aceptar canc = new Aceptar();
		//btnAceptar.addActionListener(canc);
		EventoLog eventolog =new EventoLog();
		btnAceptar.addActionListener(eventolog);
		getContentPane().add(btnAceptar);
	}
	
	private class Aceptar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ZMenuPrincipal mio = new ZMenuPrincipal(sistema);
			mio.setVisible(true);
			dispose();
			
		}
	
    }
	
	
	private class EventoLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			final ZDatosUsuario data = new ZDatosUsuario(sistema,txt_usuario.getText(),pss_contrasenia.getText());
			if(data.registrarUsu()==1)
			{
				JOptionPane.showMessageDialog(null, "Se ha registrado con exito!");
				ZMenuPrincipal admin = new ZMenuPrincipal(sistema);
				admin.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "usuario existente , ingrese otro usuario");
			}
		}
	}
}
