package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



class MarcoInicioSesion extends JFrame{
	public MarcoInicioSesion(){
		setTitle("Iniciar Sesion");
		setBounds(700,300,500,300);
		LaminaTexto milamina2 =new LaminaTexto();
		add(milamina2);
	}
}
		
		
class LaminaTexto extends JPanel{
			 public LaminaTexto(){
				 campousuario= new JTextField(20);
				 campocontra= new JTextField(20);
				 add(campousuario);
				 add(campocontra);
				 JButton botonIngresar = new JButton("Ingresar");
				 DameTexto evento1= new DameTexto();
				 botonIngresar.addActionListener(evento1);
				 add(botonIngresar);
			 }
		
private class DameTexto implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(campousuario.getText().trim());
		System.out.println("Se encuentra loggeado");
		//hacer el ingreso de sesion cuando apreto el boton "ingresar"

	}
}
private JTextField campousuario;
private JTextField campocontra;
}