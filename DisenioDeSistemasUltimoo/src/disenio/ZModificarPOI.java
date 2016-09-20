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

public class ZModificarPOI extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtComuna;
	private JTextField txtZonas;
	private JTextField txtDirector;
	private JTextField txtGerente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZModificarPOI frame = new ZModificarPOI();
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
	public ZModificarPOI() {
		setTitle("Moficar POI existente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseNuevoId = new JLabel("Ingrese nuevo ID:");
		lblIngreseNuevoId.setBounds(29, 34, 118, 23);
		contentPane.add(lblIngreseNuevoId);
		
		txtId = new JTextField();
		txtId.setBounds(173, 35, 118, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblIngreseNuevoNombre = new JLabel("Ingrese nuevo nombre:");
		lblIngreseNuevoNombre.setBounds(29, 79, 130, 14);
		contentPane.add(lblIngreseNuevoNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(173, 76, 118, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblIngreseNuevaComuna = new JLabel("Ingrese nueva comuna:");
		lblIngreseNuevaComuna.setBounds(29, 115, 130, 23);
		contentPane.add(lblIngreseNuevaComuna);
		
		txtComuna = new JTextField();
		txtComuna.setBounds(173, 116, 118, 20);
		contentPane.add(txtComuna);
		txtComuna.setColumns(10);
		
		JLabel lblNuevasZonas = new JLabel("Nuevas zonas:");
		lblNuevasZonas.setBounds(29, 168, 22, -1);
		contentPane.add(lblNuevasZonas);
		
		JLabel lblNuevasZonas_1 = new JLabel("Nuevas zonas:");
		lblNuevasZonas_1.setBounds(29, 153, 118, 14);
		contentPane.add(lblNuevasZonas_1);
		
		txtZonas = new JTextField();
		txtZonas.setBounds(173, 147, 118, 20);
		contentPane.add(txtZonas);
		txtZonas.setColumns(10);
		
		JLabel lblNuevoDirector = new JLabel("Nuevo director:");
		lblNuevoDirector.setBounds(29, 178, 118, 27);
		contentPane.add(lblNuevoDirector);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(173, 181, 118, 20);
		contentPane.add(txtDirector);
		txtDirector.setColumns(10);
		
		JLabel lblNuevoGerente = new JLabel("Nuevo gerente:");
		lblNuevoGerente.setBounds(29, 216, 118, 23);
		contentPane.add(lblNuevoGerente);
		
		txtGerente = new JTextField();
		txtGerente.setBounds(173, 217, 118, 20);
		contentPane.add(txtGerente);
		txtGerente.setColumns(10);
		
		JButton btnModificarlo = new JButton("Modificarlo");
		btnModificarlo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// despues cambiar esto al main para que lo reciba por argumento
				Terminal sistema = new Terminal ();
				Administrador yo = new Administrador(sistema);
				
				boolean exito;
				exito=false;
				do
				{
					
					String id = "";
					id = txtId.getText();
					int idABuscar = Integer.parseInt(id);
								
					String nombre = "";
					nombre = txtNombre.getText();
					
					String com = "";
					com = txtComuna.getText();
					int comuna = Integer.parseInt(com);
					
					String zonas = "";
					zonas = txtZonas.getText();
			
					String director = "";
					director = txtDirector.getText();
					
					String gerente = "";
					gerente = txtGerente.getText();
					
					if(exito=yo.modificarPOI(idABuscar,nombre, comuna, zonas, director,gerente))
						
						JOptionPane.showMessageDialog(null, "Modificado exitosamente\n\n");
					
					else
						JOptionPane.showMessageDialog(null,"Hubo un problema, intente nuevamente\n\n");

				}while(!exito);
				ZMenuAdmin admin = new ZMenuAdmin();
				admin.setVisible(true);
				dispose();
			}
		});
		btnModificarlo.setBounds(324, 216, 89, 23);
		contentPane.add(btnModificarlo);
	}

}
