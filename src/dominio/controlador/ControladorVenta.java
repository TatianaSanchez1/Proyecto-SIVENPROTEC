/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.controlador;

import dominio.accesoDatos.VentaDAO;
import dominio.modelo.DetalleVenta;
import dominio.modelo.Venta;
import java.util.List;

/**
 *
 * @author Personal
 */
public class ControladorVenta {
    VentaDAO ventaDAO = new VentaDAO();
    
    public int RegistrarVenta(Venta venta){
        return ventaDAO.registrarVenta(venta);
    }
    
    public int registrarDetalle(DetalleVenta detalle){
        return ventaDAO.registrarDetalle(detalle);
    }
    
    public int idVenta(){
        return ventaDAO.idVenta();
    }
    
    public boolean actualizarStock(int cantidad, String codigo){
        return ventaDAO.actualizarStock(cantidad, codigo);
    }
    
    public List listarVentas() {
        return ventaDAO.listarVentas();
    }
    
    public boolean alerta(String codigoProducto){
        return ventaDAO.alerta(codigoProducto);
    }
}
