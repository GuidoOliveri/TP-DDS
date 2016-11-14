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
	private JTextField txtTipo;
	String tipoPOI = "";
	private Terminal sistema;
	private JTextField textCalle;
	private JTextField textAltura;
	
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
	public ZDatosComunes(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
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
		lblLongitud.setBounds(26, 137, 67, 14);
		panel.add(lblLongitud);
		
		txtLongitud = new JTextField();
		txtLongitud.setBounds(117, 134, 132, 20);
		panel.add(txtLongitud);
		txtLongitud.setColumns(10);
		
		POI poiAux =new POI();
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(26, 19, 46, 14);
		panel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(117, 16, 132, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(26, 162, 46, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(26, 185, 46, 14);
		panel.add(lblAltura);
		
		textCalle = new JTextField();
		textCalle.setBounds(117, 159, 132, 20);
		panel.add(textCalle);
		textCalle.setColumns(10);
		
		textAltura = new JTextField();
		textAltura.setBounds(117, 182, 132, 20);
		panel.add(textAltura);
		textAltura.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZAgregarPoi volver = new ZAgregarPoi(sistema,yo);
				volver.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(23, 239, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Agregar datos");
		btnNewButton.setBounds(299, 239, 125, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String etiqueta = "";
				etiqueta = txtEtiqueta.getText();
				PalabraClave palabra = new PalabraClave(etiqueta);
				poiAux.agregarPalabraClave(palabra);
				palabra.agregarPoi(poiAux);
				
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
				
				String calle = "";
				calle = textCalle.getText();
				poiAux.setCalle(calle);
				
				
				String altura = "";
				altura = textAltura.getText();
				int alt = Integer.parseInt(altura);
				poiAux.setAltura(alt);
				
				yo.agregarPOI(poiAux);
				
				JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
				
				
				tipoPOI= txtTipo.getText();
				
				if(tipoPOI.equalsIgnoreCase("banco")){
					ZBanco banco = new ZBanco(sistema,yo);
					banco.setVisible(true);
					dispose();
				}
				else if (tipoPOI.equalsIgnoreCase("cgp")){
					ZCgp cgp = new ZCgp(sistema,yo);
					cgp.setVisible(true);
					dispose();
				} else if (tipoPOI.equalsIgnoreCase("kiosco")){
					ZMenuAdmin menu = new ZMenuAdmin(sistema,yo);
					menu.setVisible(true);
					dispose();
				} else if (tipoPOI.equalsIgnoreCase("Libreria")){
					ZMenuAdmin menu1 = new ZMenuAdmin(sistema,yo);
					menu1.setVisible(true);
					dispose();
				} else if (tipoPOI.equalsIgnoreCase("Otro")){
					ZMenuAdmin menu2 = new ZMenuAdmin(sistema,yo);
					menu2.setVisible(true);
					dispose();
				}
				
			}
		});
	}
}
