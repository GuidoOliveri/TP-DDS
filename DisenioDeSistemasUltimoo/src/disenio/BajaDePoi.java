package disenio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

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
		
		JOptionPane.showMessageDialog(null,"No se puede agregar un proceso\n");
	}
	
	
	public void removerProcesos(){
		
		JOptionPane.showMessageDialog(null,"No se puede remover procesos\n");
	}

	public void ejecutar(){
		
		this.eliminarPOIsInactivos();
		
	}
	
	public void deshacer(){
		JOptionPane.showMessageDialog(null,"Nada para deshacer");
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
					JOptionPane.showMessageDialog(null, "Nombre del CGP dado de baja: "+cgp.getNombre()+"\n"+ 
									"Latitud y Longitud del CGP: "+cgp.getLatitud()+";"+cgp.getLongitud()+"\n"+ 
									"Hora que fue dado de baja: "+dateFormat.format(date)+"\n"+ 
									"Comuna a la que pertenecia este CGP: "+cgp.getComuna()+"\n"+ 
									"Domicilio del CGP dado de baja: "+cgp.getDomicilio()+"\n",
									"cgp dado de baja", JOptionPane.DEFAULT_OPTION);
					
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+cgp.getId()+";");
				}
			}
			for(Banco banco:getSistema().getBancos())
			{
				if(banco.getValidez()==false)
				{
					getSistema().getCgps().remove(banco);
					
					JOptionPane.showMessageDialog(null, "Nombre del banco dado de baja: "+banco.getNombre()+"\n"+ 
							"Latitud y Longitud del banco: "+banco.getLatitud()+";"+banco.getLongitud()+"\n"+ 
							"Hora que fue dado de baja: "+dateFormat.format(date)+"\n",
							"banco dado de baja", JOptionPane.DEFAULT_OPTION);
					
					getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+banco.getId()+";");
				}
			}
			for(POI poi:getSistema().getPois())
			{
				if(poi.getValidez()==false){
					getSistema().getPois().remove(poi);
					
					JOptionPane.showMessageDialog(null, "Nombre del POI dado de baja: "+poi.getNombre()+"\n"+ 
							"Latitud y Longitud del POI: "+poi.getLatitud()+";"+poi.getLongitud()+"\n"+ 
							"Hora que fue dado de baja: "+dateFormat.format(date)+"\n",
							"POI dado de baja", JOptionPane.DEFAULT_OPTION);

				}
			}
			
		}
					
}
	