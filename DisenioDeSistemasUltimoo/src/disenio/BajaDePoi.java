package disenio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

//hoja del composite
public class BajaDePoi implements Componente {
	
	public int id;
	Terminal sistema=new Terminal();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	
	public void agregarProceso(Componente unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	public void remover(Componente unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public void ejecutar(){
		
		this.buscarPoi(id);
		
	}
	
	public Terminal getSistema(){
		return sistema;
	}


	public void buscarPoi(int id){  
		
		if(!getSistema().getPois().isEmpty())
			for (POI poi:getSistema().getPois()){
				if(poi.getId()==id)
				{
					this.eliminarPOI(id);
				}
			}
	}

		


		public Boolean eliminarPOI(int id){
			
			for(CGP cgp:getSistema().getCgps())
			{
				if(cgp.getId()==id)
				{
					getSistema().getCgps().remove(cgp);
					System.out.println("Nombre del CGP dado de baja: "+cgp.getNombre());
					System.out.println("Latitud y Longitud del CGP: "+cgp.getLatitud()+";"+cgp.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));
					System.out.println("Comuna a la que pertenecia este CGP: "+cgp.getComuna());
					System.out.println("Domicilio del CGP dado de baja: "+cgp.getDomicilio());
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+id+";");
				}
			}
			for(Banco banco:getSistema().getBancos())
			{
				if(banco.getId()==id)
				{
					getSistema().getCgps().remove(banco);
					System.out.println("Nombre del banco dado de baja: "+banco.getNombre());
					System.out.println("Latitud y Longitud del banco: "+banco.getLatitud()+";"+banco.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+id+";");
				}
			}
			for(POI poi:getSistema().getPois())
			{
				if(poi.getId()==id){
					getSistema().getPois().remove(poi);
					System.out.println("Nombre del POI dado de baja: "+poi.getNombre());
					System.out.println("Latitud y Longitud del POI: "+poi.getLatitud()+";"+poi.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));
					return true;
				}
			}
			return false;
		}
		
						
	
}
	