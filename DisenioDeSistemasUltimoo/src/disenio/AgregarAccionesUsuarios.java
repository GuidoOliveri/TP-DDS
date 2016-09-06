package disenio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		System.out.println("No se puede agregar un proceso\n");
	}
	 
	public void remover(Command unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	public void ejecutar(){
		sistema.setCommandUsuarios(componente);
		sistema.cambiarPrivilegiosUsuarios(true);
		System.out.println("Los usuarios tienen privilegios\n");
	}	
	
	public void deshacer(){
		sistema.setCommandUsuarios(new Base(sistema));
		sistema.cambiarPrivilegiosUsuarios(false);
		System.out.println("Los usuarios ya no tienen privilegios");

	}

}