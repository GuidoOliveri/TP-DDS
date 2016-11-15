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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ZCalculoCercania extends JFrame {

	private JPanel contentPane;
	private JTextField txtCerc;
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
	public ZCalculoCercania(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		Set<POI>poisAux = new HashSet<POI>();
		
		setTitle("Calculo de Cercania \r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Ingrese texto a buscar:");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtCerc = new JTextField();
		txtCerc.setColumns(10);
		
		// esto es lo que agrega filas y columnas 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Calle", "Altura", "Distancia al POI"
			}
		));
		
		JButton btnCalculando = new JButton("Calculando cercania... ");
		btnCalculando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = "";
				texto = txtCerc.getText();
				
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
							int numCols = table.getModel().getColumnCount();
							
							Object [] fila = new Object[numCols]; 
							fila[0] = poi.getId();
							fila[1] = poi.getCalle();
							fila[2] = poi.getAltura();
							fila[3] = yo.getSistema().getPoiActual().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud());
							((DefaultTableModel) table.getModel()).addRow(fila);
							
							if(yo.getSistema().getPoiActual().calculoDeCercania(poi))
								
								JOptionPane.showMessageDialog(null, "Usted esta cerca de "+poi.getNombre(), "Informacion", JOptionPane.DEFAULT_OPTION);
							else
								
								JOptionPane.showMessageDialog(null, "Usted esta lejos de "+poi.getNombre(), "Informacion", JOptionPane.DEFAULT_OPTION);
						}
						poisAux.clear();
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
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
					.addGap(76)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCerc, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(btnCalculando, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCerc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(btnCalculando)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
