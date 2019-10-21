/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Users.Famoso;
import Users.Seguidor;
import client.Client;
import dto.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import observer.Observer;

/**
 *
 * @author Gabriel
 */
public class VentanaSeguidor extends JFrame {
    private Seguidor seguidor; 
    JButton botonLike;
    JButton botonDislike;
    JButton botonSeguir;
    JLabel mensajeNuevo;
    JLabel notificacionNueva;
    JComboBox<Famoso> comboFamoso;
    Client client;
    Observer observer = new Observer() {

      @Override
      public void update(Message message, int id) {
            if(message.getHeader().compareToIgnoreCase("famoso/new")==0){
                Famoso f = new Famoso(message.getMessage(),message.getMessage());
                comboFamoso.addItem(f);
            }
            
            for(Famoso f:seguidor.getSeguidos()){
                if((f.getNombre()+"/baja").compareToIgnoreCase(message.getHeader())==0){
                    ArrayList<Famoso> seguidos = seguidor.getSeguidos();
                    seguidos.remove(f);
                    seguidor.setSeguidos(seguidos);
                }
                if((f.getNombre()+"/message").compareToIgnoreCase(message.getHeader())==0){
                    displayMessage(message.getMessage());
                    botonLike.setEnabled(true);
                    botonDislike.setEnabled(true);
                }
                else if((f.getNombre()+"/notificacion").compareToIgnoreCase(message.getHeader())==0){
                    displayNotificacion(message.getMessage());
                }
            }
      }
      
    };
    
     
    public VentanaSeguidor(Seguidor s){
        inicializarObserver();
        
        seguidor = s;
        cargarVentana();
        cargarBotones();
        cargarLabels();
        cargarFamosos();
        mostrarVentana();
        entrarSeguidor();
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
      
      botonSeguir = new JButton("Seguir");
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
        Message message = new Message("localhost",this.mensajeNuevo.getText(),"seguidor/like");
        client.send(message);
        this.botonLike.setEnabled(false);
        this.botonDislike.setEnabled(true);
    }
    
    private void dislikeMensaje(){
        Message message = new Message("localhost",this.mensajeNuevo.getText(),"seguidor/dislike");
        client.send(message);
        this.botonDislike.setEnabled(false);
        this.botonLike.setEnabled(true);
    }
    
    private void seguir(){
        if(this.comboFamoso.getSelectedItem()==null){
            mostrarEmergente("No tiene ningun famosos seleccionado");
        }
        else{
            String nombreFamoso = this.comboFamoso.getSelectedItem().toString();
            this.seguidor.addSeguidos(nombreFamoso);
            System.out.print(nombreFamoso);
            Message message = new Message("localhost",nombreFamoso, "seguidor/follow");
            client.send(message);
        }
    }
    
    private void mostrarVentana() {
        setLayout(null);
        setVisible(true);
    }
    
    private void cargarLabels(){
        mensajeNuevo= new JLabel("Test");
        notificacionNueva= new JLabel("testNotificaciones");
        JLabel labelMensajes = new JLabel("Mensajes Nuevos:");
        labelMensajes.setBounds(30,0,130,80);
        mensajeNuevo.setBounds(135, 0, 200, 80);
        JLabel labelNotificaciones = new JLabel("Notificaciones:");
        labelNotificaciones.setBounds(30,250,130,80);
        notificacionNueva.setBounds(115, 250,200, 80);
        add(labelMensajes);
        add(labelNotificaciones);
        add(mensajeNuevo);
        add(notificacionNueva);
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

    private void inicializarObserver() {
        client = new Client("localhost", 5000, 1, observer);
        client.initClient();
        client.run();
    }

    private void entrarSeguidor() {
        Message message = new Message("localhost","", "famoso/get");
        client.send(message);
    }
    
    private void displayMessage(String message){
        this.mensajeNuevo.setText("<html>"+message+"</html>");
    }
    
    private void displayNotificacion(String notificacion){
        this.notificacionNueva.setText(notificacion);
    }
}
