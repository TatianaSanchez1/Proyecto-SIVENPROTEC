/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.modelo;

/**
 *
 * @author Personal
 */
public class Cliente {

    private int id;
    private String documentoCliente;
    private String nombreCliente;
    private String numTelCliente;
    private String correoCliente;
    private String direccionCliente;

    public Cliente() {
    }

    public Cliente(int id, String documentoCliente, String nombreCliente,
            String numTelCliente, String correoCliente, String direccionCliente) {
        this.id = id;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.numTelCliente = numTelCliente;
        this.correoCliente = correoCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumTelCliente() {
        return numTelCliente;
    }

    public void setNumTelCliente(String numTelCliente) {
        this.numTelCliente = numTelCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

}
