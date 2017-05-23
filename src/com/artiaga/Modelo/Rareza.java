package com.artiaga.Modelo;

public enum Rareza {

    COMUN("Comun"),
    PREMIUM("Premium"),
    LIMITADO("Limitado"),
    RARO("Raro"),
    MUYRARO("Muy Raro"),
    IMPORT("Importado"),
    EXOTICO("Exotico"),
    POCOCOMUN("Poco Comun"),
    SUPERARO("Super Raro");


    private final String rareza;

    //Constructor


    Rareza(String rareza) {
        this.rareza = rareza;
    }

    //Getter


    public String getRareza() {
        return rareza;
    }
}
