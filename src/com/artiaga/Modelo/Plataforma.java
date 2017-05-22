package com.artiaga.Modelo;

public enum Plataforma {

    PC ("PC"),
    PLAY("PLAYSTATION"),
    XBOX("XBOX"),
    TODAS("Todas");

    private final String plataforma;

    //Constructor


    Plataforma(String plataforma) {
        this.plataforma = plataforma;
    }


    public String getPlataforma() {
        return plataforma;
    }
}
