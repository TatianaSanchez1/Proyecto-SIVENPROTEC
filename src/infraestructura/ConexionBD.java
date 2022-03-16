/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestructura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Personal
 */
public class ConexionBD {

	/**
	 * Establece la conexión entre la base de datos
	 */
	public Connection getConexion() {
		Connection result = null;
		try {
			result = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sivenprotec?serverTimezone=UTC",
				"root",
				""
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
