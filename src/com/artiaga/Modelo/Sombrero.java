package com.artiaga.Modelo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by artiaga on 6/3/17.
 */
public class Sombrero extends Item {

    //Constructor

    public Sombrero(String nombre, Rareza rareza, Plataforma plataforma) {
        super(nombre, rareza, plataforma);
    }

    //Metodos

    public static Comparator<Sombrero> comparadorPorNombreSombrero = new Comparator<Sombrero>() {
        @Override
        public int compare(Sombrero sombrero1, Sombrero sombrero2) {
            int res;

            res = sombrero1.getNombre().compareToIgnoreCase(sombrero2.getNombre());

            if (res != 0){
                return res;
            }
            return sombrero1.getRareza().compareTo(sombrero2.getRareza());
        }
    };

    public static Comparator<Sombrero> comparadorPorRarezaSombrero = new Comparator<Sombrero>() {
        @Override
        public int compare(Sombrero sombrero1, Sombrero sombrero2) {
            int res;

            res = sombrero1.getRareza().compareTo(sombrero2.getRareza());

            if (res != 0){
                return res;
            }
            return sombrero1.getNombre().compareToIgnoreCase(sombrero2.getNombre());

        }
    };

    public static Comparator<Sombrero> comparadorPorPlataformaSombrero = new Comparator<Sombrero>() {
        @Override
        public int compare(Sombrero sombrero1, Sombrero sombrero2) {
            int res;

            res = sombrero1.getPlataforma().compareTo(sombrero2.getPlataforma());

            if (res != 0){
                return res;
            }
            return sombrero1.getNombre().compareToIgnoreCase(sombrero2.getNombre());

        }
    };
}
