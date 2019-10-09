/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Users.Famoso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class VentanaFamoso extends JFrame {
    private Famoso famoso; 
    JButton botonMensaje;
    JButton botonBaja;
    JTextArea nombre;
    
    
     
    public VentanaFamoso(Famoso f){
        famoso = f;
        cargarVentana();
        cargarBotones();
        cargarNick();
        mostrarVentana();
    }
    
    
    private void cargarVentana() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
    }
    
    private void cargarBotones() {
      botonMensaje = new JButton("Enviar Mensaje");
	  botonMensaje.setBounds(20, 300, 130, 30);
	  botonMensaje.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              postMensaje();
	    }          
      });
      add(botonMensaje);
      
      botonBaja = new JButton("Darse De Baja");
	  botonBaja.setBounds(180, 300, 130, 30);
	  botonBaja.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              darseDeBaja();
	    }          
      });
      add(botonBaja);
    }
    
    private void postMensaje(){
        
    }
    
    private void darseDeBaja(){
        
    }
    
    private void mostrarVentana() {
        setLayout(null);
        setVisible(true);
    }
    
    private void cargarNick(){
        JLabel labelMensaje = new JLabel("Mensaje:");
        nombre = new JTextArea();
        labelMensaje.setBounds(30,0,130,80);
        nombre.setBounds(110, 25, 250, 250);
        add(labelMensaje);
        add(nombre);
    }
    
    
    public void mostrarEmergente(String mensaje) {
	    Emergente emergente = new Emergente(mensaje);
            emergente.mostrar();
    }
}
