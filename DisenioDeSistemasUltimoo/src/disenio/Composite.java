package disenio;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Composite extends Command {

	private Terminal sistema;
	private Set<Command> procesos;
	
	public Composite(Terminal sistema)
	{
		this.sistema=sistema;
		procesos=new HashSet<Command>();
	}
	
	public void agregarProceso (Command unProceso){
		procesos.add(unProceso);
	}
	
	 public void removerProcesos()  {
		 procesos.clear();   
	} 
	
	 public void ejecutar()
	 {
		for(Command unProceso:procesos)
		{
			unProceso.ejecutar();
		}
	 }
}