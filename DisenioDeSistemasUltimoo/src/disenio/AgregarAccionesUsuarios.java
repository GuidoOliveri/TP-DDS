package disenio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//hoja del composite
public class AgregarAccionesUsuarios extends Command {
	
	Command command ;
	Terminal sistema=new Terminal();
	
	public ArrayList<AccionDeUsuario> accionesDelUsuarioACambiar;
	
	 
	public void agregarProceso(Command unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	 
	public void remover(Command unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	
	public void ejecutar(){
		
	for (Administrador usuario:sistema.getAdmins()){ 
		
		usuario.setCommand(command);
			
	}
}	

	
	public void deshacer(){
		
	}

	 
	
}