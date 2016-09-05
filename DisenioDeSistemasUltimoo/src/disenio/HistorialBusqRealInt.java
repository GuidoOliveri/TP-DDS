package disenio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;

public class HistorialBusqRealInt extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private DefaultTableModel modelo; 
	
	
	public HistorialBusqRealInt() {
		getContentPane().setLayout(null);
		
		JLabel lblCriterioDeBusqueda = new JLabel("Criterio de Busqueda");
		lblCriterioDeBusqueda.setBounds(21, 11, 113, 14);
		getContentPane().add(lblCriterioDeBusqueda);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(31, 36, 46, 14);
		getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setBounds(146, 36, 46, 14);
		getContentPane().add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 61, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(235, 61, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 60, 89, 23);
		getContentPane().add(btnBuscar);
		Buscar bus = new Buscar();
		btnBuscar.addActionListener(bus);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 106, 67, 20);
		getContentPane().add(lblResultado);
		
		table = new JTable();
		table.setBounds(10, 230, 286, -87);
		getContentPane().add(table);
		
		JList list = new JList();
		list.setBounds(335, 108, 89, 131);
		getContentPane().add(list);
		
		modelo = new DefaultTableModel();
	}
	
	private class Buscar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		String nombre =textField.getText();
		//Date fechaDesde = (Date)textField_1.getText(); 
		//Date fechaHasta = (Date)textField_2.getText();
		
		//hacer la busqueda con esos 3 parametros y lo inserta en la tabla
		
	   //  FALTA HACER -> modelo.addRow(arg0); para agregar a la tabla
		 
		//lo agrego a la tabla
		table= new JTable(modelo);
		
		}
	}
	

}
