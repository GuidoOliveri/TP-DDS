package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class HistorialBusqueda extends JFrame{

	public HistorialBusqueda(){
		setTitle("Iniciar Sesion");
		setBounds(700,300,500,300);
		LaminaTexto milamina2 =new LaminaTexto();
		add(milamina2);
	}
	
	
	class LaminaTexto extends JPanel{
		 public LaminaTexto(){
			JTextField fechainic= new JTextField(10);
			JTextField fechafin= new JTextField(10);
			JTextField usu= new JTextField(15);
			JLabel usuario = new JLabel();
			JLabel fecha = new JLabel();
			 add(usuario);
			 add(usu);
			 add(fecha);
			 add(fechainic);
			 add(fechafin);
			 JButton botonIngresar = new JButton("Ingresar");
			 
			 botonIngresar.addActionListener(null);
			 add(botonIngresar);
		 }
	
	}
	
}	
