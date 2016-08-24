package disenio;

import java.util.Date;
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

		public Usuario(Terminal unSistema) {
			sistema=unSistema;
			poisAux=new HashSet<POI>();
			this.busquedas = new HashSet<Busqueda>();
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
		
		public Set<POI> buscarPoi(String palabra){  
			Calendar fecha = new GregorianCalendar();
			getPoisAux().clear();
			float tfinal,tinicial=System.currentTimeMillis();
			if(!getSistema().getPois().isEmpty())
				for (POI poi:getSistema().getPois()){
					if(poi.getPalabrasClaves().contains(palabra))
					{
						getPoisAux().add(poi);
					}
				}

			tfinal=System.currentTimeMillis();
			setBusquedaAux(new Busqueda(fecha.getTime(),getPoisAux().size(),((tfinal-tinicial)/1000),palabra));
			
			getSistema().getBusquedas().add(getBusquedaAux());

			getSistema().agregarFecha(fecha.getTime());
			
			// sistema.notificarPorMail(2, 1);
			
			//(tfinal-tinicial)/1000
			
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



	}

//lalala