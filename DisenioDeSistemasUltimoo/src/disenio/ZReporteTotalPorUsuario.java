package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ZReporteTotalPorUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
	public ZReporteTotalPorUsuario(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		setTitle("Reporte total por usuario\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Cant resultados totales"
			}
		));
		
		JButton btnIniciarReporteTotal = new JButton("Iniciar Reporte Total Por Usuario");
		btnIniciarReporteTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numCols = table.getModel().getColumnCount();
				Object [] fila = new Object[numCols]; 
				int cantidad;
				if(sistema.busquedas.isEmpty()){
					JOptionPane.showMessageDialog(null, "No hay reportes totales por usuario disponibles");
				}
				else
				{
					for(Administrador admin:sistema.admins){
		
						fila[0] = admin.getUsuario();
						cantidad=0;
						if(!admin.getBusquedas().isEmpty())
						{
							for(Busqueda busq:admin.getBusquedas())
							{
								cantidad += busq.getResultados().size();
							}
						}
						fila[1] = cantidad;
					}
					for(Usuario usu:sistema.usuarios){
						fila[0] = usu.getUsuario();
						cantidad=0;
						if(!usu.getBusquedas().isEmpty())
						{
							for(Busqueda busq:usu.getBusquedas())
							{
								cantidad += busq.getResultados().size();
							}
						}
						fila[1] = cantidad;
					}
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}

		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuAdmin volver1 = new ZMenuAdmin(sistema,yo);
				volver1.setVisible(true);
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addComponent(btnIniciarReporteTotal, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(302, Short.MAX_VALUE)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(btnIniciarReporteTotal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		
	
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
