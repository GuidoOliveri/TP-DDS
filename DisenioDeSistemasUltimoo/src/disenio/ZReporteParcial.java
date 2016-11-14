package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ZReporteParcial extends JFrame {

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
	public ZReporteParcial(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		setTitle("Reporte Parcial Por Usuario");
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
					"Usuario", "Cant resultados parciales"
			}
		));
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuAdmin admin = new ZMenuAdmin(sistema, yo);
				admin.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Iniciar Reporte Parcial");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				int numCols = table.getModel().getColumnCount();
				Object [] fila = new Object[numCols]; 
				int cantidad;
				if(sistema.getBusquedas().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No hay reportes parciales por usuario disponibles");
				}
				else
				{
					for(Administrador admin:sistema.getAdmins())
					{
						fila[0] = admin.getUsuario();
						cantidad=0;
						if(!admin.getBusquedas().isEmpty())
						{
							for(Busqueda busq:admin.getBusquedas())
							{
								cantidad = cantidad + busq.getResultados().size();
							}
							fila[1] = cantidad;
							((DefaultTableModel) table.getModel()).addRow(fila);
						}
						
					}
					
					for(Usuario usu:sistema.getUsuarios())
					{
						fila[0] = usu.getUsuario();
						cantidad=0;
						if(!usu.getBusquedas().isEmpty())
						{
							for(Busqueda busq:usu.getBusquedas())
							{
								cantidad = cantidad + busq.getResultados().size();
							}
						}
						fila[1] = cantidad;
						((DefaultTableModel) table.getModel()).addRow(fila);
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
					.addGap(54))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)))
		);
		
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
