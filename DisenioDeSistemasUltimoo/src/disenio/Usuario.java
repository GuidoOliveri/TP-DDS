package disenio;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
		private String usuario, contrasenia;
		private Set<Busqueda> busquedas;
		private int id_usuario;
		private Terminal sistema;
		private Command command;
		
		public Usuario(Terminal sistema,String usuario,String contrasenia,POI unPoi) {
			this.sistema=sistema;
			this.usuario=usuario;
			this.contrasenia=contrasenia;
			this.id_usuario=0;
			busquedas= new HashSet<Busqueda>();
		}
		
		public Usuario(Terminal sistema) {
			this.id_usuario=0;
			this.sistema=sistema;
			busquedas= new HashSet<Busqueda>();
		}
		
		public Usuario() {
			this.id_usuario=0;
			busquedas= new HashSet<Busqueda>();
		}


		//GET / SET

		
		public Terminal getSistema() {
			return sistema;
		}

		public void setSistema(Terminal sistema) {
			this.sistema = sistema;
		}

		//OTROS METODOS
		
		public void agregarBusqueda(Busqueda unaBusqueda)
		{
			getBusquedas().add(unaBusqueda);
			//sistema.persistirBusqueda(unaBusqueda);
		}
		
		public Set<POI> buscarPoi(String palabra){  
			Set<POI> poisAux = new HashSet<POI>();
			Busqueda busquedaAux;
			Calendar fecha = new GregorianCalendar();
			long tfinal,tinicial=System.currentTimeMillis();
			if(!getSistema().getPois().isEmpty())
				for (POI poi:getSistema().getPois()){
					if(poi.getValidez())
					for(PalabraClave pal:poi.getPalabrasClave())
					{
						if(pal.getFrase().equals(palabra))
						{
							poisAux.add(poi);
						}
					}
				}
			tfinal=System.currentTimeMillis();
			busquedaAux = new Busqueda(fecha.getTime(),poisAux,((tfinal-tinicial)/1000),palabra,this);
			agregarBusqueda(busquedaAux);
			
			getSistema().getBusquedas().add(busquedaAux);

		 	getSistema().agregarFecha(fecha.getTime());
			
			
			return poisAux;
		}
		
		Boolean meQuedaCerca(POI unPoi){
			return sistema.getPoiActual().calculoDeCercania(unPoi);
		}

		Boolean estaDisponible(POI poi){
			return poi.calculoDeDisponibilidad();
		}

		public Set<Busqueda> getBusquedas() {
			return busquedas;
		}

		public void setBusquedas(Set<Busqueda> busquedas) {
			this.busquedas = busquedas;
		}
/*
		public ArrayList<Boolean> getAccionesDelUsuario() {
			return accionesDelUsuario;
		}

		public void setAccionesDelUsuario(ArrayList<Boolean> accionesDelUsuario) {
			this.accionesDelUsuario = accionesDelUsuario;
		}
*/
		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getContrasenia() {
			return contrasenia;
		}

		public void setContrasenia(String contrasenia) {
			this.contrasenia = contrasenia;
		}
		
		public void setCommand(Command command)
		{
			this.command=command;
		}
		
		public void invoke()
		{
			command.ejecutar();
		}
		
		public void undo()
		{
			command.deshacer();
		}


		public Command getCommand() {
			return command;
		}
		
		public int getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}

	}

//lalala