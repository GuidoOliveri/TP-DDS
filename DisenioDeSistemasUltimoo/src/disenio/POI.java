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

public class POI implements Serializable{

	
    public POI(int id, int altura, int comuna, int horaApertura, int horaCierre, int diaApertura, int diaCierre,
			int id_horario, int radioLimite, String nombre, String tipo, String calle, Set<PalabraClave> palabrasClave,
			Boolean validez, Cercania tipoCercania, float latitud, float longitud) {
		super();
		this.id_poi = id;
		this.altura = altura;
		this.comuna = comuna;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.diaApertura = diaApertura;
		this.diaCierre = diaCierre;
		this.id_horario = id_horario;
		this.radioLimite = radioLimite;
		this.nombre = nombre;
		this.tipo = tipo;
		this.calle = calle;
		this.palabrasClave = palabrasClave;
		this.validez = validez;
		this.tipoCercania = tipoCercania;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	private int id_poi, altura, comuna,horaApertura,horaCierre,diaApertura,diaCierre,id_horario,radioLimite;
    
    private String nombre,calle;
    
	public Set<PalabraClave> palabrasClave;
	
	private Set<Busqueda> busquedas;
	
    private String tipo;
	
	private Boolean validez;
	
	private Cercania tipoCercania;
	
	private float latitud=0,longitud=0;

	public POI(String nombre,String calle,int altura,int comuna,Set<PalabraClave> palabras) {
		this.palabrasClave=palabras;
		this.id_poi=0;
		this.nombre=nombre;
		this.calle=calle;
		this.altura=altura;
		this.comuna=comuna;
		this.validez = true;
		this.busquedas=new HashSet<Busqueda>();
	}

	public POI()
	{
		this.id_poi = 0 ;
		palabrasClave=new HashSet<PalabraClave>();
		this.validez=true;
		this.busquedas=new HashSet<Busqueda>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getValidez() {
		return validez;
	}

	public void setValidez(Boolean validez) {
		this.validez = validez;
	}

	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public int getRadioLimite() {
		return radioLimite;
	}

	public void setRadioLimite(int radioLimite) {
		this.radioLimite = radioLimite;
	}
	
	public double aCuantoEstoyDe(double latitudPOI, double longitudPOI){
		double R = 6372.8; // en kilometros, radio de la tierra
  		double distancia=0;
  		//formula de haversine
  		double dLat = Math.toRadians(latitudPOI-this.latitud);
  		double dLon = Math.toRadians(longitudPOI-this.longitud);
  		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(latitudPOI));
  		double c = 2 * Math.asin(Math.sqrt(a));
  		distancia =  R * c;
  		JOptionPane.showMessageDialog(null, "La distancia entre los puntos \nA("+getLongitud()+","+getLatitud()+") y B("+longitudPOI+","+latitudPOI+") en kilometros es ="+distancia);
  		return distancia;
	}
	
	public Boolean calculoDeCercania(POI unPoi){
		return tipoCercania.calculoDeCercania(latitud, longitud, unPoi);
	}
	
	
	public Cercania getTipoCercania() {
		return tipoCercania;
	}
	
	public void setTipoCercania(Cercania tipoCercania) {
		this.tipoCercania = tipoCercania;
	}

	public int getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(int horaApertura) {
		this.horaApertura = horaApertura;
	}

	public int getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}

	public int getDiaApertura() {
		return diaApertura;
	}

	public void setDiaApertura(int diaApertura) {
		this.diaApertura = diaApertura;
	}

	public int getDiaCierre() {
		return diaCierre;
	}

	public void setDiaCierre(int diaCierre) {
		this.diaCierre = diaCierre;
	}

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}

	
	public void listar()
	{
		System.out.println("Id:"+id_poi+"\nNombre:"+nombre+"\nLatitud:"+latitud+"\nLongitud:"+longitud+"\n");//algunos datos de ejemplo
	}
	

	public void agregarPalabraClave(PalabraClave palabraClave) {
		this.palabrasClave.add(palabraClave);
	}

	public Boolean esValido(){
		return ((nombre.trim().length()==0)&&(getLongitud()!=0)&&(getLatitud()!=0));
	}

	
	public Boolean calculoDeDisponibilidad(){
		Date fechaActual = new Date();
		if((fechaActual.getHours()<getHoraCierre())&&(fechaActual.getHours()>getHoraApertura())&&(fechaActual.getDay()>=getDiaApertura())&&(fechaActual.getDay()<getDiaCierre()))
			return true;
		else return false;
	}
	
	
	public void setId(int id) {
		this.id_poi = id;
	}
	
	public void setPalabrasClaves(Set<PalabraClave> palabrasClaves) {
		this.palabrasClave = palabrasClaves;
	}
	

	public void setTelefono(int telefono) {
		
	}
	
	public void setServicios(String servicios) {
		
	}

	public void setZonas(String zonas) {

	}

	public void setDirector(String director) {
		
	}

	public void setDomicilio(String domicilio) {
	
	}

	public void agregarservicios(String servicio) {
	}
    
	public void setGerente(String gerente) {
	}
	
	public void setSucursal(String sucursal) {
	}
	
	public int getId() {
		return id_poi;
	}

	public String getNombre() {
		return nombre;
	}
    
	public int getAltura() {
		return altura;
	}
    
	public String getCalle() {
		return calle;
	}

	public int getComuna() {
		return comuna;
	}

	public Set<PalabraClave> getPalabrasClave() {
		return palabrasClave;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getId_poi() {
		return id_poi;
	}



	public void setId_poi(int id_poi) {
		this.id_poi = id_poi;
	}



	public Set<Busqueda> getBusquedas() {
		return busquedas;
	}



	public void setBusquedas(Set<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}


	public void setPalabrasClave(Set<PalabraClave> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
	public void setDisponibilidadHoraria(int horaA,int horaC,int diaA,int diaC)
	{
		this.horaApertura=horaA;
		this.horaCierre=horaC;
		this.diaApertura=diaA;
		this.diaCierre=diaC;
	}

}

