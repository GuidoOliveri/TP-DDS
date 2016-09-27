package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ZReportePorFecha extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZReportePorFecha frame = new ZReportePorFecha();
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
	public ZReportePorFecha() {

		setTitle("Reporte Por Fecha\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Fecha", "Cantidad De Busquedas"
				}
		));
		
		JButton btnIniciarReportePor = new JButton("Iniciar Reporte Por Fecha");
		btnIniciarReportePor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Terminal sistema = new Terminal();
				int cantidadDeBusquedas;
				if(sistema.fechas.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No hay busquedas por fecha");
				}
				else
				{
					for(Date fecha:sistema.fechas)
					{
						int numCols = table.getModel().getColumnCount();
						Object [] fila = new Object[numCols]; 
						fila[0] =fecha.getDate()+"/"+fecha.getMonth()+1+"/"+fecha.getYear()+1900;
					
						cantidadDeBusquedas=0;
						for(Busqueda busq:sistema.busquedas)
						{
							if((busq.getFecha().getDate()==fecha.getDate())&&(busq.getFecha().getMonth()==fecha.getMonth())&&(busq.getFecha().getYear()==fecha.getYear()))
								cantidadDeBusquedas = cantidadDeBusquedas +1;
						}
						fila[1]= cantidadDeBusquedas;
						((DefaultTableModel) table.getModel()).addRow(fila);

					}
				}
			}
				
		});
		btnIniciarReportePor.setBounds(112, 24, 189, 23);
		contentPane.add(btnIniciarReportePor);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuAdmin volver = new ZMenuAdmin();
				volver.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(322, 228, 89, 23);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 57, 357, 129);
		contentPane.add(scrollPane);
		

		scrollPane.setViewportView(table);
	}
}
