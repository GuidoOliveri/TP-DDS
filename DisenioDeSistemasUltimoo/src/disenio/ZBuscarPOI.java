package disenio;

import java.awt.BorderLayout;
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

public class ZBuscarPOI extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZBuscarPOI frame = new ZBuscarPOI();
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
	public ZBuscarPOI() {
		Set<POI>poisAux = new HashSet<POI>();
		poisAux.clear();
		
		setTitle("Buscar POIs\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ingrese texto a buscar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Nombre", "Latitud", "Longitud"
				}
			));
		
		JButton btnNewButton = new JButton("Buscando... ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terminal sistema = new Terminal();
				Administrador yo = new Administrador(sistema);
				
				String texto = "";
				texto = txtBuscar.getText();
				
				if (texto.contentEquals("")){
					JOptionPane.showMessageDialog(null, "No ingresaste nada!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					poisAux.addAll(yo.buscarPoi(texto));
					if(poisAux.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Sin resultados\n");
					}
					else
					{
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
				ZMenuAdmin volver = new ZMenuAdmin();
				volver.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(41, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}
