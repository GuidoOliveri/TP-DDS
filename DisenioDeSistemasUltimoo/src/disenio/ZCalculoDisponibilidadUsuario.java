package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZCalculoDisponibilidadUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtDisp;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZCalculoDisponibilidadUsuario frame = new ZCalculoDisponibilidadUsuario();
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
	public ZCalculoDisponibilidadUsuario() {

		setTitle("Calculo de la disponibilidad ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Ingrese texto a buscar:");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDisp = new JTextField();
		txtDisp.setColumns(10);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Calle", "Altura"
			}
		));
		
		JButton btnCalculandoDisponibilidad = new JButton("Calculando disponibilidad... ");
		btnCalculandoDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set<POI>poisAux = new HashSet<POI>();
				Terminal sistema = new Terminal();
				Administrador yo = new Administrador(sistema);
				
				String texto = "";
				texto = txtDisp.getText();
				
				if (texto.contentEquals("")){
					JOptionPane.showMessageDialog(null, "No ingresaste nada!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					poisAux=yo.buscarPoi(texto);
					if(poisAux.size()==0)
						JOptionPane.showMessageDialog(null, "Sin resultados", "Info", JOptionPane.OK_OPTION );
					else
					{
						JOptionPane.showMessageDialog(null, "Cantidad de POIs encontrados: "+poisAux.size());
						for(POI poi:poisAux){
							int numCols = table.getModel().getColumnCount();
							
							Object [] fila = new Object[numCols]; 
							fila[0] = poi.getNombre();
							fila[1] = poi.getCalle();
							fila[2] = poi.getAltura();
							((DefaultTableModel) table.getModel()).addRow(fila);
							
							if(poi.calculoDeDisponibilidad())
								JOptionPane.showMessageDialog(null, ""+poi.getNombre()+" esta disponible ahora mismo");
							else
								
								JOptionPane.showMessageDialog(null,""+poi.getNombre()+" no esta disponible ahora mismo");
						}
						poisAux.clear();
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZMenuUsuario volver = new ZMenuUsuario();
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
							.addGap(109)
							.addComponent(btnCalculandoDisponibilidad))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addGap(13)
									.addComponent(txtDisp, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))))
					.addGap(25))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(txtDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(btnCalculandoDisponibilidad)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
