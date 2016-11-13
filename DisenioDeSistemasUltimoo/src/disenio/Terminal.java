package disenio;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.beans.ParameterDescriptor;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.activation.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;

public class Terminal {
	
	private Set<POI> pois;
	
	private Set<CGP> cgps;
	
	private Set<Banco> bancos;
	
	private Set<Busqueda> busquedas;
	
	private Set<Administrador> admins;
	
	private Set<Usuario> usuarios;

	private Set<Date> fechas;
	
	private Set<String> nicks;

	private Conexion conex;
	
	private Boolean usuariosConPrivilegios;
	
	private POI poiActual;
	
	public Terminal(POI poiActual){
		this.poiActual=poiActual;
		pois = new HashSet<POI>();
		cgps= new HashSet<CGP>();
		bancos = new HashSet<Banco>();
		busquedas = new HashSet<Busqueda>();
		admins = new HashSet<Administrador>();
		usuarios = new HashSet<Usuario>();
		conex = new Conexion();
		fechas =new HashSet<Date>();
		nicks = new HashSet<String>();
		usuariosConPrivilegios=false;
	}

	public Conexion getConexion(){
		return conex;
	}
	
	public Set<POI> getPois(){
		return pois;
	}

	public Set<Administrador> getAdmins() {
		return admins;
	}

	public void agregarPOI(POI unPoi){
		pois.add(unPoi);
	}

	
	public void persistirPalabra(PalabraClave o)
	{
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(o);

        session.getTransaction().commit();
        session.close();
	}
	
	public void persistirUsuario(Usuario o)
	{
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(o);

        session.getTransaction().commit();
        session.close();
	}
	
	public void persistirPOI(POI o)
	{
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(o);

        session.getTransaction().commit();
        session.close();
	}
	
	public void persistirBusqueda(Busqueda o)
	{
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        sessionFactory = configuration.buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(o);

        session.getTransaction().commit();
        session.close();
	}
	
	
	public Boolean agregarAdmin(Administrador admin)
	{
		if(!nickOcupado(admin.getUsuario()))
		{
		nicks.add(admin.getUsuario());
		
		return admins.add(admin);
		}
		else
			return false;
	}
	
	public Boolean agregarUsuario(Usuario usu)
	{
		if(!nickOcupado(usu.getUsuario()))
		{
			nicks.add(usu.getUsuario());
			if(getUsuariosConPrivilegios())
			{
				Composite componente;
				componente=new Composite(this);
				componente.agregarProceso(new BajaDePoi(this));
				componente.agregarProceso(new ActualizarComercios(this));
				usu.setCommand(componente);
			}
			return usuarios.add(usu);
		}
		else
			return false;
	}
	
	public Boolean agregarBusqueda(Busqueda busquedaAux)
	{
		return busquedas.add(busquedaAux);
	}

	public void setAdmins(Set<Administrador> admins) {
		this.admins = admins;
	}


	public void setPois(Set<POI> pois) {
		this.pois = pois;
	}
	
	public Boolean listarPois()
	{
		if(!pois.isEmpty())
		{
			for(POI poi:pois)
			{
				poi.listar();
			}
			return true;
		}
		else
			return false;
	}

	
	public Administrador logueoAdmin(String nombre, String contrasenia)
	{
		for(Administrador unUsuario: admins)
		{
			if((unUsuario.getUsuario().equals(nombre))&&(unUsuario.getContrasenia().equals(contrasenia)))
			{
				return unUsuario;
			}
		}
		return null;
	}
	public Usuario logueoUsu(String nombre, String contrasenia)
	{
		for(Usuario unUsuario: usuarios)
		{
			if((unUsuario.getUsuario().equals(nombre))&&(unUsuario.getContrasenia().equals(contrasenia)))
			{
				return unUsuario;
			}
		}
		return null;
	}

