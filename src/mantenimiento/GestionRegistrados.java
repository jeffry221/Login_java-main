package mantenimiento;

import com.mysql.jdbc.PreparedStatement;

import inicial.Registrados;
import utils.MySQLConexion;

public class GestionRegistrados {
	
	public int registrar(Registrados registrado) {
		int rs = 0;
		
		String sql = "INSERT INTO usuarios values (?,?,?,?,?,?)";

		try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
			ps.setString(1, registrado.getUsuario().trim());
			ps.setString(2, registrado.getClave());
			ps.setString(3, registrado.getNombre());
			ps.setString(4, registrado.getApellido());
			ps.setString(5, registrado.getCorreo());
			ps.setInt(6, registrado.getNumero());
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}

}
