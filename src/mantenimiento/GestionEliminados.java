package mantenimiento;

import com.mysql.jdbc.PreparedStatement;

import inicial.Actualizados;
import utils.MySQLConexion;

public class GestionEliminados {
	public static int eliminar(Actualizados actualizar) {
		int rs = 0;
		
		String sql = "DELETE FROM usuarios Where usuario=?";

		try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
			ps.setString(1, actualizar.getUsuario());
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}

}


