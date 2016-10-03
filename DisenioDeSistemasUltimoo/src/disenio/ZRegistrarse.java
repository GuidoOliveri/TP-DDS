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
	public static JTextField pss_contraseña;
	public static JTextField txt_usuario;
	public ZRegistrarse(Terminal sistema) {
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
		
		JLabel lblIngreseUnaContrasea = new JLabel("Ingrese una contraseña");
		lblIngreseUnaContrasea.setBounds(134, 127, 177, 14);
		getContentPane().add(lblIngreseUnaContrasea);
		
		pss_contraseña = new JPasswordField();
		pss_contraseña.setBounds(134, 167, 143, 20);
		getContentPane().add(pss_contraseña);
		pss_contraseña.setColumns(10);
		
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
			Terminal sistema = new Terminal();
			ZMenuPrincipal mio = new ZMenuPrincipal(sistema);
			mio.setVisible(true);
			dispose();
			
		}
	
    }
	
	final ZDatosUsuario data = new ZDatosUsuario();
	public Terminal sistema;
	
	private class EventoLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(data.registrarUsu()==1)
			{
				JOptionPane.showMessageDialog(null, "Se ha registrado con exito!");
				ZMenuUsuario admin = new ZMenuUsuario();
				admin.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "usuario existente , ingrese otro usuario");
			}
		}
	}
}
