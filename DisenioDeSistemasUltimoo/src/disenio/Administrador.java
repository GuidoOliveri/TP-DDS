package disenio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Administrador extends Usuario{

	public Administrador(String usuario, String contrasenia, Terminal sistema) {
		super(sistema,usuario,contrasenia);
	}

	public Administrador(Terminal sistema){
		super(sistema);
	}
	
	//GET / SET

	//OTROS METODOS

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

	
	/*
	public ArrayList<AccionDeUsuario> getAccionesUsuario() {
		return accionesDelUsuario;
	}*/

}
