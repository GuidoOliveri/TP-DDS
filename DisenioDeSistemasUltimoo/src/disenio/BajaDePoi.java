package disenio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

//hoja del composite
public class BajaDePoi extends Command {
	
	private DateFormat dateFormat;
	private Date date;
	private Terminal sistema;
	
	public BajaDePoi(Terminal sistema)
	{
		this.sistema=sistema;
		date=new Date();
		dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}

	public void agregarProceso(Command unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	public void removerProcesos(){
		
		System.out.println("No se puede remover procesos\n");
	}

	public void ejecutar(){
		
		this.eliminarPOIsInactivos();
		
	}
	
	public void deshacer(){
		System.out.println("Nada para deshacer");
	}
	
	public Terminal getSistema(){
		return sistema;
	}


		public void eliminarPOIsInactivos(){
			
			for(CGP cgp:getSistema().getCgps())
			{
				if(cgp.getValidez()==false)
				{
					getSistema().getCgps().remove(cgp);
					System.out.println("Nombre del CGP dado de baja: "+cgp.getNombre());
					System.out.println("Latitud y Longitud del CGP: "+cgp.getLatitud()+";"+cgp.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));
					System.out.println("Comuna a la que pertenecia este CGP: "+cgp.getComuna());
					System.out.println("Domicilio del CGP dado de baja: "+cgp.getDomicilio());
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+cgp.getId()+";");
				}
			}
			for(Banco banco:getSistema().getBancos())
			{
				if(banco.getValidez()==false)
				{
					getSistema().getCgps().remove(banco);
					System.out.println("Nombre del banco dado de baja: "+banco.getNombre());
					System.out.println("Latitud y Longitud del banco: "+banco.getLatitud()+";"+banco.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+banco.getId()+";");
				}
			}
			for(POI poi:getSistema().getPois())
			{
				if(poi.getValidez()==false){
					getSistema().getPois().remove(poi);
					System.out.println("Nombre del POI dado de baja: "+poi.getNombre());
					System.out.println("Latitud y Longitud del POI: "+poi.getLatitud()+";"+poi.getLongitud());
					System.out.println("Hora que fue dado de baja: "+dateFormat.format(date));

				}
			}
		}
		
						
	
}
	