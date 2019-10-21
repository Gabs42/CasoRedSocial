/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import client.Client;
import dto.Message;
/**
 *
 * @author Gabriel
 */
public class Seguidor {
    private String nombre;
    private String correo;
    private ArrayList<Famoso> seguidos = new ArrayList<>();

    public Seguidor(String nombre,String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Famoso> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(ArrayList<Famoso> seguidos) {
        this.seguidos = seguidos;
    }
    
    public void addSeguidos(String famosoNombre){
        seguidos.add(new Famoso(famosoNombre,famosoNombre));
    }
    
    public void seguir(Famoso f){
        
    }
}
