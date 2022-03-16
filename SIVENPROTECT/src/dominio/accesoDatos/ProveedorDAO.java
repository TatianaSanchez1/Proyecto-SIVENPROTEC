/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.accesoDatos;

import dominio.modelo.Proveedor;
import infraestructura.ConexionBD;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Personal
 */
public class ProveedorDAO {
    Connection connection;
    ConexionBD conexion = new ConexionBD();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    
    public boolean registrarProveedor(Proveedor proveedor){
        String sql = "INSERT INTO proveedores(documento,nombre,direccion,telefono,codigoProducto) VALUES (?,?,?,?,?)";
        
        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, proveedor.getDocumentoProveedor());
            preparedStatement.setString(2, proveedor.getNombreProveedor());
            preparedStatement.setString(3, proveedor.getDireccionProveedor());
            preparedStatement.setString(4, proveedor.getNumTelProveedor());
            preparedStatement.setString(5, proveedor.getCodigoProductoProveedor());
            preparedStatement.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List listarProveedores(){
        List<Proveedor> listaProveedores = new ArrayList();
        
        String sql = "SELECT * FROM proveedores";
        
        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Proveedor proveedor = new Proveedor();
                
                proveedor.setId(resultSet.getInt("id"));
                proveedor.setDocumentoProveedor(resultSet.getString("documento"));
                proveedor.setNombreProveedor(resultSet.getString("nombre"));
                proveedor.setDireccionProveedor(resultSet.getString("direccion"));
                proveedor.setNumTelProveedor(resultSet.getString("telefono"));
                proveedor.setCodigoProductoProveedor(resultSet.getString("codigoProducto"));
                
                listaProveedores.add(proveedor);
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return listaProveedores;
    }
    
    public boolean eliminarProveedor(int id){
        String sql = "DELETE FROM proveedores WHERE id = ?";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {

            /**
             * liberar cualquier otro recurso de la base de datos que la
             * conexión pueda estar reteniendo.
             */
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean actualizarProveedor(Proveedor proveedor){
        String sql = "UPDATE proveedores SET documento = ? ,nombre = ? ,"
                + "direccion = ?, telefono = ?, codigoProducto = ? WHERE id = ?";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, proveedor.getDocumentoProveedor());
            preparedStatement.setString(2, proveedor.getNombreProveedor());
            preparedStatement.setString(3, proveedor.getDireccionProveedor());
            preparedStatement.setString(4, proveedor.getNumTelProveedor());
            preparedStatement.setString(5, proveedor.getCodigoProductoProveedor());
            preparedStatement.setInt(6, proveedor.getId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {

            /**
             * liberar cualquier otro recurso de la base de datos que la
             * conexión pueda estar reteniendo.
             */
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        }
    }
}
