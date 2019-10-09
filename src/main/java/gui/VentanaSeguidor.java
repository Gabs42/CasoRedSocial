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
import javax.swing.JComboBox;
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
    JButton botonSeguir;
    JComboBox<Famoso> comboFamoso;
    
    
     
    public VentanaSeguidor(Seguidor s){
        seguidor = s;
        cargarVentana();
        cargarBotones();
        cargarNick();
        cargarFamosos();
        mostrarVentana();
    }
    
    
    private void cargarVentana() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 600);
    }
    
    private void cargarBotones() {
      botonLike = new JButton("Dar Like");
	  botonLike.setBounds(20, 480, 130, 30);
	  botonLike.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              likeMensaje();
	    }          
      });
      add(botonLike);
      
      botonDislike = new JButton("Dar dislike");
	  botonDislike.setBounds(180, 480, 130, 30);
	  botonDislike.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              dislikeMensaje();
	    }          
      });
      add(botonDislike);
      
      botonSeguir = new JButton("Dar dislike");
	  botonSeguir.setBounds(320, 480, 130, 30);
	  botonSeguir.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              seguir();
	    }          
      });
      add(botonSeguir);
    }
    
    private void likeMensaje(){
        
    }
    
    private void dislikeMensaje(){
        
    }
    
    private void seguir(){
        
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

    private void cargarFamosos() {
        JLabel famosos = new JLabel("Famosos:");
        famosos.setBounds(30,350,130,30);
        add(famosos);
        comboFamoso = new JComboBox<Famoso>();
        /*
            for(Famoso f : s) {
		comboFamoso.addItem(f);
	    }
*/
        comboFamoso.setBounds(90, 350, 130, 30);
        
        add(comboFamoso);
        
    }
}
