package disenio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
			Boolean encontrado= false;
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
					
					encontrado = true;
					//getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+cgp.getId()+";");
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
					encontrado=true;
					//getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+banco.getId()+";");
				}
			}
			for(POI poi:getSistema().getPois())
			{
				if(poi.getValidez()==false){
			        SessionFactory sessionFactory;
			        Configuration configuration = new Configuration();
			        configuration.configure();
			        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			        
			        sessionFactory = configuration.buildSessionFactory();
			        
			        Session session=sessionFactory.openSession();
			        session.beginTransaction();
			        
					/*Query q = session.createQuery("DELETE FROM Palabra_Poi where id_poi = "+poi.getId());
					q.executeUpdate();
				    q = session.createQuery("DELETE FROM Busqueda_Poi where id_poi = "+poi.getId());
					q.executeUpdate();*/
					session.delete(poi);

			        session.getTransaction().commit();
			        session.close();
					getSistema().getPois().remove(poi);
					
					JOptionPane.showMessageDialog(null, "Nombre del POI dado de baja: "+poi.getNombre()+"\n"+ 
							"Latitud y Longitud del POI: "+poi.getLatitud()+";"+poi.getLongitud()+"\n"+ 
							"Hora que fue dado de baja: "+dateFormat.format(date)+"\n",
							"POI dado de baja", JOptionPane.DEFAULT_OPTION);
					encontrado=true;
				}
			}
			if(!encontrado)
			{
				JOptionPane.showMessageDialog(null,"No hay POIs inactivos","Error",JOptionPane.DEFAULT_OPTION);		
			}
		}
					
}
	