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
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ZEliminarPOI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
	public ZEliminarPOI(Terminal sistema,Administrador yo) {
		this.sistema=sistema;
		setTitle("POI a Eliminar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Eliminarlo del sistema\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean exito;
				exito=false;
				
					if(sistema.listarPois())
					{
						do
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
							
						}while(!exito);
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
		lblNewLabel.setBounds(105, 52, 156, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(93, 94, 134, 20);
		panel.add(textField);
		textField.setColumns(10);
		
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
	}
}
