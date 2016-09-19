package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZDatosComunes extends JFrame {

	private JPanel contentPane;
	private JTextField txtEtiqueta;
	private JTextField txtNombre;
	private JTextField txtLatitud;
	private JTextField txtLongitud;
	POI poiAux =new POI();
	Terminal sistema = new Terminal();
	private JTextField txtTipo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZDatosComunes frame = new ZDatosComunes();
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
	public ZDatosComunes() {
		setTitle("POI a Agregar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles del POI", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(26, 29, 354, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIngreseEtiqueta = new JLabel("Etiqueta: ");
		lblIngreseEtiqueta.setBounds(26, 44, 67, 14);
		panel.add(lblIngreseEtiqueta);
		
		txtEtiqueta = new JTextField();
		txtEtiqueta.setBounds(117, 41, 132, 20);
		panel.add(txtEtiqueta);
		txtEtiqueta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:\r\n\r\n");
		lblNewLabel.setBounds(26, 72, 84, 20);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(117, 72, 132, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblLatitud = new JLabel("Latitud:");
		lblLatitud.setBounds(26, 106, 46, 14);
		panel.add(lblLatitud);
		
		txtLatitud = new JTextField();
		txtLatitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		txtLatitud.setBounds(117, 103, 132, 20);
		panel.add(txtLatitud);
		txtLatitud.setColumns(10);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(26, 137, 46, 14);
		panel.add(lblLongitud);
		
		txtLongitud = new JTextField();
		txtLongitud.setBounds(117, 134, 132, 20);
		panel.add(txtLongitud);
		txtLongitud.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String etiqueta = "";
				etiqueta = txtEtiqueta.getText();
				poiAux.agregarPalabrasClaves(etiqueta);
				
				String nombre = "";
				nombre = txtNombre.getText();
				poiAux.setNombre(nombre);
				
				String latitud;
				latitud = txtLatitud.getText();
				//aca lo castie porque espera un int 
				int lat = Integer.parseInt(latitud);
				poiAux.setLatitud(lat);
				
				String longitud;
				longitud = txtLongitud.getText();
				//aca lo castie porque espera un int 
				int lon = Integer.parseInt(longitud);
				poiAux.setLongitud(lon);
				
				sistema.asignarIdPoi(poiAux);
				
				JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
				
				//ZMenuAdmin menu = new ZMenuAdmin();
				//if(txtTipo.getText()=="Banco"){
				//	ZBanco banco = new ZBanco();
					//banco.setVisible(true);
				//}
				//else if (txtTipo.getText()=="CGP"){
					ZCgp cgp = new ZCgp();
					cgp.setVisible(true);
				/*} else if (txtTipo.getText()=="Kiosco"){
					menu.setVisible(true);
				} else if (txtTipo.getText()=="Libreria"){
					menu.setVisible(true);
				} else if (txtTipo.getText()=="Otro"){
					menu.setVisible(true);
				}*/
				dispose();
				
			}
		});
		btnNewButton.setBounds(204, 165, 125, 23);
		panel.add(btnNewButton);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(26, 19, 46, 14);
		panel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(117, 16, 132, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZAgregarPoi volver = new ZAgregarPoi();
				volver.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(23, 239, 89, 23);
		contentPane.add(btnVolver);
	}
}
