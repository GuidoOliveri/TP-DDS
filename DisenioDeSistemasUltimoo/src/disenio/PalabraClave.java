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


@Entity
@Table(name="PalabraClave")
public class PalabraClave implements Serializable {
    
    public PalabraClave(String frase) {
		this.id_palabra = 0;
		this.frase = frase;
	}

    public PalabraClave() {
    	this.id_palabra=0;
	}
    
     private int id_palabra;
     
     private String frase;
     
     private Set<POI> pois;
/*
 	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_palabra")
    */
	public int getId_palabra() {
		return id_palabra;
	}

	public void setId_palabra(int id_palabra) {
		this.id_palabra = id_palabra;
	}

    //@Column(name="frase")
	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
/*
    @ManyToOne
    @JoinColumn(name="id_POI")
    */
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
}
