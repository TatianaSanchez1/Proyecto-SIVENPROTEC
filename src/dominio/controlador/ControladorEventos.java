/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.controlador;

import dominio.modelo.Eventos;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Personal
 */
public class ControladorEventos {
    Eventos eventos = new Eventos();
    public void textKeyPress(KeyEvent evt){
        eventos.textKeyPress(evt);
    }
    
    public void numberKeyPress(KeyEvent evt){
        eventos.numberKeyPress(evt);
    }
}
