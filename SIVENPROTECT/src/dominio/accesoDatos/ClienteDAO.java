/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.accesoDatos;

import infraestructura.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import dominio.modelo.Cliente;

/**
 *
 * @author Personal
 */
public class ClienteDAO {

    ConexionBD conexion = new ConexionBD();
    Connection connection;

    /**
     * consulta a sistemas de bases de datos en lenguaje SQL
     */
    PreparedStatement preparedStatement;

    /**
     * contiene todas las filas resultantes de la consulta SQL realizada
     */
    ResultSet resultSet;

    public boolean registrarClientes(Cliente cliente) {
        String sql = "INSERT INTO clientes(documento,nombre,telefono,correo,direccion) VALUES(?,?,?,?,?)";
        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getDocumentoCliente());
            preparedStatement.setString(2, cliente.getNombreCliente());
            preparedStatement.setString(3, cliente.getNumTelCliente());
            preparedStatement.setString(4, cliente.getCorreoCliente());
            preparedStatement.setString(5, cliente.getDireccionCliente());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {

            /**
             * liberar cualquier otro recurso de la base de datos que la
             * conexión pueda estar reteniendo.
             */
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List listarClientes() {
        List<Cliente> listaClientes = new ArrayList();
        String sql = "SELECT * FROM clientes";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setDocumentoCliente(resultSet.getString("documento"));
                cliente.setNombreCliente(resultSet.getString("nombre"));
                cliente.setNumTelCliente(resultSet.getString("telefono"));
                cliente.setCorreoCliente(resultSet.getString("correo"));
                cliente.setDireccionCliente(resultSet.getString("direccion"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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
        return listaClientes;
    }

    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

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

    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET documento = ? ,nombre = ? ,"
                + "telefono = ?, correo = ?, direccion = ? WHERE id = ?";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getDocumentoCliente());
            preparedStatement.setString(2, cliente.getNombreCliente());
            preparedStatement.setString(3, cliente.getNumTelCliente());
            preparedStatement.setString(4, cliente.getCorreoCliente());
            preparedStatement.setString(5, cliente.getDireccionCliente());
            preparedStatement.setInt(6, cliente.getId());

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
    
    public Cliente buscarCliente(String documento){
        Cliente cliente = new Cliente();
        
        String sql = "SELECT * FROM clientes WHERE documento = ?";
        
        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, documento);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                cliente.setNombreCliente(resultSet.getString("nombre"));
                cliente.setNumTelCliente(resultSet.getString("telefono"));
                cliente.setCorreoCliente(resultSet.getString("correo"));
                cliente.setDireccionCliente(resultSet.getString("direccion"));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return cliente;    
    }
}
