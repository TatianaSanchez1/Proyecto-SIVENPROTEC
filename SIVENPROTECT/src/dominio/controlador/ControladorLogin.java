/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.controlador;

import dominio.accesoDatos.LoginDAO;
import dominio.modelo.Login;

/**
 *
 * @author Personal
 */
public class ControladorLogin {
    LoginDAO loginDAO = new LoginDAO();
    
    public Login log(String correo, String contrasena){
        return loginDAO.log(correo, contrasena);
    }
    
    public boolean registrar(Login registro){
        return loginDAO.registrar(registro);
    }
}
