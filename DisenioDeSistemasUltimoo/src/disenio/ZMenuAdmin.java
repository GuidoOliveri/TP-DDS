package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ZMenuAdmin extends JFrame {

	private JPanel contentPane;
	private Terminal sistema;
	/**
	 * Launch the application.
	 */
	
	
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZMenuAdmin(Terminal sistema,Administrador yo) {
		this.sistema = sistema;
		
		Set<POI>poisAux = new HashSet<POI>();
		setTitle("Menu Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opcion que desee realizar: ");
		lblElijaUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblElijaUnaOpcin.setBounds(135, 25, 301, 23);
		contentPane.add(lblElijaUnaOpcin);
		
		JButton btnAgregarpoi = new JButton("Agregar POI");
		btnAgregarpoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZAgregarPoi poi = new ZAgregarPoi(sistema,yo);
				poi.setVisible(true);
				dispose();
			}
		});
		btnAgregarpoi.setBounds(10, 63, 122, 23);
		contentPane.add(btnAgregarpoi);
		
		JButton btnModificarpoi = new JButton("Modificar POI");
		btnModificarpoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sistema.listarPois()){
					ZModificarPOI modifico = new ZModificarPOI(sistema,yo);
					modifico.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "No hay POIs para modificar");
				}
			}
		});
		btnModificarpoi.setBounds(157, 63, 139, 23);
		contentPane.add(btnModificarpoi);
		
		JButton btnEliminarPoi = new JButton("Eliminar POI");
		btnEliminarPoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZEliminarPOI eliminar = new ZEliminarPOI(sistema,yo);
				eliminar.setVisible(true);
				dispose();
			}
		});
		btnEliminarPoi.setBounds(306, 63, 174, 23);
		contentPane.add(btnEliminarPoi);
		
		JButton btnNewButton = new JButton("Buscar POI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZBuscarPOI busco = new ZBuscarPOI(sistema,yo);
				busco.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 109, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCalcularCercania = new JButton("Calcular cercania");
		btnCalcularCercania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZCalculoCercania cerc = new ZCalculoCercania(sistema,yo);
				cerc.setVisible(true);
				dispose();
			}
		});
		btnCalcularCercania.setBounds(157, 109, 139, 23);
		contentPane.add(btnCalcularCercania);
		
		JButton btnCalcularDiponibilidad = new JButton("Calcular diponibilidad");
		btnCalcularDiponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZCalculoDisponibilidad disp = new ZCalculoDisponibilidad(sistema,yo);
				disp.setVisible(true);
				dispose();
			}
		});
		btnCalcularDiponibilidad.setBounds(306, 109, 174, 23);
		contentPane.add(btnCalcularDiponibilidad);
		
		JButton btnReporteParcialPor = new JButton("Reporte parcial por Usuario");
		btnReporteParcialPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sistema.reporteParcialPorUsuario();
			}
		});
		btnReporteParcialPor.setBounds(10, 148, 213, 23);
		contentPane.add(btnReporteParcialPor);
		
		JButton btnReportePorBsqueda = new JButton("Reporte por busqueda");
		btnReportePorBsqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZReporteBusqueda busq = new ZReporteBusqueda(sistema,yo);
				busq.setVisible(true);
				dispose();
			}
		});
		btnReportePorBsqueda.setBounds(267, 148, 213, 23);
		contentPane.add(btnReportePorBsqueda);
		
		JButton btnReportePorFecha = new JButton("Reporte por fecha");
		btnReportePorFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZReportePorFecha fecha = new ZReportePorFecha(sistema,yo);
				fecha.setVisible(true);
				dispose();
			}
		});
		btnReportePorFecha.setBounds(10, 205, 161, 23);
		contentPane.add(btnReportePorFecha);
		
		JButton btnReporteTotalPor = new JButton("Reporte total Por Usuario");
		btnReporteTotalPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZReporteTotalPorUsuario usu = new ZReporteTotalPorUsuario(sistema,yo);
				usu.setVisible(true);
				dispose();
			}
		});
		btnReporteTotalPor.setBounds(181, 205, 185, 23);
		contentPane.add(btnReporteTotalPor);
		
		JButton btnSalir = new JButton("Volver al Inicio");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuPrincipal volver = new ZMenuPrincipal(sistema);
				volver.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(376, 205, 136, 23);
		contentPane.add(btnSalir);
		
		JLabel lblProcesosPosiblesA = new JLabel("Procesos posibles a realizar:");
		lblProcesosPosiblesA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProcesosPosiblesA.setBounds(157, 252, 279, 23);
		contentPane.add(lblProcesosPosiblesA);
		
		JButton btnActualizarComercios = new JButton("Actualizar Comercios");
		btnActualizarComercios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setCommand(new ActualizarComercios(sistema));
				yo.invoke();
			}
		});
		btnActualizarComercios.setBounds(41, 291, 197, 23);
		contentPane.add(btnActualizarComercios);
		
		JButton btnAgregarAccionesA = new JButton("Agregar acciones a Usuarios");
		btnAgregarAccionesA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setCommand(new AgregarAccionesUsuarios(sistema));
				yo.invoke();
			}
		});
		btnAgregarAccionesA.setBounds(277, 291, 203, 23);
		contentPane.add(btnAgregarAccionesA);
		
		JButton btnQuitarAccionesA = new JButton("Quitar acciones a usuarios");
		btnQuitarAccionesA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setCommand(new AgregarAccionesUsuarios(sistema));
				yo.undo();
			}
		});
		btnQuitarAccionesA.setBounds(41, 325, 197, 23);
		contentPane.add(btnQuitarAccionesA);
		
		JButton btnBajaDePois = new JButton("Baja de pois inactivos");
		btnBajaDePois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yo.setCommand(new BajaDePoi(sistema));
				yo.invoke();
			}
		});
		btnBajaDePois.setBounds(277, 325, 203, 23);
		contentPane.add(btnBajaDePois);
	}

}
