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

public class ZBanco extends JFrame {

	private JPanel contentPane;
	private JTextField txtGerente;
	private JTextField txtSucursal;
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
	public ZBanco(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		setTitle("Datos del Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseGerenteDel = new JLabel("Gerente del Banco:");
		lblIngreseGerenteDel.setBounds(40, 35, 117, 33);
		contentPane.add(lblIngreseGerenteDel);
		
		txtGerente = new JTextField();
		txtGerente.setBounds(182, 41, 117, 20);
		contentPane.add(txtGerente);
		txtGerente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sucursal de Banco:\r\n");
		lblNewLabel.setBounds(40, 85, 93, 25);
		contentPane.add(lblNewLabel);
		
		txtSucursal = new JTextField();
		txtSucursal.setBounds(182, 87, 117, 20);
		contentPane.add(txtSucursal);
		txtSucursal.setColumns(10);
	
		
		JButton btnNewButton = new JButton("Agregar Banco\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banco poiAux = new Banco();
				
				String gerente = "";
				gerente = txtGerente.getText();
				poiAux.setGerente(gerente);
				
				String sucursal = "";
				sucursal = txtSucursal.getText();
				poiAux.setSucursal(sucursal);
				
				yo.agregarBanco((Banco)poiAux);
				
				JOptionPane.showMessageDialog(null, "Datos agregados!");
				
				ZMenuAdmin volver = new ZMenuAdmin(sistema,yo);
				volver.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(263, 204, 117, 33);
		contentPane.add(btnNewButton);
	}

}
