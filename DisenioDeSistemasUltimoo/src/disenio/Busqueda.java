package disenio;

import java.util.Date;

public class Busqueda {
	public Busqueda(Date date, int resultados, float tiempo, String frase,Administrador admin) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.admin=admin;
	}	
	
	public Busqueda(Date date, int resultados, float tiempo, String frase,Usuario usu) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.admin=null;
	}	
	
	public Busqueda(Date date, int resultados, float tiempo, String frase) {
		this.fecha = date;
		this.resultados = resultados;
		this.tiempo = tiempo;
		this.frase = frase;
		this.admin=null;
	}
	private Date fecha;
	private int resultados;
	private float tiempo;
	private String frase;
	private Administrador admin;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getResultados() {
		return resultados;
	}
	public void setResultados(int resultados) {
		this.resultados = resultados;
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
}