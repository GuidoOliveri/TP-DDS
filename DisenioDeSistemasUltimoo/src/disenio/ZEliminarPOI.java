package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ZEliminarPOI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
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
	public ZEliminarPOI(Terminal sistema,Administrador yo) {
		setTitle("POI a Eliminar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nombre"
			}
		));
		
		JButton btnNewButton = new JButton("Eliminarlo del sistema\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean exito;
				exito=false;
				
				
					if(sistema.listarPois())
					{
	
							// obtengo el ID del POI con getText
							String id = "";
							id = textField.getText();
							int idABuscar = Integer.parseInt(id);
							
							if(exito=yo.eliminarPOI(idABuscar))
							{
								JOptionPane.showMessageDialog(null, "Eliminado exitosamente\n\n");
							}
							
							else
								JOptionPane.showMessageDialog(null, "Hubo un problema, intente nuevamente\n\n");

					}
					else
						JOptionPane.showMessageDialog(null, "No hay pois");
					
					ZMenuAdmin admin = new ZMenuAdmin(sistema,yo);
					admin.setVisible(true);
					dispose();
				}
		});
		
		btnNewButton.setBounds(268, 193, 133, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("\r\n");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion de POI a Eliminar ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(39, 11, 333, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id de POI a Eliminar: \r\n");
		lblNewLabel.setBounds(93, 23, 156, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(93, 41, 134, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 68, 265, 81);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Volver\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuAdmin volver = new ZMenuAdmin(sistema,yo);
				volver.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(20, 193, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnBuscarPois = new JButton("Buscar Pois");
		btnBuscarPois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				
					for(POI poi:sistema.getPois())
					{
						int numCols = table.getModel().getColumnCount();
						Object [] fila = new Object[numCols]; 
						fila[0] =poi.getId();
						fila[1]= poi.getNombre();
						
						((DefaultTableModel) table.getModel()).addRow(fila);

					}
				}
			});
		btnBuscarPois.setBounds(152, 227, 100, 23);
		contentPane.add(btnBuscarPois);
	}
}
