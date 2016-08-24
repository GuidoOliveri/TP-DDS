package disenio;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.UnsupportedEncodingException;
import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import javax.activation.*;

public class Terminal {
	
	private Set<POI> pois;
	
	private Set<CGP> cgps;
	
	private Set<Banco> bancos;
	
	private Set<Busqueda> busquedas;
	
	private Set<Administrador> admins;
	
	private Set<Date> fechas;

	private Conexion conex;

	private int idAAsignarPoi,idAAsignarAdmin;
	
	public Terminal(){
		pois = new HashSet<POI>();
		cgps= new HashSet<CGP>();
		bancos = new HashSet<Banco>();
		busquedas = new HashSet<Busqueda>();
		admins = new HashSet<Administrador>();
		conex = new Conexion();
		idAAsignarPoi=0;
		idAAsignarAdmin=0;
		fechas =new HashSet<Date>();
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

	public Boolean agregarAdmin(Administrador admin)
	{
		for(Administrador administrador:admins)
		{
			if(administrador.getUsuario().equals(admin.getUsuario()))
				return false;
		}
		return admins.add(admin);
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
	
	public void asignarIdPoi(POI unPoi)
	{
		idAAsignarPoi=idAAsignarPoi+1;
		unPoi.setId(idAAsignarPoi-1);
	}

	public static void menuAdmin(Terminal sistema)
	{
		int opcion,valor,tipoPoi,idABuscar,latitud = 0,longitud = 0,masPalabras=1,comuna;
		Boolean logueado=false,exito=false;
		String usu,cont,texto,nombre,director,gerente,zonas;

		Set<POI>poisAux = new HashSet<POI>();
		
		Scanner capt= new Scanner(System.in);
		Administrador yo = new Administrador(sistema);
		
		do
		{
			logueado=false;
			System.out.println("Ingrese Usuario");
			usu=capt.next();
			System.out.println("Ingrese Contrasenia");
			cont=capt.next();
			if(logueado = yo.logueo(usu,cont))
			{
				System.out.println("Logueo exitoso\n");
			}
			else
				System.out.println("Usuario o contraseña erroneos\n");
	

		}while(!logueado);

		do{
			
		System.out.println("Elija opcion:\n\n1-Agregar Poi\n2-Modificar Poi\n3-Eliminar Poi\n4-Buscar POI\n5-Calcular cercania (coordenada geografica)\n6-Calcular disponibilidad\n7-Reporte parcial por usuario\n8-Reporte por busqueda\n9-Reporte por fecha\n10-Reporte total por usuario\n11-Salir\n");

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
				poiAux.agregarPalabrasClaves(texto);
				
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
			valor=capt.nextInt();
			poiAux.setLatitud(valor);
			System.out.println("Ingrese longitud de poi");
			valor=capt.nextInt();
			poiAux.setLongitud(valor);
			//y demas datos...
			
		    sistema.asignarIdPoi(poiAux);

		     switch (tipoPoi) {
	            case 1:  poiAux = new Banco(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClaves());
						capt.nextLine();
	            		System.out.println("Ingrese gerente del banco");
						texto=capt.nextLine();
						poiAux.setGerente(texto);
						
						System.out.println("Ingrese sucursal del banco");
						texto=capt.nextLine();
						poiAux.setSucursal(texto);
						
						System.out.println("Ingrese comuna que cubre el banco");
						valor=capt.nextInt();
						poiAux.setComuna(valor);
						capt.nextLine();

						yo.agregarBanco((Banco)poiAux);
	                     break;
	                     
	            case 2:  poiAux = new CGP(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClaves());
	       
	
						System.out.println("Ingrese comuna que cubre el CGP");
						valor=capt.nextInt();
						poiAux.setComuna(valor);
	            
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
						poiAux.setTelefono(valor);
						
						capt.nextLine();
						System.out.println("Ingrese servicios del CGP");
						texto=capt.nextLine();
						poiAux.setServicios(texto);
						
						yo.agregarCgp((CGP)poiAux);
			
						
	                     break;
	                     
	            case 3:  poiAux = new Kiosco(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClaves());

	                     break;
	                     
	            case 4:  poiAux = new Libreria(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClaves());
	            
	                     break;
	                     
	            case 5:  poiAux = new ParadaColectivo(poiAux.getId(),poiAux.getNombre(),poiAux.getLatitud(),poiAux.getLongitud(),poiAux.getPalabrasClaves());
	            
	            
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
				System.out.println("Sin resultados\n");
			else
			{
				System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
				for(POI poi:poisAux){
					poi.listar();
				}
			}

		}
		else if (opcion==5){
			capt.nextLine();
			System.out.println("Ingrese texto a buscar");
			texto=capt.nextLine();
			poisAux.addAll(yo.buscarPoi(texto));
			if(poisAux.isEmpty())
				System.out.println("Sin resultados\n");
			else
			{
				System.out.println("Cantidad de POIs encontrados: "+poisAux.size()+"\n");
				for(POI poi:poisAux){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+yo.getMiPoi().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud())+"\n");
					if(yo.getMiPoi().calculoDeCercania(poi))
						
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
			sistema.reporteConsultas();
		}
	    
		else if(opcion==9)
		{
			sistema.reportePorFecha();
		}
	    
		else if(opcion==10)
		{
			sistema.reporteTotalPorUsuario();
		}

		}while(opcion!=11);
		
		capt.close();
	}
	
	public static void menuUsuario(Terminal sistema)
	{
		int opcion=0;
		String texto;
		Scanner capt= new Scanner(System.in);
		Set<POI>poisAux = new HashSet<POI>();
		Calendar fecha = new GregorianCalendar();
		Set<String> palabras = new HashSet<String>();
		palabras.add("utn");
		palabras.add("facultad");
		POI poiAux = new POI("Utn",34,34,palabras);
		sistema.asignarIdPoi(poiAux);
		Usuario yo=new Usuario(sistema);
		yo.setMiPoi(poiAux);
		yo.setSistema(sistema);
		
		do{
			System.out.println("Elija opcion:\n\n1-Buscar Punto\n2-Calcular cercania (coordenada geografica)\n3-Calcular disponibilidad\n4-Salir\n\n");

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
						System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+yo.getMiPoi().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud())+"\n");
						if(yo.getMiPoi().calculoDeCercania(poi))
							
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
			
			else if(opcion!=4)
				System.out.println("Elija una opcion de las ofrecidas\n\n");
			
			poisAux.clear();
			}while(opcion!=4);
			capt.close();
	}
	

