/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensaje;

/**
 *
 * @author Gabriel
 */
public class Mensaje {
    private String descripcion;
    private String titulo;
    private int likes;
    private int id;

    public Mensaje(String descripcion, String titulo, int likes, int id) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.likes = likes;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
