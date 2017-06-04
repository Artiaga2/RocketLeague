package com.artiaga.Modelo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by artiaga on 6/3/17.
 */
public class Antena extends Item {

    //Constructor

    public Antena(String nombre, Rareza rareza, Plataforma plataforma) {
        super(nombre, rareza, plataforma);
    }

    //Metodos

    public static Comparator<Antena> comparadorPorNombreAntena = new Comparator<Antena>() {
        @Override
        public int compare(Antena antena1, Antena antena2) {
            int res;

            res = antena1.getNombre().compareToIgnoreCase(antena2.getNombre());

            if (res != 0){
                return res;
            }
            return antena1.getRareza().compareTo(antena2.getRareza());
        }
    };

    public static Comparator<Antena> comparadorPorRarezaAntena = new Comparator<Antena>() {
        @Override
        public int compare(Antena antena1, Antena antena2) {
            int res;

            res = antena1.getRareza().compareTo(antena2.getRareza());

            if (res != 0){
                return res;
            }
            return antena1.getNombre().compareToIgnoreCase(antena2.getNombre());

        }
    };

    public static Comparator<Antena> comparadorPorPlataformaAntena = new Comparator<Antena>() {
        @Override
        public int compare(Antena antena1, Antena antena2) {
            int res;

            res = antena1.getPlataforma().compareTo(antena2.getPlataforma());

            if (res != 0){
                return res;
            }
            return antena1.getNombre().compareToIgnoreCase(antena2.getNombre());

        }
    };
    
}