	public static int menuAdmin(Terminal sistema)
	{
		int opcion,opcionLogueo,tipoPoi,idABuscar,latitud = 0,longitud = 0,masPalabras=1,comuna;
		Boolean exito=false;
		String usu,cont,texto,nombre,director,gerente,zonas;
		float valor;

		Set<POI>poisAux = new HashSet<POI>();
		
		Scanner capt= new Scanner(System.in);
		Administrador yo;
		
			System.out.println("Ingrese Usuario");
			usu=capt.next();
			System.out.println("Ingrese Contrasenia");
			cont=capt.next();
			if(null!=(yo = (Administrador)(sistema.logueoAdmin(usu,cont))))
			{
				System.out.println("Logueo exitoso\n");
			}
			else
			{
				System.out.println("Usuario o contraseña erroneos\n");
				return 0;
			}

		do{
			
		System.out.println("\nElija opcion:\n\n1-Agregar Poi\n2-Modificar Poi\n3-Eliminar Poi\n4-Buscar POI\n5-Calcular cercania (coordenada geografica)\n6-Calcular disponibilidad\n7-Reporte parcial por usuario\n8-Reporte por busqueda\n9-Reporte por fecha\n10-Reporte total por usuario\n11-Salir\n\nProcesos:\n\n12-Actualizar Comercios\n13-Agregar acciones a usuarios\n14-Quitar acciones a usuarios\n15-Baja de POIs inactivos");

		opcion=capt.nextInt();
	    if (opcion==1){
			POI poiAux =new POI();

			System.out.println("A que categoria pertenece el Poi?");
			System.out.println("1-Banco\n2-CGP\n3-Kiosco\n4-Libreria\n5-Parada de colectivo\nValor diferente-Otro");
			tipoPoi=capt.nextInt();

		     do
		     {
				capt.nextLine();
				System.out.println("Ingrese una etiqueta para identificar al poi");
				texto=capt.nextLine();
				poiAux.agregarPalabraClave(new PalabraClave(texto));
				
				System.out.println("Quiere agregar mas etiquetas?");
				System.out.println("1-Si\n2-No");
				masPalabras=capt.nextInt();
				
		     }while(masPalabras==1);
			
		    masPalabras=1;
			capt.nextLine();
			System.out.println("Ingrese nombre de poi");
			texto=capt.nextLine();
			poiAux.setNombre(texto);
			System.out.println("Ingrese latitud de poi");
			valor=capt.nextFloat();
			poiAux.setLatitud(valor);
			System.out.println("Ingrese longitud de poi");
			valor=capt.nextFloat();
			poiAux.setLongitud(valor);
			//y demas datos...
			

		     switch (tipoPoi) {
	            case 1:  poiAux = new Banco(poiAux.getId(),poiAux.getNombre(),poiAux.getCalle(),poiAux.getAltura(),poiAux.getComuna(),poiAux.getPalabrasClave(),poiAux.getLatitud(),poiAux.getLongitud());
	            capt.nextLine();
	            		System.out.println("Ingrese gerente del banco");
						texto=capt.nextLine();
						poiAux.setGerente(texto);
						
						System.out.println("Ingrese sucursal del banco");
						texto=capt.nextLine();
						poiAux.setSucursal(texto);
						
						System.out.println("Ingrese comuna que cubre el banco");
						valor=capt.nextInt();
						poiAux.setComuna((int)valor);
						capt.nextLine();

						yo.agregarBanco((Banco)poiAux);
	                     break;
	                     
	            case 2:  poiAux = new CGP(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClave());
	       
	
						System.out.println("Ingrese comuna que cubre el CGP");
						valor=capt.nextInt();
						poiAux.setComuna((int) valor);
	            
						capt.nextLine();
						System.out.println("Ingrese zonas que cubre el CGP");
						texto=capt.nextLine();
						poiAux.setZonas(texto);
						
						System.out.println("Ingrese director del CGP");
						texto=capt.nextLine();
						poiAux.setDirector(texto);
						
						System.out.println("Ingrese domicilio del CGP");
						texto=capt.nextLine();
						poiAux.setDomicilio(texto);
						
						System.out.println("Ingrese telefono del CGP");
						valor=capt.nextInt();
						poiAux.setTelefono((int) valor);
						
						capt.nextLine();
						System.out.println("Ingrese servicios del CGP");
						texto=capt.nextLine();
						poiAux.setServicios(texto);
						
						yo.agregarCgp((CGP)poiAux);
			
						
	                     break;
	                     
	            case 3:  poiAux = new Kiosco(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClave());

	                     break;
	                     
	            case 4:  poiAux = new Libreria(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClave());
	            
	                     break;
	                     
	            case 5:  poiAux = new ParadaColectivo(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClave());
	            
	            
	                     break;
	                     
	            default: 
	            
	                     break;
	        }

		     


			yo.agregarPOI(poiAux);
		}
		else if(opcion==2){
			
			exito=false;
			
			if(sistema.listarPois())
			{
				do
				{
					System.out.println("Ingrese id de poi");
					idABuscar=capt.nextInt();
					capt.nextLine();
					System.out.println("Ingrese nuevo nombre de poi");
					nombre=capt.nextLine();
					System.out.println("Ingrese nueva comuna de poi");
					comuna=capt.nextInt();
					capt.nextLine();
					System.out.println("Ingrese nuevas zonas de poi");
					zonas=capt.nextLine();
					System.out.println("Ingrese nuevo director de poi");
					director=capt.nextLine();
					System.out.println("Ingrese nuevo gerente de poi");
					gerente=capt.nextLine();
					
					if(exito=yo.modificarPOI(idABuscar,nombre, comuna, zonas, director,gerente))
						
						System.out.println("Modificado exitosamente\n\n");
					
					else
						System.out.println("Hubo un problema, intente nuevamente\n\n");

				}while(!exito);
			}
			
			else
				System.out.println("No hay pois");
		}
		
		else if (opcion==3){
			
			exito=false;
			
			if(sistema.listarPois())
			{
				do
				{
					System.out.println("Ingrese id de poi a eliminar");
					idABuscar=capt.nextInt();
					capt.nextLine();
					
					if(exito=yo.eliminarPOI(idABuscar))
					{
						System.out.println("Eliminado exitosamente\n\n");
					}
					
					else
						System.out.println("Hubo un problema, intente nuevamente\n\n");
					
				}while(!exito);
			}
			else
				System.out.println("No hay pois");
			
		}
		
		else if (opcion==4){
			poisAux.clear();
			capt.nextLine();
			System.out.println("Ingrese texto a buscar");
			texto=capt.nextLine();
			poisAux.addAll(yo.buscarPoi(texto));
			if(poisAux.isEmpty())
			{
				System.out.println("Sin resultados\n");
			}
			else
			{
				System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
				for(POI poi:poisAux){
					poi.listar();
				}
				capt.nextLine();
			}

		}
		else if (opcion==5){
			capt.nextLine();
			System.out.println("Ingrese texto a buscar");
			texto=capt.nextLine();
			poisAux.addAll(yo.buscarPoi(texto));
			if(poisAux.isEmpty())
			{
				System.out.println("Sin resultados\n");
				capt.nextLine();
			}
			else
			{
				System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
				for(POI poi:poisAux){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+sistema.getPoiActual().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud())+"\n");
					if(sistema.getPoiActual().calculoDeCercania(poi))
						
						System.out.println("Usted esta cerca de "+poi.getNombre()+"\n");
					else
						
						System.out.println("Usted esta lejos de "+poi.getNombre()+"\n");

				}
				poisAux.clear();
			}
		
		}
		
