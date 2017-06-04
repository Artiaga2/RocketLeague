package com.artiaga.Modelo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by artiaga on 6/3/17.
 */
public class Rueda extends Item {

    //Constructor


    public Rueda(String nombre, Rareza rareza, Plataforma plataforma) {
        super(nombre, rareza, plataforma);
    }

    //Metodos

    public static Comparator<Rueda> comparadorPorNombreRueda = new Comparator<Rueda>() {
        @Override
        public int compare(Rueda rueda1, Rueda rueda2) {
            int res;

            res = rueda1.getNombre().compareToIgnoreCase(rueda2.getNombre());

            if (res != 0){
                return res;
            }
            return rueda1.getRareza().compareTo(rueda2.getRareza());
        }
    };

    public static Comparator<Rueda> comparadorPorRarezaRueda = new Comparator<Rueda>() {
        @Override
        public int compare(Rueda rueda1, Rueda rueda2) {
            int res;

            res = rueda1.getRareza().compareTo(rueda2.getRareza());

            if (res != 0){
                return res;
            }
            return rueda1.getNombre().compareToIgnoreCase(rueda2.getNombre());

        }
    };

    public static Comparator<Rueda> comparadorPorPlataformaRueda = new Comparator<Rueda>() {
        @Override
        public int compare(Rueda rueda1, Rueda rueda2) {
            int res;

            res = rueda1.getPlataforma().compareTo(rueda2.getPlataforma());

            if (res != 0){
                return res;
            }
            return rueda1.getNombre().compareToIgnoreCase(rueda2.getNombre());

        }
    };
    
}
