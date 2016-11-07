package disenio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	//GET / SET

	//OTROS METODOS

	public void agregarPOI(POI unPOI){
		
		super.getSistema().getPois().add(unPOI);
	}
	
	public void agregarCgp(CGP unCgp)
	{
		super.getSistema().getCgps().add(unCgp);
	}	
	public void agregarBanco(Banco unBanco)
	{
		super.getSistema().getBancos().add(unBanco);
	}
	
	public Boolean modificarPOI(int id,String nombre,int comuna, String zonas, String director,String gerente){//y demas datos

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
				banco.setGerente(gerente);
			}
		}
		for(POI poi:getSistema().getPois())
		{
			if(poi.getId()==id)
			{
				getSistema().persistirPOI(poi);
				poi.setNombre(nombre);
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
				getSistema().getCgps().remove(cgp);
			}
		}
		for(Banco banco:getSistema().getBancos())
		{
			if(banco.getId()==id)
			{
				getSistema().getCgps().remove(banco);
			}
		}
		
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        

		
		for(POI poi:getSistema().getPois())
		{
			if(poi.getId()==id){
				getSistema().getPois().remove(poi);
		        session.delete(poi);

		        session.getTransaction().commit();
		        session.close();
				return true;
			}
		}
		return false;
	}


}
