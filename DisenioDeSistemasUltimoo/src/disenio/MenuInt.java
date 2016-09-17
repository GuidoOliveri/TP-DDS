package disenio;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

public class MenuInt extends JFrame {
	public MenuInt() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.GREEN);
		setTitle("Busqueda de POIs");
	
		
		getContentPane().setLayout(null);
		this.setResizable(false);
		
		JButton btnHacerUnaBusqueda = new JButton("Hacer una Busqueda");
		btnHacerUnaBusqueda.setBounds(131, 109, 182, 41);
		getContentPane().add(btnHacerUnaBusqueda);
        IrABusqueda irabusqueda= new IrABusqueda();
		
        btnHacerUnaBusqueda.addActionListener(irabusqueda);
		
		
		JButton btnAccionesDeBusqueda = new JButton("Acciones de Busqueda");
		btnAccionesDeBusqueda.setBounds(131, 57, 182, 41);
		getContentPane().add(btnAccionesDeBusqueda);
		IrAcciones irAcciones= new IrAcciones();
		
		btnAccionesDeBusqueda.addActionListener(irAcciones);
		
		JButton btnHistorialDeBusqueda = new JButton("Historial de Busqueda");
		btnHistorialDeBusqueda.setBounds(131, 168, 182, 41);
		getContentPane().add(btnHistorialDeBusqueda);
		IrHistorial irAhisto= new IrHistorial();
		
		btnHistorialDeBusqueda.addActionListener(irAhisto);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de POIs, seleccione una opción:");
		lblBienvenidoAlSistema.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblBienvenidoAlSistema.setForeground(Color.WHITE);
		lblBienvenidoAlSistema.setBounds(24, 11, 396, 35);
		getContentPane().add(lblBienvenidoAlSistema);
		
		JButton btnNewButton = new JButton("Salir\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(331, 226, 89, 35);
		getContentPane().add(btnNewButton);
		
	}
	
	
	private class IrABusqueda implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	  
			BusquedaInt marco1=new BusquedaInt();
			marco1.setTitle("Busqueda");
			marco1.setBounds(700,300,500,300);
			marco1.setVisible(true);
			marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	private class IrAcciones implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			AccionesAnteLaBusqInt marco2=new AccionesAnteLaBusqInt();
			marco2.setBounds(700,300,500,300);
			marco2.setTitle("Acciones ante la busqueda");
			marco2.setVisible(true);
			marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
		 
		}
	}
	
	private class IrHistorial implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	    
		 
			HistorialBusqRealInt marco3=new HistorialBusqRealInt();
			marco3.setBounds(700,300,500,300);
			marco3.setTitle("Historial de busqueda real");
			marco3.setVisible(true);
			marco3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
		}
	}
		private class EventoVolverAtras implements ActionListener{
			public void actionPerformed(ActionEvent e) {
		//no hace falta volver ATRAS, sino con cerrar el frame contra incorrecta bastaria
				
			}
			}

		private class EventoSalida implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			 
					 System.exit( -1); 
					 
			}
			}
}
