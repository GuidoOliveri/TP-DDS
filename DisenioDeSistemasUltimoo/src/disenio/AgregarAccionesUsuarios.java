package disenio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

//hoja del composite
public class AgregarAccionesUsuarios extends Command {
	
	private Terminal sistema;
	
	private Composite componente;
	
	public AgregarAccionesUsuarios(Terminal sistema)
	{
		this.sistema = sistema;
		componente=new Composite(sistema);
		componente.agregarProceso(new BajaDePoi(sistema));
		componente.agregarProceso(new ActualizarComercios(sistema));
	}
	
	public void agregarProceso(Command unProceso){
		
		JOptionPane.showMessageDialog(null, "No se puede agregar un proceso");
	}
	 
	public void remover(Command unProceso){
		
		JOptionPane.showMessageDialog(null,"No se puede remover un proceso");
	}
	
	public void ejecutar(){
		sistema.setCommandUsuarios(componente);
		sistema.cambiarPrivilegiosUsuarios(true);
		JOptionPane.showMessageDialog(null,"Los usuarios tienen privilegios");
	}	
	
	public void deshacer(){
		sistema.setCommandUsuarios(new Base(sistema));
		sistema.cambiarPrivilegiosUsuarios(false);
		JOptionPane.showMessageDialog(null,"Los usuarios ya no tienen privilegios");

	}

}