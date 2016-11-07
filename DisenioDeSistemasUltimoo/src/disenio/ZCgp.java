package disenio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZCgp extends JFrame {

	private JPanel contentPane;
	private JTextField txtComuna;
	private JTextField txtZonas;
	private JTextField txtDirector;
	private JTextField txtDomicilio;
	private JTextField txtTel;
	private JTextField txtServicios;
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
	public ZCgp(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		setTitle("Datos del CGP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComuna = new JLabel("Comuna:");
		lblComuna.setBounds(40, 25, 80, 14);
		contentPane.add(lblComuna);
		
		txtComuna = new JTextField();
		txtComuna.setBounds(156, 22, 86, 20);
		contentPane.add(txtComuna);
		txtComuna.setColumns(10);
		
		JLabel lblZonasQueCubre = new JLabel("Zonas que cubre:");
		lblZonasQueCubre.setBounds(40, 61, 101, 14);
		contentPane.add(lblZonasQueCubre);
		
		txtZonas = new JTextField();
		txtZonas.setBounds(156, 58, 86, 20);
		contentPane.add(txtZonas);
		txtZonas.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(40, 97, 80, 14);
		contentPane.add(lblDirector);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(156, 97, 86, 20);
		contentPane.add(txtDirector);
		txtDirector.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(40, 132, 80, 14);
		contentPane.add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(156, 128, 86, 20);
		contentPane.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(40, 157, 80, 14);
		contentPane.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setBounds(156, 159, 86, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblServicios = new JLabel("Servicios:");
		lblServicios.setBounds(39, 194, 81, 14);
		contentPane.add(lblServicios);
		
		txtServicios = new JTextField();
		txtServicios.setBounds(156, 190, 86, 20);
		contentPane.add(txtServicios);
		txtServicios.setColumns(10);
		
		JButton btnAgregarCgp = new JButton("Agregar CGP");
		btnAgregarCgp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POI poiAux = new CGP();
				
				String comuna = "";
				comuna = txtComuna.getText();
				int com = Integer.parseInt(comuna);
				poiAux.setComuna(com);
				
				String zonas = "";
				zonas = txtZonas.getText();
				poiAux.setZonas(zonas);
				
				String director = "";
				director = txtDirector.getText();
				poiAux.setDirector(director);
				
				String domicilio = "";
				domicilio = txtDomicilio.getText();
				poiAux.setDomicilio(domicilio);
				
				String tel = "";
				tel = txtTel.getText();
				int t = Integer.parseInt(tel);
				poiAux.setTelefono(t);
				
				String servicios = "";
				servicios = txtServicios.getText();
				poiAux.setServicios(servicios);
				
				yo.agregarCgp((CGP)poiAux);
				yo.agregarPOI(poiAux);
				JOptionPane.showMessageDialog(null, "Datos agregados!");
				
				ZMenuAdmin volver = new ZMenuAdmin(sistema,yo);
				volver.setVisible(true);
				dispose();
				
				
			}
		});
		btnAgregarCgp.setBounds(267, 215, 121, 23);
		contentPane.add(btnAgregarCgp);
	}

}
