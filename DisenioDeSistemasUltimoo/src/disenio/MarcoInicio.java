package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MarcoInicio extends JFrame {
	
	public MarcoInicio(){
		setTitle("Busqueda");
		setBounds(700,300,500,300);
		LaminaPrincipal milamina =new LaminaPrincipal();
		add(milamina);

	}
	
	class LaminaPrincipal extends JPanel{
		
		public LaminaPrincipal(){

			JButton botonagregapoi= new JButton("Agregar Punto de interes"); //objeto fuente
			JButton botonbuscapoi= new JButton("Buscar un Punto de interés");
		    EventoAgregaPoi eventoagregapoi=new EventoAgregaPoi();
			EventoBuscaPoi eventobuscapoi= new EventoBuscaPoi();
					
			botonagregapoi.addActionListener(eventoagregapoi);
			botonbuscapoi.addActionListener(eventobuscapoi);
			add(botonagregapoi);
			add(botonbuscapoi);
		         }

		private class EventoBuscaPoi implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ya puede buscar un poi");
				}
		}
		private class EventoAgregaPoi implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				//iniciarsesion
				
				MarcoInicioSesion mimarco2=new MarcoInicioSesion();
				mimarco2.setVisible(true);
				mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				}
		}
}
}
