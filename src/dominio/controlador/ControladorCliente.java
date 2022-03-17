/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.controlador;

import dominio.accesoDatos.ClienteDAO;
import dominio.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Personal
 */
public class ControladorCliente {
    ClienteDAO clienteDAO = new ClienteDAO();

    public ControladorCliente() {
    }

    public List<Cliente> listarClientes(){
        return clienteDAO.listarClientes();
    }

    public boolean registrarClientes(Cliente cliente){
        //verificar existencia
        return clienteDAO.registrarClientes(cliente);
    }

    public boolean eliminarCliente(int id){
        return clienteDAO.eliminarCliente(id);
    }

    public boolean actualizarCliente(Cliente cliente){
        return clienteDAO.actualizarCliente(cliente);
    }

    public Cliente buscarClientePorDocumento(String documento){
        return clienteDAO.buscarClientePorDocumento(documento);
    }

    public Cliente buscarClientePorNombre(String nombre){
        return clienteDAO.buscarClientePorNombre(nombre);
    }
}
