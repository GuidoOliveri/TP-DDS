package disenio;

import javax.swing.JFrame;
import javax.swing.JList;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuInt extends JFrame {
	public MenuInt() {
		getContentPane().setLayout(null);
		
		JButton btnHacerUnaBusqueda = new JButton("Hacer una Busqueda");
		btnHacerUnaBusqueda.setBounds(39, 47, 159, 23);
		getContentPane().add(btnHacerUnaBusqueda);
        IrABusqueda irabusqueda= new IrABusqueda();
		
        btnHacerUnaBusqueda.addActionListener(irabusqueda);
		
		
		JButton btnAccionesDeBusqueda = new JButton("Acciones de Busqueda");
		btnAccionesDeBusqueda.setBounds(245, 47, 159, 23);
		getContentPane().add(btnAccionesDeBusqueda);
		IrAcciones irAcciones= new IrAcciones();
		
		btnAccionesDeBusqueda.addActionListener(irAcciones);
		
		JButton btnHistorialDeBusqueda = new JButton("Historial de Busqueda");
		btnHistorialDeBusqueda.setBounds(133, 131, 182, 23);
		getContentPane().add(btnHistorialDeBusqueda);
		IrHistorial irAhisto= new IrHistorial();
		
		btnHistorialDeBusqueda.addActionListener(irAhisto);
		
		
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

}
