package disenio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

//hoja del composite
public class BajaDePoi implements Componente {
	
	private int id;
	Terminal sistema=new Terminal();

	public void agregarProceso(Componente unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	public void remover(Componente unProceso){
		
		System.out.println("No se puede remover un proceso\n");
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
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+id+";");
				}
			}
			for(Banco banco:getSistema().getBancos())
			{
				if(banco.getId()==id)
				{
					getSistema().getCgps().remove(banco);
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+id+";");
				}
			}
			for(POI poi:getSistema().getPois())
			{
				if(poi.getId()==id){
					getSistema().getPois().remove(poi);
					return true;
				}
			}
			return false;
		}
		
						
	
}
	