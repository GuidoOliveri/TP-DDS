package disenio;

import java.util.Date;
import java.util.Set;


public class Busqueda {
	
	private int id_busqueda;
	private Date fecha;
	private float tiempo;
	private String frase;
	private Set<POI> resultados;
	private Usuario usuario;

	public Busqueda() {

	}	
	
	public Busqueda(Date date, Set<POI> resultados, float tiempo, String frase,Administrador admin) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.usuario=admin;
		this.id_busqueda = 0;
	}	
	
	public Busqueda(Date date, Set<POI> resultados, float tiempo, String frase,Usuario usu) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.usuario=usu;
		this.id_busqueda = 0;
	}	
	
	public Busqueda(Date date, 	Set<POI> resultados, float tiempo, String frase) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.id_busqueda = 0;
	}

	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getTiempo() {
		return tiempo;
	}
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}

	public Set<POI> getResultados() {
		return resultados;
	}

	public void setResultados(Set<POI> resultados) {
		this.resultados = resultados;
	}

	public int getId_busqueda() {
		return id_busqueda;
	}

	public void setId_busqueda(int id_busqueda) {
		this.id_busqueda = id_busqueda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}