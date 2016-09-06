package disenio;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
		private Busqueda busquedaAux;
		private POI miPoi;
		private Terminal sistema;
		private Set<POI> poisAux;
		private Set<Busqueda> busquedas;
		private ArrayList<Boolean> accionesDelUsuario;
		private String usuario, contrasenia;
		private Command command;

		public Usuario(Terminal unSistema) {
			sistema=unSistema;
			poisAux=new HashSet<POI>();
			this.busquedas = new HashSet<Busqueda>();
			command = new Base(sistema);
		}
		
		public Usuario(Terminal unSistema,String usuario,String contrasenia) {
			sistema=unSistema;
			poisAux=new HashSet<POI>();
			this.busquedas = new HashSet<Busqueda>();
			this.usuario=usuario;
			this.contrasenia=contrasenia;
			command = new Base(sistema);
		}
		
		//GET / SET
		
		public POI obtenerPOI(){
			return miPoi;
		}
		
		public POI getMiPoi() {
			return miPoi;
		}

		public void setMiPoi(POI miPoi) {
			
			this.miPoi = miPoi;
		}
		
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
		}
		
		public Set<POI> buscarPoi(String palabra){  
			Calendar fecha = new GregorianCalendar();
			getPoisAux().clear();
			long tfinal,tinicial=System.currentTimeMillis();
			if(!getSistema().getPois().isEmpty())
				for (POI poi:getSistema().getPois()){
					if(poi.getPalabrasClaves().contains(palabra))
					{
						getPoisAux().add(poi);
					}
				}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tfinal=System.currentTimeMillis();
			setBusquedaAux(new Busqueda(fecha.getTime(),getPoisAux().size(),((tfinal-tinicial)/1000),palabra,this));
			
			agregarBusqueda(getBusquedaAux());
			
			getSistema().getBusquedas().add(getBusquedaAux());

			getSistema().agregarFecha(fecha.getTime());
			
			// getSistema().notificarPorMail((tfinal-tinicial)/1000, 1);
			
			return getPoisAux();
		}
		
		Boolean meQuedaCerca(POI unPoi){
			return miPoi.calculoDeCercania(unPoi);
		}

		Boolean estaDisponible(POI poi){
			return poi.calculoDeDisponibilidad();
		}

		public Busqueda getBusquedaAux() {
			return busquedaAux;
		}

		public void setBusquedaAux(Busqueda busquedaAux) {
			this.busquedaAux = busquedaAux;
		}

		public Set<POI> getPoisAux() {
			return poisAux;
		}

		public void setPoisAux(Set<POI> poisAux) {
			this.poisAux = poisAux;
		}

		public Set<Busqueda> getBusquedas() {
			return busquedas;
		}

		public void setBusquedas(Set<Busqueda> busquedas) {
			this.busquedas = busquedas;
		}

		public ArrayList<Boolean> getAccionesDelUsuario() {
			return accionesDelUsuario;
		}

		public void setAccionesDelUsuario(ArrayList<Boolean> accionesDelUsuario) {
			this.accionesDelUsuario = accionesDelUsuario;
		}

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

	}

//lalala