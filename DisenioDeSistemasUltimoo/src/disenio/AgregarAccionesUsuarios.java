package disenio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//hoja del composite
public class AgregarAccionesUsuarios extends Command {
	
	Terminal sistema=new Terminal();
	
	public ArrayList<AccionDeUsuario> accionesDelUsuarioACambiar;
	
	 
	public void agregarProceso(Command unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	 
	public void remover(Command unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	
	public void ejecutar(){
		
	/*for (Administrador usuario:sistema.getAdmins()){ // esta es la lista de pois
			if(usuario.getUsuario()==this.getUsuario()){
				//encontro al usuario y le agrega las nuevas acciones
					for (int i = 0; i <= accionesDelUsuarioACambiar.size()-1 ; i++) {
					  if(usuario.getAccionesUsuario().contains(accionesDelUsuarioACambiar.get(i))){
						  usuario.getAccionesUsuario().get(i)
					  }
					}
					
			}
			
					
		
		}*/
  }

	
	public void deshacer(){
		
	}

	 
	
}