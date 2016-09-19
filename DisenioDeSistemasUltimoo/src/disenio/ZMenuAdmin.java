package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZMenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZMenuAdmin frame = new ZMenuAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZMenuAdmin() {
		setTitle("Menu Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción que desee realizar: ");
		lblElijaUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblElijaUnaOpcin.setBounds(135, 25, 301, 23);
		contentPane.add(lblElijaUnaOpcin);
		
		JButton btnAgregarpoi = new JButton("Agregar POI");
		btnAgregarpoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZAgregarPoi poi = new ZAgregarPoi();
				poi.setVisible(true);
				dispose();
			}
		});
		btnAgregarpoi.setBounds(33, 63, 99, 23);
		contentPane.add(btnAgregarpoi);
		
		JButton btnModificarpoi = new JButton("Modificar POI");
		btnModificarpoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarpoi.setBounds(157, 63, 119, 23);
		contentPane.add(btnModificarpoi);
		
		JButton btnEliminarPoi = new JButton("Eliminar POI");
		btnEliminarPoi.setBounds(295, 63, 158, 23);
		contentPane.add(btnEliminarPoi);
		
		JButton btnNewButton = new JButton("Buscar POI");
		btnNewButton.setBounds(33, 109, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCalcularCercania = new JButton("Calcular cercania");
		btnCalcularCercania.setBounds(157, 109, 119, 23);
		contentPane.add(btnCalcularCercania);
		
		JButton btnCalcularDiponibilidad = new JButton("Calcular diponibilidad");
		btnCalcularDiponibilidad.setBounds(306, 109, 144, 23);
		contentPane.add(btnCalcularDiponibilidad);
		
		JButton btnReporteParcialPor = new JButton("Reporte parcial por Usuario");
		btnReporteParcialPor.setBounds(32, 160, 191, 23);
		contentPane.add(btnReporteParcialPor);
		
		JButton btnReportePorBsqueda = new JButton("Reporte por búsqueda");
		btnReportePorBsqueda.setBounds(260, 160, 169, 23);
		contentPane.add(btnReportePorBsqueda);
		
		JButton btnReportePorFecha = new JButton("Reporte por fecha");
		btnReportePorFecha.setBounds(33, 205, 128, 23);
		contentPane.add(btnReportePorFecha);
		
		JButton btnReporteTotalPor = new JButton("Reporte total Por Usuario");
		btnReporteTotalPor.setBounds(181, 205, 169, 23);
		contentPane.add(btnReporteTotalPor);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuPrincipal volver = new ZMenuPrincipal();
				volver.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(391, 205, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblProcesosPosiblesA = new JLabel("Procesos posibles a realizar:");
		lblProcesosPosiblesA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProcesosPosiblesA.setBounds(157, 252, 279, 23);
		contentPane.add(lblProcesosPosiblesA);
		
		JButton btnActualizarComercios = new JButton("Actualizar Comercios");
		btnActualizarComercios.setBounds(64, 291, 159, 23);
		contentPane.add(btnActualizarComercios);
		
		JButton btnAgregarAccionesA = new JButton("Agregar acciones a Usuarios");
		btnAgregarAccionesA.setBounds(277, 291, 176, 23);
		contentPane.add(btnAgregarAccionesA);
		
		JButton btnQuitarAccionesA = new JButton("Quitar acciones a usuarios");
		btnQuitarAccionesA.setBounds(64, 325, 159, 23);
		contentPane.add(btnQuitarAccionesA);
		
		JButton btnBajaDePois = new JButton("Baja de pois inactivos");
		btnBajaDePois.setBounds(277, 325, 176, 23);
		contentPane.add(btnBajaDePois);
	}

}
