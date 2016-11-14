package disenio;

import javax.swing.JOptionPane;
import java.io.Serializable;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;
import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;


public class PalabraClave implements Serializable {
    
    public PalabraClave(String frase) {
		this.id_palabra = 0;
		this.frase = frase;
		this.pois = new HashSet<POI>();
	}

    public PalabraClave() {
    	this.id_palabra=0;
		this.pois = new HashSet<POI>();
	}
    
     private int id_palabra;
     
     private String frase;
     
     private Set<POI> pois;

	public int getId_palabra() {
		return id_palabra;
	}

	public void setId_palabra(int id_palabra) {
		this.id_palabra = id_palabra;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
	public Set<POI> getPoi() {
		return pois;
	}

	public void setPoi(Set<POI> pois) {
		this.pois = pois;
	}
	public Set<POI> getPois() {
		return pois;
	}
	public void setPois(Set<POI> pois) {
		this.pois = pois;
	}
	
	public void agregarPoi(POI poiActual)
	{
		this.pois.add(poiActual);
	}
}

