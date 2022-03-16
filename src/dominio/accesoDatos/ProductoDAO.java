/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.accesoDatos;

import dominio.modelo.DatosEmpresa;
import dominio.modelo.Producto;
import java.sql.*;
import infraestructura.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class ProductoDAO {
    Connection connection;
    ConexionBD conexion = new ConexionBD();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public boolean registrarProducto(Producto producto) {
        String sql = "INSERT INTO productos(codigoProducto, nombre, cantidad, "
                + "precioVenta, precioCompra, proveedor) VALUES(?,?,?,?,?,?)";
        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setFloat(4, producto.getPrecioVenta());
            preparedStatement.setFloat(5, producto.getPrecioCompra());
            preparedStatement.setString(6, producto.getProveedor());

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

    public void consultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedores";

        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                proveedor.addItem(resultSet.getString("nombre"));
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setCodigo(resultSet.getString("codigoProducto"));
                producto.setNombreProducto(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecioVenta(resultSet.getFloat("precioVenta"));
                producto.setPrecioCompra(resultSet.getFloat("precioCompra"));
                producto.setProveedor(resultSet.getString("proveedor"));

                listaProductos.add(producto);
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
        return listaProductos;
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

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

    public boolean actualizarProducto(Producto producto){
        String sql = "UPDATE productos SET codigoProducto = ?, nombre = ?, cantidad = ?,"
                + "precioVenta = ?, precioCompra = ?, proveedor = ? WHERE id = ?";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setFloat(4, producto.getPrecioVenta());
            preparedStatement.setFloat(5, producto.getPrecioCompra());
            preparedStatement.setString(6, producto.getProveedor());
            preparedStatement.setInt(7, producto.getId());

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

    public Producto buscarProducto(String codigo){
        Producto producto = new Producto();
        String sql = "SELECT * FROM productos WHERE codigoProducto = ?";

        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, codigo);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                producto.setNombreProducto(resultSet.getString("nombre"));
                producto.setPrecioVenta(resultSet.getFloat("precioVenta"));
                producto.setCantidad(resultSet.getInt("cantidad"));

            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }

    public DatosEmpresa buscarDatos(){
        DatosEmpresa datos = new DatosEmpresa();
        String sql = "SELECT * FROM config";

        try{
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                datos.setId(resultSet.getInt("id"));
                datos.setNit(resultSet.getString("nit"));
                datos.setNombre(resultSet.getString("nombre"));
                datos.setTelefono(resultSet.getString("telefono"));
                datos.setDireccion(resultSet.getString("direccion"));

            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return datos;
    }

    public boolean actualizarDatos(DatosEmpresa datos){
        String sql = "UPDATE config SET nombre = ?, nit = ?, telefono = ?, direccion = ? WHERE id = ?";

        try {
            connection = conexion.getConexion();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, datos.getNombre());
            preparedStatement.setString(2, datos.getNit());
            preparedStatement.setString(3, datos.getTelefono());
            preparedStatement.setString(4, datos.getDireccion());
            preparedStatement.setInt(5, datos.getId());

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
