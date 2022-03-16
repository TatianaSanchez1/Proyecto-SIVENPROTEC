/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.accesoDatos;

import dominio.modelo.DetalleVenta;
import dominio.modelo.Venta;
import infraestructura.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Personal
 */
public class VentaDAO {

    Connection connection;
    ConexionBD conexion = new ConexionBD();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    int resultado;

    public VentaDAO() {
    }

    public int registrarVenta(Venta venta) {
        String sql = "INSERT INTO ventas(cliente, vendedor, total) VALUES(?,?,?)";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, venta.getCliente());
            preparedStatement.setString(2, venta.getVendedor());
            preparedStatement.setFloat(3, venta.getTotal());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

        return resultado;
    }

    public int registrarDetalle(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle(codigoProducto, cantidad, precio, idVenta) VALUES (?,?,?,?)";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, detalle.getCodigoProducto());
            preparedStatement.setInt(2, detalle.getCantidad());
            preparedStatement.setFloat(3, detalle.getPrecio());
            preparedStatement.setInt(4, detalle.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

        return resultado;

    }
    
    public int idVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        
        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    public boolean actualizarStock(int cantidad, String codigo){
        String sql = "UPDATE productos SET cantidad = ? WHERE codigoProducto = ?";
        
        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, cantidad);
            preparedStatement.setString(2, codigo);
            
            preparedStatement.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List listarVentas() {
        List<Venta> listaVentas = new ArrayList();
        String sql = "SELECT * FROM ventas";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getInt("id"));
                venta.setCliente(resultSet.getString("cliente"));
                venta.setVendedor(resultSet.getString("vendedor"));
                venta.setTotal(resultSet.getFloat("total"));

                listaVentas.add(venta);
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
        return listaVentas;
    }
    
    public boolean alerta(String codigoProducto){
        String sql = "SELECT * FROM productos WHERE codigoProducto = ?";
        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codigoProducto);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int cantidad = resultSet.getInt("cantidad");
                if (cantidad < 5) {
                    return true;
                }else{
                    return false;
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }    
        return false;
    }
}
