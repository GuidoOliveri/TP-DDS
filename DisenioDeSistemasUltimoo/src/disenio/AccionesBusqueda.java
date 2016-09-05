package disenio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class AccionesBusqueda extends JFrame {
	
	private JList lista;
	private JComboBox combo;
	
	//cambiar lista de strings por lista de clase correspondiente
	String[] opciones = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	
	public AccionesBusqueda(){
		setTitle("Acciones ante la busqueda");
		setBounds(700,300,500,300);
		
		LaminaTexto milamina2 =new LaminaTexto();
		add(milamina2);
	}
	
	
	class LaminaTexto extends JPanel{
		 public LaminaTexto(){
			
			 combo = new JComboBox(opciones);
			 add(combo);
			 JButton botonAgregar= new JButton("Agregar");
			 EventoAgregarBusq eventoagregarBusq=new EventoAgregarBusq();
			 botonAgregar.addActionListener(eventoagregarBusq);
			 add(botonAgregar);
			 lista = new JList();
			 add(lista);
		   	
		 
		 
		 }
	}
		 
		 
	
private class DameTexto implements ActionListener {

@Override
 public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//System.out.println(campousuario.getText().trim());
	//System.out.println("Se encuentra loggeado");
	//hacer el ingreso de sesion cuando apreto el boton "ingresar"

		}
  }

private class EventoAgregarBusq implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        
		//modificar una vez q se modifique lo de la lista de arriba
		 lista.add((Component) combo.getSelectedItem());
		
		}
	}


/*private class EventoAgregarBusq implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		//iniciarsesion
		
		MarcoInicioSesion mimarco2=new MarcoInicioSesion();
		mimarco2.setVisible(true);
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
 }*/
}



