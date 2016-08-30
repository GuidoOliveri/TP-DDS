package disenio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Administrador extends Usuario{
	
	private String usuario, contrasenia;
	

	public Administrador(String usuario, String contrasenia, Terminal sistema) {
		super(sistema);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		
	}

	public Administrador(Terminal sistema){
		super(sistema);

	}
	
	//GET / SET
	
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

	//OTROS METODOS

	public Boolean logueo(String usu,String cont){
		usuario=usu;
		contrasenia =cont;
		for (Administrador admin:super.getSistema().getAdmins()){
			if((admin.getUsuario().equals(usu))&&(admin.getContrasenia().equals(cont)))
			{
				return true;
			}
		}
		return false;
	}
	
	public void agregarPOI(POI unPOI){
		
		super.getSistema().getPois().add(unPOI);
	}
	
	public void agregarCgp(CGP unCgp)
	{
		super.getSistema().getCgps().add(unCgp);
		getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","insert into Tabla_CGPs (id,comuna,zonas,director,domicilio,telefono,servicios) values ("+unCgp.getId()+","+unCgp.getComuna()+",'"+unCgp.getZonas()+"','"+unCgp.getDirector()+"','"+unCgp.getDomicilio()+"',"+unCgp.getTelefono()+",'"+unCgp.getServicios()+"')");
		
	}	
	public void agregarBanco(Banco unBanco)
	{
		super.getSistema().getBancos().add(unBanco);
		getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","INSERT INTO Tabla_Bancos (id, nombre, comuna, gerente, sucursal) VALUES ("+(unBanco.getId())+",'"+(unBanco.getNombre())+"',"+(unBanco.getComuna())+",'"+(unBanco.getGerente())+"','"+(unBanco.getSucursal())+"')");
		
	}
	
	public Boolean modificarPOI(int id,String nombre,int comuna, String zonas, String director,String gerente){//y demas datos

		for(CGP cgp:getSistema().getCgps())
		{
			if(cgp.getId()==id)
			{
				cgp.setNombre(nombre);
				cgp.setComuna(comuna);
				cgp.setDirector(director);
				cgp.setZonas(zonas);
				getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","UPDATE Tabla_CGPs SET comuna="+comuna+",zonas='"+zonas+"',director='"+director+"' WHERE id="+id+";");
			}
		}
		for(Banco banco:getSistema().getBancos())
		{
			if(banco.getId()==id)
			{
				banco.setNombre(nombre);
				banco.setComuna(comuna);
				banco.setGerente(gerente);
				getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","UPDATE Tabla_Bancos SET nombre='"+nombre+"',comuna="+comuna+",gerente='"+gerente+"' WHERE id="+id+";");
			}
		}
		for(POI poi:super.getSistema().getPois())
		{
			if(poi.getId()==id)
			{
				poi.setNombre(nombre);
				return true;
			}
		}
		return false;
	}

	public Boolean eliminarPOI(int id){
		
		for(CGP cgp:getSistema().getCgps())
		{
			if(cgp.getId()==id)
			{
				getSistema().getCgps().remove(cgp);
				getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+id+";");
			}
		}
		for(Banco banco:getSistema().getBancos())
		{
			if(banco.getId()==id)
			{
				getSistema().getCgps().remove(banco);
				getSistema().getConexion().update("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_Bancos WHERE id="+id+";");
			}
		}
		for(POI poi:super.getSistema().getPois())
		{
			if(poi.getId()==id){
				super.getSistema().getPois().remove(poi);
				return true;
			}
		}
		return false;
	}

	public void agregarBusqueda(Busqueda unaBusqueda)
	{
		getBusquedas().add(unaBusqueda);
	}
	
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
		setBusquedaAux(new Busqueda(fecha.getTime(),getPoisAux().size(),((tfinal-tinicial)/1000),palabra,this));
		
		getSistema().actualizarAdminConBusqueda(this,getBusquedaAux());
		
		getSistema().getBusquedas().add(getBusquedaAux());

		getSistema().agregarFecha(fecha.getTime());
		
		// getSistema().notificarPorMail((tfinal-tinicial)/1000, 1);
		
		return getPoisAux();
	}
	
	public void setCommand(Command command){
		
		command.ejecutar();
	}
	
	/*
	public ArrayList<AccionDeUsuario> getAccionesUsuario() {
		return accionesDelUsuario;
	}*/

}
