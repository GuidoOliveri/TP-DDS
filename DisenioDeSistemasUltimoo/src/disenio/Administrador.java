package disenio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Administrador extends Usuario{

	public Administrador(Terminal sistema,String usuario, String contrasenia, POI unPoi) {
		super(sistema,usuario,contrasenia,unPoi);
		
	}

	public Administrador(Terminal sistema){
		super(sistema);
	}
	
	public Administrador(){
		super();
	}
	
	//GET / SET

	//OTROS METODOS

	public void agregarPOI(POI unPOI){
		
		super.getSistema().getPois().add(unPOI);
		getSistema().persistirPOI(unPOI);
	}
	
	public void agregarCgp(CGP unCgp)
	{
		super.getSistema().getCgps().add(unCgp);
	}	
	public void agregarBanco(Banco unBanco)
	{
		super.getSistema().getBancos().add(unBanco);
	}
	
	public Boolean modificarPOI(int id,String nombre,int comuna, String zonas, String director,String etiqueta){//y demas datos

		for(CGP cgp:getSistema().getCgps())
		{
			if(cgp.getId()==id)
			{
				cgp.setNombre(nombre);
				cgp.setComuna(comuna);
				cgp.setDirector(director);
				cgp.setZonas(zonas);
			}
		}
		for(Banco banco:getSistema().getBancos())
		{
			if(banco.getId()==id)
			{
				banco.setNombre(nombre);
				banco.setComuna(comuna);
			}
		}
		for(POI poi:getSistema().getPois())
		{
			if(poi.getId()==id)
			{
				poi.setNombre(nombre);
				PalabraClave palabra = new PalabraClave(etiqueta);
				poi.agregarPalabraClave(palabra);
				palabra.agregarPoi(poi);
				getSistema().persistirPOI(poi);
				return true;
			}
		}
		return false;
	}

	public Boolean eliminarPOI(int id){
		
		for(CGP cgp:getSistema().getCgps())
		{
			if(cgp.getId()==id)
			{
				cgp.setValidez(false);
			}
		}
		for(Banco banco:getSistema().getBancos())
		{
			if(banco.getId()==id)
			{
				banco.setValidez(false);
			}
		}
		
        
		for(POI poi:getSistema().getPois())
		{
			if(poi.getId()==id){
				poi.setValidez(false);
				getSistema().persistirPOI(poi);
				return true;
			}
		}
		return false;
	}


}