		else if (opcion==6){
			capt.nextLine();
			System.out.println("Ingrese texto a buscar");
			texto=capt.nextLine();
			poisAux=yo.buscarPoi(texto);
			if(poisAux.size()==0)
				System.out.println("Sin resultados\n");
			else
			{
				System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
				for(POI poi:poisAux){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
					if(poi.calculoDeDisponibilidad())
						
						System.out.println(""+poi.getNombre()+" esta disponible ahora mismo\n");
					else
						
						System.out.println(""+poi.getNombre()+" no esta disponible ahora mismo\n");

				}
				poisAux.clear();
			}
		}
	    
		else if(opcion==7)
		{
			sistema.reporteParcialPorUsuario();
		}
	    
		else if(opcion==8)
		{
			sistema.reporteConsultas(capt);
		}
	    
		else if(opcion==9)
		{
			sistema.reportePorFecha();
		}
	    
		else if(opcion==10)
		{
			sistema.reporteTotalPorUsuario();
		} 

	    
		else if(opcion==12)
		{
			yo.setCommand(new ActualizarComercios(sistema));
			yo.invoke();
		}
	    
		else if(opcion==13)
		{
			yo.setCommand(new AgregarAccionesUsuarios(sistema));
			yo.invoke();
		}
	    
		else if(opcion==14)
		{
			yo.setCommand(new AgregarAccionesUsuarios(sistema));
			yo.undo();
		}
	    