	public static void main(String[] args)
	{
		Terminal sistema=new Terminal();
		int opcion;
		String texto;
		Scanner scanner= new Scanner(System.in);
		Administrador unAdmin1=new Administrador("pepe","argento",sistema);
		Administrador unAdmin2=new Administrador("lionel","messi",sistema);
		Administrador unAdmin3=new Administrador("caruso","lombardi",sistema);
		
		sistema.agregarAdmin(unAdmin1);
		sistema.agregarAdmin(unAdmin2);
		sistema.agregarAdmin(unAdmin3);

	
		/* prueba para corroborar que funciona la distancia entre 2 puntos 
			Usuario guido = new Usuario();
		 	guido.setMiPoi(unPoi);
		 	guido.getMiPoi().aCuantoEstoyDe(56, 75);
		 	
			prueba de clase ActualizarComercios, funciona, genera el txt
			Componente loc = new ActualizarComercios();
			loc.ejecutar();*/
		
		System.out.println("Bienvenido al sistema de busqueda de POIS\n\n");

		do
		{

			System.out.println("-1 Menu administrador\n-2 Menu usuario\n-3 Salir");
			opcion=scanner.nextInt();
			if(opcion==1)
			{
				menuAdmin(sistema);
				
			}
			
			else if(opcion==2)
			{
				menuUsuario(sistema);
			}
			
			else if(opcion!=3)
			{
				System.out.println("Ingrese opcion valida\n\n");
			}

		}while(opcion!=3);
		
		scanner.close();
}


	public void setConex(Conexion conex) {
		this.conex = conex;
	}

	public int getIdAAsignarPoi() {
		return idAAsignarPoi;
	}

	public void setIdAAsignarPoi(int nuevoId) {
		this.idAAsignarPoi = nuevoId;
	}

	public void reporteParcialPorUsuario()
	{
		if(busquedas.isEmpty())
		{
			System.out.println("No hay busquedas\n\n");
		}
		else
		{
			for(Administrador admin:admins)
			{
				if(!admin.getBusquedas().isEmpty())
				//System.out.print(fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900));
				{
					System.out.println("Usuario: "+admin.getUsuario()+"\n");
					for(Busqueda busq:admin.getBusquedas())
					{
						System.out.println(busq.getResultados()+"\n");
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
						cantidad = cantidad + busq.getResultados();
					}
				}
				System.out.print(cantidad+"     \n");
			}
		}
	}
	
	public void reporteConsultas()
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
				System.out.println("'"+busq.getFrase()+"'"+"              "+busq.getResultados()+"                         "+busq.getTiempo()+"\n");
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

	public int getIdAAsignarAdmin() {
		return idAAsignarAdmin;
	}

	public void setIdAAsignarAdmin(int idAAsignarAdmin) {
		this.idAAsignarAdmin = idAAsignarAdmin;
	}
	
	public void actualizarAdminConBusqueda(Administrador unAdministrador,Busqueda aux)
	{
		for(Administrador admin:admins)
		{
			if(admin.getUsuario().equals(unAdministrador.getUsuario()))
			{
				admin.agregarBusqueda(aux);
			}
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
}
//hola