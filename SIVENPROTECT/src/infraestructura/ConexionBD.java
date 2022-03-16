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
 *
 * @author Personal
 */
public class ConexionBD {

    Connection connetion;

    public Connection getConexion() {
        try {
            String dataBase = "jdbc:mysql://localhost:3306/sivenprotec?serverTimezone=UTC";

            /**
             * Establece la conexión entre la base de datos
             */
            connetion = DriverManager.getConnection(dataBase, "root", "");

            return connetion;

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
