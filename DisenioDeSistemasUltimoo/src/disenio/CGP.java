package disenio;

import java.util.Set;

import java.util.Set;

public class CGP extends POI {
	
	private String zonas,director,domicilio,servicios;
	private int telefono;
	

		public CGP (int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
    		tipoCercania=new MismaComuna();

        }
		public CGP()
		{
			
		}

		public CGP (int id,String nombre,double latitud, double longitud,Set<String> palabras) {
			super(nombre, latitud,longitud,palabras);
	    	setId(id);
        }

		public String getZonas() {
			return zonas;
		}


		public void setZonas(String zonas) {
			this.zonas = zonas;
    		super.getPalabrasClaves().add(zonas);
		}


		public String getDirector() {
			return director;
		}


		public void setDirector(String director) {
			this.director = director;
		}


		public String getDomicilio() {
			return domicilio;
		}


		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
    		super.getPalabrasClaves().add(domicilio);
		}


		public int getTelefono() {
			return telefono;
		}


		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public void listar()
		{
			super.listar();
			System.out.println("Telefono:"+telefono+"\n");
		}
		public String getServicios() {
			return servicios;
		}
		public void setServicios(String servicios) {
			this.servicios = servicios;
		}

		
}