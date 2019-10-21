/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Mensaje.Mensaje;
import java.util.ArrayList;
import client.Client;
import dto.Message;
/**
 *
 * @author Gabriel
 */
public class Famoso {
    private String nombre;
    private String correo;
    private int nivel = 1;
    private ArrayList<Seguidor> seguidores = new ArrayList<>();
    private ArrayList<Mensaje> mensajes =  new ArrayList<>(); 

    public Famoso(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Seguidor> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(ArrayList<Seguidor> seguidores) {
        this.seguidores = seguidores;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void addMensajes(Mensaje msg){
        this.mensajes.add(msg);
    }
    
    public String toString(){
        return this.getNombre();
    }
    
    public void darseDeBaja(){
        
    }
}
