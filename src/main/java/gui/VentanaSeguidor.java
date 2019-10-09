/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Users.Famoso;
import Users.Seguidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class VentanaSeguidor extends JFrame {
    private Seguidor seguidor; 
    JButton botonLike;
    JButton botonDislike;
    
    
     
    public VentanaSeguidor(Seguidor s){
        seguidor = s;
        cargarVentana();
        cargarBotones();
        cargarNick();
        mostrarVentana();
    }
    
    
    private void cargarVentana() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 500);
    }
    
    private void cargarBotones() {
      botonLike = new JButton("Dar Like");
	  botonLike.setBounds(20, 350, 130, 30);
	  botonLike.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              likeMensaje();
	    }          
      });
      add(botonLike);
      
      botonDislike = new JButton("Dar dislike");
	  botonDislike.setBounds(180, 350, 130, 30);
	  botonDislike.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              dislikeMensaje();
	    }          
      });
      add(botonDislike);
    }
    
    private void likeMensaje(){
        
    }
    
    private void dislikeMensaje(){
        
    }
    
    private void mostrarVentana() {
        setLayout(null);
        setVisible(true);
    }
    
    private void cargarNick(){
        JLabel labelCantidad = new JLabel("Mensajes Nuevos:");
        labelCantidad.setBounds(30,0,130,80);
        JLabel labelNotificaciones = new JLabel("Notificaciones:");
        labelNotificaciones.setBounds(30,250,130,80);
        add(labelCantidad);
        add(labelNotificaciones);
    }
    
    
    public void mostrarEmergente(String mensaje) {
	    Emergente emergente = new Emergente(mensaje);
            emergente.mostrar();
    }
}
