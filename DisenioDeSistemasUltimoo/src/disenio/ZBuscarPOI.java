package disenio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class ZBuscarPOI extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
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
	public ZBuscarPOI(Terminal sistema,Administrador yo) {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {
			}
		});
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		this.sistema=sistema;
		Set<POI>poisAux = new HashSet<POI>();
		
		setTitle("Buscar POIs\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 468, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("Ingrese palabra clave a buscar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "";
				texto = txtBuscar.getText();
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Id", "Nombre", "Latitud", "Longitud"
						}
					));
				
				if (texto.contentEquals("")){
					JOptionPane.showMessageDialog(null, "No ingresaste nada!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					poisAux.clear();
					poisAux.addAll(yo.buscarPoi(texto));
					Calendar fecha = new GregorianCalendar();
					if(poisAux.isEmpty())
					{
						table.removeAll();
						JOptionPane.showMessageDialog(null, "Sin resultados\n");
					}
					else
					{
						table.removeAll();
						JOptionPane.showMessageDialog(null, "Cantidad de POIs encontrados: "+poisAux.size()+"\n");
						for(POI poi:poisAux){
							poi.listar();
							// esto una vez que esté enganchado con la terminal debería funcionar
							int numCols = table.getModel().getColumnCount();
	
							Object [] fila = new Object[numCols]; 
							fila[0] = poi.getId();
							fila[1] = poi.getNombre();
							fila[2] = poi.getLatitud();
							fila[3] = poi.getLongitud();
							((DefaultTableModel) table.getModel()).addRow(fila);
							
						}
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZMenuAdmin volver = new ZMenuAdmin(sistema,yo);
				volver.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(238, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(153)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_1)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}
