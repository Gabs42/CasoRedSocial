/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Mensaje.Mensaje;
import Users.Famoso;
import client.Client;
import dto.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import observer.Observer;

/**
 *
 * @author Gabriel
 */
public class VentanaFamoso extends JFrame {
    private Famoso famoso; 
    JButton botonMensaje;
    JButton botonBaja;
    JTextArea nombre;
    Client client;
    
    Observer observer = new Observer() {
        @Override
        public void update(Message message, int id) {
            if(message.getHeader().compareTo("famoso/get")==0){
                Message newMessage = new Message("localhost",famoso.getNombre(), "famoso/new");
                client.send(newMessage);
            }
            
            if(message.getHeader().compareTo("seguidor/like")==0){
                for(Mensaje m:famoso.getMensajes()){
                    if(m.getDescripcion().compareToIgnoreCase(message.getMessage())==0){
                        m.setLikes(m.getLikes()+1);
                        if(m.getLikes()%10==0){
                            Message newMessage = new Message("localhost","El mensaje de "+famoso.getNombre()+" llego a "+Integer.toString(m.getLikes())+" likes", famoso.getNombre()+"/notificacion");
                            client.send(newMessage);
                        }
                        System.out.println(m.getLikes());
                    }
                }
            }
            if(message.getHeader().compareTo("seguidor/dislike")==0){
                for(Mensaje m:famoso.getMensajes()){
                    if(m.getDescripcion().compareToIgnoreCase(message.getMessage())==0){
                        m.setLikes(m.getLikes()-1);
                        System.out.println(m.getLikes());
                    }
                }
            }
            if(message.getHeader().compareTo("seguidor/follow")==0){
                if(message.getMessage().compareToIgnoreCase(famoso.getNombre())==0){
                    famoso.setNivel(10);
                    if(famoso.getNivel()%10==0){
                        Message newMessage = new Message("localhost",famoso.getNombre()+"llego a "+"nivel "+Integer.toString(famoso.getNivel()), famoso.getNombre()+"/notificacion");
                            client.send(newMessage);
                    }
                }
            }
            //System.out.println(id);
            //System.out.println(message.getMessage());
        } 
    };
    
    
     
    public VentanaFamoso(Famoso f){
        inicializarObserver();
        famoso = f;
        actualizarFamosos();
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
        Mensaje msg = new Mensaje(this.nombre.getText().toString(),"NuevoMensaje",1);
        this.famoso.addMensajes(msg);
        
        Message message = new Message("localhost",msg.getDescripcion(), famoso.getNombre()+"/message");
        client.send(message);
    }
    
    private void darseDeBaja(){
        Message message = new Message("localhost","", famoso.getNombre()+"/baja");
        client.send(message);
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
    
    private void inicializarObserver() {
        
         client = new Client("localhost", 5000, 1, observer);
         client.initClient();
         client.run();
    }

    private void actualizarFamosos() {
        Message message = new Message("localhost",this.famoso.getNombre(), "famoso/new");
        client.send(message);
    }
}
