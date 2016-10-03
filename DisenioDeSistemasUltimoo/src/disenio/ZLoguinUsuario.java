package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;


public class ZLoguinUsuario extends JFrame {

	private JPanel contentPane;
	
	public static JTextField txt_usuario;
	
	// OJO CON ESTE MAIN AGREGADO
/*	public static void main(Terminal sistema) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZLoguinUsuario frame = new ZLoguinUsuario(sistema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	public ZLoguinUsuario(Terminal sistema) {
		
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
			
	}
	
	final ZDatosUsuario data = new ZDatosUsuario();
	public static JPasswordField pss_contraseña;
	private class EventoLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(data.probarPass()==1){
				JOptionPane.showMessageDialog(null, "Bienvenido al sistema de POIs Usuario!");
				ZMenuUsuario usu = new ZMenuUsuario();
				usu.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "ERROR, usuario o contraseña incorrectos");
			}
		}
	}
	
	
	private class Cancelar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Terminal sistema = new Terminal();
			ZMenuPrincipal mio = new ZMenuPrincipal(sistema);
			mio.setVisible(true);
			dispose();
			
		}
	
    }
}

