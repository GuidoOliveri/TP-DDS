package disenio;

import java.util.Set;

import java.util.Set;

public class CGP extends POI {
	
	private String zonas,director,domicilio,servicios;
	private int telefono;
	

		public CGP (int id,int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
    		setTipoCercania(new MismaComuna());
    		setId(id);
        }
		public CGP(int id)
		{
			setId(id);
		}
		
		public CGP()
		{
			super();
		}

		public CGP (int id,String nombre,float latitud, float longitud,Set<PalabraClave> palabras) {
			setId(id);
			setNombre(nombre);
			setLatitud(latitud);
			setLongitud(longitud);
			setPalabrasClave(palabras);
        }

		public String getZonas() {
			return zonas;
		}


		public void setZonas(String zonas) {
			this.zonas = zonas;
    		getPalabrasClave().add(new PalabraClave(zonas));
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
    		getPalabrasClave().add(new PalabraClave(domicilio));
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