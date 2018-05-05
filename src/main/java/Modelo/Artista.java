/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Asus-PC
 */
public class Artista {
    private ArrayList<Cancion> sencillos=new ArrayList<>();
    private ArrayList<Album> albums=new ArrayList<>();
    private String Nombre;

    public ArrayList<Cancion> getSencillos() {
        return sencillos;
    }

    public void setSencillos(ArrayList<Cancion> sencillos) {
        this.sencillos = sencillos;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
