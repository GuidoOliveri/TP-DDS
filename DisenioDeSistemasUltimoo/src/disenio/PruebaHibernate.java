package disenio;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author alumnodisenio
 */
public class PruebaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sessionFactory;
           
        Configuration configuration = new Configuration();
        //mediante el método configure() se va a leer el fichero de configuración hibernate.cfg.xml
        configuration.configure();
        
        //esto es nuevo en hibernate 4 y contiene la lista de los distintos servicios 
        //que usará hibernate.Para ello se crea un objeto de la clase org.hibernate.service.ServiceRegistry.
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
       // finalmente se creará el objeto SessionFactory en función de la configuración y de los servicios
        sessionFactory = configuration.buildSessionFactory();
        
        
		Set<POI> pois = new HashSet<POI>();
        POI unPoi=new POI();
        unPoi.setId(0);
        unPoi.setNombre("Fravega");
        PalabraClave palabra = new PalabraClave("Hola1");
        pois.add(unPoi);
        Set<PalabraClave> palabras=new HashSet<PalabraClave>();
        PalabraClave pala = new PalabraClave("juan");
        palabras.add(palabra);
        PalabraClave palabra2 =new PalabraClave("pepito");
        PalabraClave palabra3 = new PalabraClave("pepeeeee");
        palabras.add(palabra2);
        palabras.add(palabra3);
        POI otroPoi=new POI("OtraPalabra", "Rivadavia", 32, 4,palabras);
        pois.add(otroPoi);
        
        Set<PalabraClave> palabras2=new HashSet<PalabraClave>();
        
        unPoi.setPalabrasClaves(palabras);
        
        palabras2.add(palabra);
        
        otroPoi.setPalabrasClaves(palabras2);


        Usuario usu = new Usuario();
        usu.setContrasenia("argento");
        usu.setUsuario("pepe");
        usu.setMiPoi(unPoi);
		Calendar fecha = new GregorianCalendar();
		
        Busqueda busq = new Busqueda(fecha.getTime(), pois, 4, "lala",usu); 
		Set<Busqueda> busquedas = new HashSet<Busqueda>();
		busquedas.add(busq);
		usu.setBusquedas(busquedas);
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(unPoi);
        session.saveOrUpdate(otroPoi);
        session.saveOrUpdate(usu);

        session.saveOrUpdate(busq);
        Busqueda busq2 = new Busqueda(fecha.getTime(), pois, 4, "lala",usu); 
        session.saveOrUpdate(busq2);

        /*
        unPoi.setNombre("Garbarino");
        
        session.saveOrUpdate(unPoi);
        
        session.saveOrUpdate(usu);
        
        unPoi.getPalabrasClave().clear();
        
        session.saveOrUpdate(unPoi);
        */

        session.getTransaction().commit();
        session.close();

    }
    
}
