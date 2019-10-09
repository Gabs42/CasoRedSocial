/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Users.Famoso;
import Users.Seguidor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Gabriel
 */
public class Ventana extends JFrame {
        
    JButton botonLoginFamoso;
    JButton botonLoginSeguidor;
    JTextField nombre;
    JTextField correo;
    
     
    public Ventana(){
        cargarVentana();
        cargarBotones();
        cargarNick();
        mostrarVentana();
    }
    
    
    private void cargarVentana() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 200);
    }
    
    private void cargarBotones() {
      botonLoginFamoso = new JButton("Login Famoso");
	  botonLoginFamoso.setBounds(20, 125, 130, 30);
	  botonLoginFamoso.addActionListener(new ActionListener() {      
	    @Override
	    public void actionPerformed(ActionEvent e) {   
               
              loginFamoso();
	    }          
      });
      botonLoginSeguidor = new JButton("Login Seguidor");
      botonLoginSeguidor.setBounds(200, 125, 160, 30);
      botonLoginSeguidor.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              loginSeguidor();
          }
          
      });
      add(botonLoginFamoso);
      add(botonLoginSeguidor);
    }
    
    private void mostrarVentana() {
        setLayout(null);
        setVisible(true);
    }
    
    private void cargarNick(){
        JLabel labelNombre = new JLabel("Nombre:");
        nombre = new JTextField(30);
        labelNombre.setBounds(80,0,130,80);
        nombre.setBounds(160, 25, 150, 30);
        add(labelNombre);
        add(nombre);
        
        JLabel labelCorreo = new JLabel("Correo:");
        correo = new JTextField(30);
        labelCorreo.setBounds(80,50,130,80);
        correo.setBounds(160, 75, 150, 30);
        add(labelCorreo);
        add(correo);
    }
    
    private void loginFamoso(){
        if(this.nombre.getText().equals("")||this.correo.getText().equals("")){
            mostrarEmergente("El nombre o correo esta vacio");
        }
        else{
            Famoso f = new Famoso(nombre.getText(),correo.getText());
            VentanaFamoso window = new VentanaFamoso(f);
            this.setVisible(false);
            dispose();
        }
        
    }
    
    private void loginSeguidor(){
        if(this.nombre.getText().equals("")){
            mostrarEmergente("El nickname esta vacio");
        }
        else{
            Seguidor s = new Seguidor(nombre.getText(),correo.getText());
            VentanaSeguidor window = new VentanaSeguidor(s);
            this.setVisible(false);
            dispose();
        }
        
    }
    
    public void mostrarEmergente(String mensaje) {
	    Emergente emergente = new Emergente(mensaje);
            emergente.mostrar();
    }
    


}     

