package disenio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZMenuUsuario extends JFrame {
	
	private Terminal sistema;
	
	public ZMenuUsuario(Terminal sistema,Usuario yo) {
		this.sistema=sistema;
		setBounds(100, 100, 450, 300);
		setTitle("Menu del Usuario");
		getContentPane().setLayout(null);
		
		JButton btnBuscarPuntoDe = new JButton("Buscar Punto de interes");
		btnBuscarPuntoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZBuscarPOIUsuario busco = new ZBuscarPOIUsuario(sistema,yo);
				busco.setVisible(true);
				dispose();
			}
		});
		btnBuscarPuntoDe.setBounds(30, 42, 166, 23);
		getContentPane().add(btnBuscarPuntoDe);
		
		
		JButton btnCalcularCercania = new JButton("Calcular cercania");
		btnCalcularCercania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZCalculoCercaniaUsuario mio = new ZCalculoCercaniaUsuario(sistema,yo);
				mio.setVisible(true);
				dispose();

			}
		});
		btnCalcularCercania.setBounds(258, 42, 154, 23);
		getContentPane().add(btnCalcularCercania);
		
		JButton btnCalcularDisponibilidad = new JButton("Calcular Disponibilidad");
		btnCalcularDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZCalculoDisponibilidadUsuario mio = new ZCalculoDisponibilidadUsuario(sistema,yo);
				mio.setVisible(true);
				dispose();

			}
		});
		btnCalcularDisponibilidad.setBounds(30, 133, 166, 23);
		getContentPane().add(btnCalcularDisponibilidad);
		
		JButton btnEjecutarProcesos = new JButton("Ejecutar Procesos");
		btnEjecutarProcesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nada para ejecutar!");
			}
		});
		btnEjecutarProcesos.setBounds(258, 133, 154, 23);
		getContentPane().add(btnEjecutarProcesos);
		
		JButton btnSalir = new JButton("Volver\r\n");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuPrincipal hola = new ZMenuPrincipal(sistema);
				hola.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(164, 198, 109, 23);
		getContentPane().add(btnSalir);
	}
}
