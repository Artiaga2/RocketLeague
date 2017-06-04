package com.artiaga.Modelo;


import java.util.Comparator;

/**
 * Created by artiaga on 6/3/17.
 */
public class Chasis extends Item{



    //Constructor

    public Chasis(String nombre, Rareza rareza, Plataforma plataforma) {
        super(nombre, rareza, plataforma);
    }

    //Metodos

    public static Comparator<Chasis> comparadorPorNombreChasis = new Comparator<Chasis>() {
        @Override
        public int compare(Chasis chasis1, Chasis chasis2) {
            int res;

            res = chasis1.getNombre().compareToIgnoreCase(chasis2.getNombre());

            if (res != 0){
                return res;
            }
            return chasis1.getRareza().compareTo(chasis2.getRareza());
        }
    };

    public static Comparator<Chasis> comparadorPorRarezaChasis = new Comparator<Chasis>() {
        @Override
        public int compare(Chasis chasis1, Chasis chasis2) {
            int res;

            res = chasis1.getRareza().compareTo(chasis2.getRareza());

            if (res != 0){
                return res;
            }
            return chasis1.getNombre().compareToIgnoreCase(chasis2.getNombre());

        }
    };

    public static Comparator<Chasis> comparadorPorPlataformaChasis = new Comparator<Chasis>() {
        @Override
        public int compare(Chasis chasis1, Chasis chasis2) {
            int res;

            res = chasis1.getPlataforma().compareTo(chasis2.getPlataforma());

            if (res != 0){
                return res;
            }
            return chasis1.getNombre().compareToIgnoreCase(chasis2.getNombre());

        }
    };

}
