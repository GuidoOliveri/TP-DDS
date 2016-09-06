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
		System.out.println("Acciones de usuario agregadas");
	}	
	
	public void deshacer(){
		for(Usuario usuario:sistema.getUsuarios())
		{
			//usuario.setCommand(new Base(sistema));
		}
	}

	 
	
}