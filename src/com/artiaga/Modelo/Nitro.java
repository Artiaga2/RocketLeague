package com.artiaga.Modelo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by artiaga on 6/3/17.
 */
public class Nitro extends Item {

    //Constructor

    public Nitro(String nombre, Rareza rareza, Plataforma plataforma) {
        super(nombre, rareza, plataforma);
    }

    //Metodos

    public static Comparator<Nitro> comparadorPorNombreNitro = new Comparator<Nitro>() {
        @Override
        public int compare(Nitro nitro1, Nitro nitro2) {
            int res;

            res = nitro1.getNombre().compareToIgnoreCase(nitro2.getNombre());

            if (res != 0){
                return res;
            }
            return nitro1.getRareza().compareTo(nitro2.getRareza());
        }
    };

    public static Comparator<Nitro> comparadorPorRarezaNitro = new Comparator<Nitro>() {
        @Override
        public int compare(Nitro nitro1, Nitro nitro2) {
            int res;

            res = nitro1.getRareza().compareTo(nitro2.getRareza());

            if (res != 0){
                return res;
            }
            return nitro1.getNombre().compareToIgnoreCase(nitro2.getNombre());

        }
    };

    public static Comparator<Nitro> comparadorPorPlataformaNitro = new Comparator<Nitro>() {
        @Override
        public int compare(Nitro nitro1, Nitro nitro2) {
            int res;

            res = nitro1.getPlataforma().compareTo(nitro2.getPlataforma());

            if (res != 0){
                return res;
            }
            return nitro1.getNombre().compareToIgnoreCase(nitro2.getNombre());

        }
    };
}