		else if(opcion==15)
		{

			yo.setCommand(new BajaDePoi(sistema));
			yo.invoke();
		}
		else if(opcion!=11)
			System.out.println("Elija una opcion de las ofrecidas\n\n");
		
	    
		}while(opcion!=11);
		yo=null;
		return 1;
	}
	
	public static int menuUsuario(Terminal sistema)
	{
		int opcion=0;
		String texto,usu,cont;
		Scanner capt= new Scanner(System.in);
		Set<POI>poisAux = new HashSet<POI>();
		Set<PalabraClave> palabras = new HashSet<PalabraClave>();
		palabras.add(new PalabraClave("utn"));
		palabras.add(new PalabraClave("facultad"));
		POI poiAux = new POI("Utn","Medrano",951,4,palabras,true);
		poiAux.setLatitud((float) -34.5985524);
		poiAux.setLongitud((float) -58.4202828);
		Usuario yo = null;
		
			System.out.println("Ingrese Usuario");
			usu=capt.next();
			System.out.println("Ingrese Contrasenia");
			cont=capt.next();
			if(null !=(yo = sistema.logueoUsu(usu,cont)))
			{
				System.out.println("Logueo exitoso\n");
			}
			else
			{
				System.out.println("Usuario o contraseña erroneos\n");
				return 0;
			}
		
		do{
			System.out.println("\nElija opcion:\n\n1-Buscar Punto\n2-Calcular cercania (coordenada geografica)\n3-Calcular disponibilidad\n4-Salir\n\n5-Ejecutar procesos anidados");

			opcion=capt.nextInt();
			texto=capt.nextLine();
			if (opcion==1){
				poisAux.clear();
				System.out.println("Ingrese texto a buscar");
				texto=capt.nextLine();
				poisAux.addAll(yo.buscarPoi(texto));
				if(poisAux.isEmpty())
					System.out.println("Sin resultados\n");
				else
				{
					System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
					for(POI poi:poisAux){
						poi.listar();
					}
				}
			}
			
			else if (opcion==2){
				
				System.out.println("Ingrese texto a buscar");
				texto=capt.nextLine();
				poisAux.addAll(yo.buscarPoi(texto));
				if(poisAux.isEmpty())
					System.out.println("Sin resultados\n");
				else
				{
					System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
					for(POI poi:poisAux){
						System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+sistema.getPoiActual().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud())+"\n");
						if(sistema.getPoiActual().calculoDeCercania(poi))
							
							System.out.println("Usted esta cerca de "+poi.getNombre()+"\n");
						else
							
							System.out.println("Usted esta lejos de "+poi.getNombre()+"\n");

					}
					poisAux.clear();
				}
			
			}
			
			else if (opcion==3){
				System.out.println("Ingrese texto a buscar");
				texto=capt.nextLine();
				poisAux=yo.buscarPoi(texto);
				if(poisAux.size()==0)
					System.out.println("Sin resultados\n");
				else
				{
					System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
					for(POI poi:poisAux){
						System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
						if(poi.calculoDeDisponibilidad())
							
							System.out.println(""+poi.getNombre()+" esta disponible ahora mismo\n");
						else
							
							System.out.println(""+poi.getNombre()+" no esta disponible ahora mismo\n");

					}
					poisAux.clear();
				}
			}
			
			else if(opcion==5)
			{
				yo.invoke();
			}
			
			else if(opcion!=4)
				System.out.println("Elija una opcion de las ofrecidas\n\n");
			
			
			poisAux.clear();
			}while(opcion!=4);
		yo=null;
		return 1;
	}
	

	public static void main(String[] args)
	{
		int opcion;
		Set<PalabraClave> palabras = new HashSet<PalabraClave>();
		PalabraClave pala1,pala2;
		pala1 = new PalabraClave("utn");
		pala2 = new PalabraClave("facultad");
		palabras.add(pala1);
		palabras.add(pala2);
		POI poiActual = new POI("Utn","Medrano",951,4,palabras,true);
		poiActual.setLatitud((float) -34.5985524);
		poiActual.setLongitud((float) -58.4202828);
		Terminal sistema=new Terminal(poiActual);
		sistema.persistirPalabra(pala1);
		sistema.persistirPalabra(pala2);
		sistema.agregarPOI(poiActual);
		sistema.persistirPOI(poiActual);
		Scanner scanner= new Scanner(System.in);
		Administrador unAdmin1=new Administrador(sistema,"pepe","argento",poiActual);
		Administrador unAdmin2=new Administrador(sistema,"lionel","messi",poiActual);
		Administrador unAdmin3=new Administrador(sistema,"caruso","lombardi",poiActual);
		
		sistema.agregarAdmin(unAdmin1);
		sistema.agregarAdmin(unAdmin2);
		sistema.agregarAdmin(unAdmin3);
		sistema.persistirUsuario(unAdmin1);
		sistema.persistirUsuario(unAdmin2);
		sistema.persistirUsuario(unAdmin3);
		
	
		ZPrueboACA ventana = new ZPrueboACA(sistema);
		
		ventana.ejecutar();
		
		
		/* caso de prueba para el de BajaDePoi, no funciona todavia
		BajaDePoi baja = new BajaDePoi();
		POI poi = new POI();
		poi.setId(4000);
		poi.setLatitud(454);
		poi.setLongitud(44);
		sistema.agregarPOI(poi);
		baja.setID(4000);
		baja.ejecutar();
		*/
	
		//prueba para corroborar que funciona la distancia entre 2 puntos 
			/*Usuario guido = new Usuario();
		 	guido.setMiPoi(unPoi);
		 	guido.getMiPoi().aCuantoEstoyDe(56, 75);
			*/
		
			
		/*pruebo, creo un poi, le seteo las palabras, y despues el size del sistema va a ser uno porque se agrega
			ActualizarComercios loc = new ActualizarComercios();
			ParadaColectivo colectivo = new ParadaColectivo();
			Set<String>palabrasMias = new HashSet<String>();
			palabrasMias.add("bondi, colectivo, 114");
			colectivo.setPalabrasClaves(palabrasMias);
			colectivo.setNombre("colectivo");
			sistema.agregarPOI(colectivo);
			loc.setTerminal(sistema);
			// antes tengo bondi colectivo 114
			System.out.println(loc.getTerminal().getPois().size());
			System.out.println(colectivo.getPalabrasClaves());
			loc.ejecutar();
			// despues de ejecutar, imprime las del txt: hola, como, andas
			System.out.println(loc.getTerminal().getPois().size());
			System.out.println(colectivo.getPalabrasClaves());
		*/
		
		/*
		
		System.out.println("Bienvenido al sistema de busqueda de POIS\n\n");

		do
		{
			System.out.println("-1 Menu administrador\n-2 Menu usuario\n-3 �No tenes cuenta?, registrate\n-4 Salir");
			opcion=scanner.nextInt();
			scanner.nextLine();
			if(opcion==1)
			{
				menuAdmin(sistema);
				
			}
			
			else if(opcion==2)
			{
				menuUsuario(sistema);
			}
			
			else if(opcion==3)
			{
				sistema.registrar(sistema);
			}
			
			else if(opcion!=4)
			{
				System.out.println("Ingrese opcion valida\n\n");
			}

		}while(opcion!=4);
		
		scanner.close();
		*/
		
}


	public void setConex(Conexion conex) {
		this.conex = conex;
	}
	
	public Boolean nickOcupado(String usu)
	{
		for(String nombre:nicks)
		{
			if(nombre.equals(usu))
				return true;
		}
		return false;
	}
	
	public Boolean registrar(Terminal sistema)
	{
		String usu,contra;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Ingrese nombre de usuario");
		usu=scanner.nextLine();
		System.out.println("Ingrese contrase�a");
		contra=scanner.nextLine();
		if(agregarUsuario(new Usuario(sistema,usu,contra,sistema.getPoiActual())))
		{
			System.out.println("Registrado exitosamente");
			return true;
		}
		else
			System.out.println("El nombre de usuario ingresado ya existe");
			return false;
	}

	public void reporteParcialPorUsuario()
	{
		if(busquedas.isEmpty())
		{
			System.out.println("No hay busquedas\n\n");
			JOptionPane.showMessageDialog(null, "No hay busquedas");
		}
		else
		{
			for(Administrador admin:admins)
			{
				if(!admin.getBusquedas().isEmpty())
				{
					System.out.println("Usuario: "+admin.getUsuario()+"\n");
					JOptionPane.showMessageDialog(null, "Usuario: "+admin.getUsuario());
					for(Busqueda busq:admin.getBusquedas())
					{
						System.out.println(busq.getResultados()+"\n");
						JOptionPane.showMessageDialog(null,busq.getResultados());
					}
				}
			}
			
			for(Usuario usu:usuarios)
			{
				if(!usu.getBusquedas().isEmpty())
				{
					System.out.println("Usuario: "+usu.getUsuario()+"\n");
					JOptionPane.showMessageDialog(null, "Usuario: "+usu.getUsuario());
					for(Busqueda busq:usu.getBusquedas())
					{
						System.out.println(busq.getResultados()+"\n");
						JOptionPane.showMessageDialog(null, busq.getResultados());
					}
				}
			}
		}
	}
	
	public void reporteTotalPorUsuario()
	{
		int cantidad;
		if(busquedas.isEmpty())
		{
			System.out.println("No hay busquedas\n\n");
		}
		else
		{
			System.out.println("Usuario       Cantidad de resultados totales\n");
			for(Administrador admin:admins)
			{
				System.out.print(admin.getUsuario()+"              ");
				cantidad=0;
				if(!admin.getBusquedas().isEmpty())
				{
					for(Busqueda busq:admin.getBusquedas())
					{
						cantidad += busq.getResultados().size();
					}
				}
				System.out.print(cantidad+"     \n");
			}
			
			for(Usuario usu:usuarios)
			{
				System.out.print(usu.getUsuario()+"              ");
				cantidad=0;
				if(!usu.getBusquedas().isEmpty())
				{
					for(Busqueda busq:usu.getBusquedas())
					{
						cantidad += busq.getResultados().size();
					}
				}
				System.out.print(cantidad+"     \n");
			}
		}
	}
	
	public void reporteConsultas(Scanner capt)
	{
		if(busquedas.isEmpty())
		{
			System.out.println("No hay busquedas\n\n");
		}
		else
		{
			System.out.println("Frase buscada             Cantidad de resultados             Tiempo de respuesta\n");
			for(Busqueda busq:busquedas)
			{
				System.out.println("'"+busq.getFrase()+"'"+"              "+busq.getResultados().size()+"                         "+busq.getTiempo()+"\n");
			}
		}
	}
	
	public void reportePorFecha()
	{
		int cantidadDeBusquedas;
		if(fechas.isEmpty())
		{
			System.out.println("No hay busquedas\n\n");
		}
		else
		{
			System.out.println("Fecha        Cantidad de Busquedas\n");
			for(Date fecha:fechas)
			{
				System.out.print(fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900));
				cantidadDeBusquedas=0;
				for(Busqueda busq:busquedas)
				{
					if((busq.getFecha().getDate()==fecha.getDate())&&(busq.getFecha().getMonth()==fecha.getMonth())&&(busq.getFecha().getYear()==fecha.getYear()))
						cantidadDeBusquedas = cantidadDeBusquedas +1;
				}
				System.out.println("    "+cantidadDeBusquedas+"\n");

			}
		}
	}

	public Set<Busqueda> getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(Set<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}

	public Set<Date> getFechas() {
		return fechas;
	}

	public void setFechas(Set<Date> fechas) {
		this.fechas = fechas;
	}

	
	public void setCommandUsuarios(Command unCommand)
	{
		for(Usuario unUsuario:usuarios)
		{
			unUsuario.setCommand(unCommand);
		}
	}
