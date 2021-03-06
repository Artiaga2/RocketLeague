package com.artiaga.Modelo;

import com.artiaga.controller.RocketLeagueApp;

import java.io.Serializable;

/**
 * Created by artiaga on 6/3/17.
 */
public class Item implements Serializable {

    private static final long serialVersionUID = -303304975130302802L;
    private String nombre;
    private Rareza rareza;
    private Plataforma plataforma;


    //Constructor



    public Item(String nombre,
                Rareza rareza,
                Plataforma plataforma) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.plataforma = plataforma;
    }


    // Accesores


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rareza getRareza() {
        return rareza;
    }

    public void setRareza(Rareza rareza) {
        this.rareza = rareza;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }





    @Override
    public String toString() {
        return "Nombre: " + nombre  +
                ", Rareza: " + rareza +
                ", Plataforma: " + plataforma;
    }
}
