/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.accesoDatos;

import infraestructura.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dominio.modelo.Login;

/**
 *
 * @author Personal
 */
public class LoginDAO {

    Connection conexion;

    /**
     * consulta a sistemas de bases de datos en lenguaje SQL
     */
    PreparedStatement preparedStatement;

    /**
     * contiene todas las filas resultantes de la consulta SQL realizada
     */
    ResultSet resultSet;

    ConexionBD con = new ConexionBD();

    public Login log(String correo, String contrasena) {
        Login inicio = new Login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";

        try {
            conexion = con.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                inicio.setId(resultSet.getInt("id"));
                inicio.setNombre(resultSet.getString("nombre"));
                inicio.setCorreo(resultSet.getString("correo"));
                inicio.setContrasena(resultSet.getString("contrasena"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return inicio;
    }
    
    public boolean registrar(Login registro){
        String sql = "INSERT INTO usuarios(nombre, correo, contrasena) VALUES (?,?,?)";
        
        try{
            conexion = con.getConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, registro.getNombre());
            preparedStatement.setString(2, registro.getCorreo());
            preparedStatement.setString(3, registro.getContrasena());
            
            preparedStatement.execute();
            
            return true;
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
        
    }
}