/*	public Boolean notificarPorMail(float tiempoTomado,float tiempoMaximo) //ESTA MAL
	{
		if(tiempoTomado>tiempoMaximo)
		{
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);

			try {
			  Message msg = new MimeMessage(session);
			  msg.setFrom(new InternetAddress("sebawars@hotmail.com", "Example.com Admin"));
			  msg.addRecipient(Message.RecipientType.TO,
			                   new InternetAddress("sebawars@hotmail.com", "Mr. User"));
			  msg.setSubject("Tema\n");
			  
			  Transport.send(msg);
			} catch (AddressException e) {
			  // ...
			} catch (MessagingException e) {
			  // ...
			} catch (UnsupportedEncodingException e) {
			  // ...
			}
		      return true;
		}
		else
			return false;
	}*/

	public void agregarFecha(Date fecha)
	{
		Boolean fechaCargada=false;
		for(Date unaFecha:fechas)
		{
			if((unaFecha.getDate()==fecha.getDate())&&(unaFecha.getMonth()==fecha.getMonth())&&(unaFecha.getYear()==fecha.getYear()))
				fechaCargada=true;
		}
		if(!fechaCargada)
			fechas.add(fecha);
	}

	public Set<CGP> getCgps() {
		return cgps;
	}

	public void setCgps(Set<CGP> cgps) {
		this.cgps = cgps;
	}

	public Set<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(Set<Banco> bancos) {
		this.bancos = bancos;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<String> getNicks() {
		return nicks;
	}

	public void setNicks(Set<String> nicks) {
		this.nicks = nicks;
	}

	public Conexion getConex() {
		return conex;
	}

	public Boolean getUsuariosConPrivilegios() {
		return usuariosConPrivilegios;
	}

	public void setUsuariosConPrivilegios(Boolean usuariosConPrivilegios) {
		this.usuariosConPrivilegios = usuariosConPrivilegios;
	}
	
	public void cambiarPrivilegiosUsuarios(Boolean valor)
	{
		usuariosConPrivilegios = valor;
	}

	public POI getPoiActual() {
		return poiActual;
	}

	public void setPoiActual(POI poiActual) {
		this.poiActual = poiActual;
	}
	
	public POI obtenerPoi(int id)
	{
		for(CGP cgp:getCgps())
		{
			if(cgp.getId()==id)
			{
				return cgp;
			}
		}
		for(Banco banco:getBancos())
		{
			if(banco.getId()==id)
			{
				return banco;
			}
		}
		for(POI poi:getPois())
		{
			if(poi.getId()==id)
			{
				return poi;
			}
		}
		return null;
	}
}
