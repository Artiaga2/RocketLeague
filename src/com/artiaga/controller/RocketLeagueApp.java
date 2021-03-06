package com.artiaga.controller;

import com.artiaga.Modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class RocketLeagueApp {

    /**
     * Constantes y Variables
     */

    private ArrayList <Item> items;
    private ArrayList <Chasis> chasisArrayList;
    private ArrayList <Rueda> ruedas;
    private ArrayList <Nitro> nitros;
    private ArrayList <Antena> antenas;
    private ArrayList <Sombrero> sombreros;

    /**
     * Constructor
     */

    public RocketLeagueApp() {
        items = new ArrayList<>();
        chasisArrayList = new ArrayList<>();
        ruedas = new ArrayList<>();
        nitros = new ArrayList<>();
        antenas = new ArrayList<>();
        sombreros = new ArrayList<>();

//        loadChasis();
//        loadWhells();
//        loadBoosts();
//        loadAntenas();
//        loadSombreros();
//        guardarItems();
            loadItems();
    }

    /**
     * Funcion que se usa para guardar todos los objetos en un archivo .dat
     */
    public void guardarItems() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Objetos.dat"));
            oos.writeObject(chasisArrayList);
            oos.writeObject(ruedas);
            oos.writeObject(nitros);
            oos.writeObject(antenas);
            oos.writeObject(sombreros);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Funcion que se usa para cargar los objetos
     */
    public void loadItems() {
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("Objetos.dat"));
            chasisArrayList = (ArrayList<Chasis>)fichero.readObject();
            ruedas = (ArrayList<Rueda>)fichero.readObject();
            nitros = (ArrayList<Nitro>)fichero.readObject();
            antenas = (ArrayList<Antena>)fichero.readObject();
            sombreros = (ArrayList<Sombrero>)fichero.readObject();

            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para iniciar el programa.
     * Muestra las opciones a elegir y dependiendo de la opcion carga un tipo de ArrayList o nos permite agregar o eliminar items de cualquier ArrayList.
     */
    public void start() {
        int option;

        try {

        while ((option = showMenu()) != 0) {
            switch (option) {
                case 1:
                    showChasisList();
                    break;
                case 2:
                    showWhellsList();
                    break;
                case 3:
                    showBoostList();
                    break;
                case 4:
                    showAntenaList();
                    break;
                case 5:
                    showHatList();
                    break;
                case 6:
                    addItem(askItemInfo());
                    break;
                case 7:
                    deleteItem();
                    break;
                case 8:
                    ordenacionPorNombre();
                    break;

                case 9:
                    ordenacionPorRareza();
                    break;

                case 10:
                    ordenacionPorPlataforma();
                    break;

                case 11:
                    guardarItems();
                    break;

//                case 12:
//                    upgradeItem();
//
//                    break;

                 }
             }
        }catch (InputMismatchException e){

            System.out.println("Introduzca un numero de la Lista por favor");
            start();
        }
    }


    /**
     * Metodo para agregar un item al ArrayList(Según el tipo que elijamos) que tenemos instanciado por defecto en el programa.
     * @param item : El Item que queremos añadir
     */
    public void addItem(Item item) {


        if (item instanceof Chasis){
            chasisArrayList.add((Chasis) item);
        }

        else if (item instanceof Rueda){
            ruedas.add((Rueda) item);
        }

        else if (item instanceof Antena){
            antenas.add((Antena) item);
        }

        else if (item instanceof Nitro){
            nitros.add((Nitro) item);
        }

        else if (item instanceof Sombrero){
            sombreros.add((Sombrero) item);
        }

    }

    /**
     *Metodo para que el usuario ingrese por pantalla el item que quiere añadir (tipo, nombre, rareza y plataforma)
     * @return tipo: Devuelve el tipo de Arraylist dependiendo de lo que haya elegido el usuario (tipo, nombre, rareza y plataforma)
     */
    private Item askItemInfo() {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";
        Rareza rareza = Rareza.COMUN;
        Plataforma plataforma = Plataforma.TODAS;
        Item tipo = new Item(nombre, rareza , plataforma);
        int optionRareza = 0, optionPlataforma = 0, optionTipo = 0;


        do {
            System.out.println("Nombre del objeto: ");
            nombre = scanner.nextLine().trim().replaceAll("\\s+", " ");
        } while (nombre.equals(""));



            do {

                try {


                        System.out.println("Rareza ");
                    switch (optionRareza = showRareza()) {

                        case 1:
                            System.out.println("1 - Rareza Común");
                            rareza = Rareza.COMUN;
                            break;

                        case 2:
                            System.out.println("2 - Rareza  Premium");
                            rareza = Rareza.PREMIUM;
                            break;

                        case 3:
                            System.out.println("3 - Rareza  Limitado");
                            rareza = Rareza.LIMITADO;
                            break;

                        case 4:
                            System.out.println("4 - Rareza Raro");
                            rareza = Rareza.RARO;
                            break;

                        case 5:
                            System.out.println("5 - Rareza Muy Raro");
                            rareza = Rareza.MUYRARO;
                            break;

                        case 6:
                            System.out.println("6 - Rareza Importado");
                            rareza = Rareza.IMPORT;
                            break;

                        case 7:
                            System.out.println("7 - Rareza Exotico");
                            rareza = Rareza.EXOTICO;
                            break;

                        case 8:
                            System.out.println("8 - Rareza Poco común");
                            rareza = Rareza.POCOCOMUN;
                            break;

                        case 9:
                            System.out.println("9 - Super Raro");
                            rareza = Rareza.SUPERARO;
                            break;

                    }

                }catch (InputMismatchException e){
                    System.out.println("Rareza incorrecta. Vuelva a introducir la rareza por favor");

                }
            } while (optionRareza > 9 || optionRareza < 1 );






            do {

                try {

                System.out.println("Plataforma ");
                switch (optionPlataforma = showPlataforma()) {

                    case 1:
                        System.out.println("1 - Plataforma TODAS");
                        plataforma = Plataforma.TODAS;

                        break;

                    case 2:
                        System.out.println("2 - Plataforma PC");
                        plataforma = Plataforma.PC;
                        break;

                    case 3:
                        System.out.println("3 - Plataforma PLAY");
                        plataforma = Plataforma.PLAY;
                        break;

                    case 4:
                        System.out.println("4 - Plataforma XBOX");
                        plataforma = Plataforma.XBOX;
                        break;
                }

                }catch (InputMismatchException e){
                    System.out.println("Plataforma incorrecta. Vuelva a introducir la plataforma por favor");

                }

            }while (optionPlataforma > 4 || optionPlataforma < 1);



            do {

                try {


                switch (optionTipo = showTipo()) {
                    case 1:
                        tipo = new Chasis(nombre, rareza, plataforma);
                        break;
                    case 2:
                        tipo = new Rueda(nombre, rareza, plataforma);
                        break;
                    case 3:
                        tipo = new Nitro(nombre, rareza, plataforma);
                        break;
                    case 4:
                        tipo = new Antena(nombre, rareza, plataforma);
                        break;
                    case 5:
                        tipo = new Sombrero(nombre, rareza, plataforma);
                        break;
                    }

                }catch (InputMismatchException e){
                    System.out.println("Tipo incorrecto. Vuelva a introducir el tipo por favor.");

                }

            }while (optionTipo > 5 || optionTipo < 1 );


       return tipo;
        }

    /**
     * Metodo Menu que se le muestra por pantalla el usuario
     * @return Devuelve la opcion que el usuario ha elegido y la muestra por pantalla con el Metodo start
     */
    private int showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("************************************");
        System.out.println("* Introduzca un numero de la Lista *");
        System.out.println("* 1 - Ver Chasis                   *");
        System.out.println("* 2 - Ver Ruedas                   *");
        System.out.println("* 3 - Ver Nitros                   *");
        System.out.println("* 4 - Ver Antenas                  *");
        System.out.println("* 5 - Ver Sombreros                *");
        System.out.println("* 6 - Agregar Item                 *");
        System.out.println("* 7 - Borrar Item                  *");
        System.out.println("* 8 - Ordenacion por Nombre        *");
        System.out.println("* 9 - Ordenacion por Rareza        *");
        System.out.println("* 10 - Ordenacion por Plataforma   *");
        System.out.println("* 11 - Guardar Cambios             *");
//        System.out.println("* 12 - Actualizar Item             *");
        System.out.println("* 0 - Salir                        *");
        System.out.println("************************************");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;
    }

    public void ordenacionPorNombre() {


            switch (showTipo()) {
                case 1:
                    ordenarPorNombreChasis();
                    break;

                case 2:
                    ordenarPorNombreRueda();
                    break;

                case 3:
                    ordenarPorNombreNitro();
                    break;

                case 4:
                    ordenarPorNombreAntena();
                    break;

                case 5:
                    ordenarPorNombreSombrero();
                    break;
            }
        }

    public void ordenacionPorRareza() {

            switch (showTipo()) {
                case 1:
                    ordenarPorRarezaChasis();
                    break;

                case 2:
                    ordenarPorRarezaRueda();
                    break;

                case 3:
                    ordenarPorRarezaNitro();
                    break;

                case 4:
                    ordenarPorRarezaeAntena();
                    break;

                case 5:
                    ordenarPorRarezaSombrero();
                    break;
            }
        }

    public void ordenacionPorPlataforma() {


            switch (showTipo()) {
                case 1:
                    ordenarPorPlataformaChasis();
                    break;

                case 2:
                    ordenarPorPlataformaRueda();
                    break;

                case 3:
                    ordenarPorPlataformaNitro();
                    break;

                case 4:
                    ordenarPorPlataformaAntena();
                    break;

                case 5:
                    ordenarPorPlataformaSombrero();
                    break;
            }
        }


    /**
     * Metodo tipo menu que se le muestra por pantalla al usuario para poder elegir el tipo en la funcion askItemInfo.
     * @return devuelve el tipo que el usuario ha elegido para que se cambie el tipo por defecto (Item) en la funcion askItemInfo
     */
    private int showTipo(){

        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("*      Elige un Tipo       *");
        System.out.println("****************************");
        System.out.println("* 1 -  Chasis              *");
        System.out.println("* 2 -  Rueda               *");
        System.out.println("* 3 -  Nitro               *");
        System.out.println("* 4 -  Antena              *");
        System.out.println("* 5 -  Sombrero            *");
        System.out.println("****************************");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;
    }

    /**
     * Metodo tipo menu que se le muestra por pantalla al usuario para poder elegir la rareza en la funcion askItemInfo.
     * @return devuelve la rareza que el usuario ha elegido para que se cambie la rareza por defecto (Rareza.COMUN) en la funcion askItemInfo
     */
    private int showRareza (){

        Scanner scanner = new Scanner(System.in);
        int option;


        System.out.println("****************************");
        System.out.println("* 1 - Comun                *");
        System.out.println("* 2 - Premium              *");
        System.out.println("* 3 - Limitado             *");
        System.out.println("* 4 - Raro                 *");
        System.out.println("* 5 - Muy Raro             *");
        System.out.println("* 6 - Importado            *");
        System.out.println("* 7 - Exotico              *");
        System.out.println("* 8 - Poco comun           *");
        System.out.println("* 9 - Super Raro           *");
        System.out.println("****************************");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;

    }

    /**
     * Metodo tipo menu que se le muestra por pantalla al usuario para poder elegir la plataforma en la funcion askItemInfo.
     * @return devuelve la plataforma que el usuario ha elegido para que se cambie la plataforma por defecto (Plataforma.TODAS) en la funcion askItemInfo
     */
    private int showPlataforma (){

        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("****************************");
        System.out.println("* 1 - TODAS                *");
        System.out.println("* 2 - PC                   *");
        System.out.println("* 3 - PLAY                 *");
        System.out.println("* 4 - XBOX                 *");
        System.out.println("****************************");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;
    }

    /**
     * Muestra el ArrayList de Chasis ordenado por un indice
     */
    private void showChasisList(){

        int index = 0;

        for (Chasis chasis: chasisArrayList) {
            System.out.println((index++) + "- " + chasis);

        }
    }

    /**
     * Muestra el ArrayList de Rueda ordenado por un indice
     */
    private void showWhellsList(){

        int index = 0;

        for (Rueda rueda: ruedas) {
            System.out.println((index++) + "- " + rueda);

        }
    }

    /**
     * Muestra el ArrayList de Antena ordenado por un indice
     */
    private void showAntenaList(){

        int index = 0;

        for (Antena antena: antenas) {
            System.out.println((index++) + "- " + antena);

        }
    }

    /**
     * Muestra el ArrayList de Nitro ordenado por un indice
     */
    private void showBoostList(){

        int index = 0;

        for (Nitro nitro: nitros) {
            System.out.println((index++) + "- " + nitro);

        }
    }

    /**
     * Muestra el ArrayList de Sombrero ordenado por un indice
     */
    private void showHatList(){

        int index = 0;

        for (Sombrero sombrero: sombreros) {
            System.out.println((index++) + "- " + sombrero);

        }
    }


    /**
     * Funcion para ordenar los Chasis por nombre
     */
    private void ordenarPorNombreChasis(){
        Collections.sort(chasisArrayList, Chasis.comparadorPorNombreChasis);
        int index = 0;
        for (Chasis chasis : chasisArrayList)
        {
            System.out.println((index++) + "- " + chasis);
        }
    }

    /**
     * Funcion para ordenar los Chasis por Rareza
     */
    private void ordenarPorRarezaChasis(){
        Collections.sort(chasisArrayList, Chasis.comparadorPorRarezaChasis);
        int index = 0;
        for (Chasis chasis : chasisArrayList)
        {
            System.out.println((index++) + "- " + chasis);
        }
    }

    /**
     * Funcion para ordenar los Chasis por plataforma
     */
    private void ordenarPorPlataformaChasis(){
        Collections.sort(chasisArrayList, Chasis.comparadorPorPlataformaChasis);
        int index = 0;
        for (Chasis chasis : chasisArrayList)
        {
            System.out.println((index++) + "- " + chasis);
        }
    }

    private void ordenarPorNombreRueda(){
        Collections.sort(ruedas, Rueda.comparadorPorNombreRueda);
        int index = 0;
        for (Rueda rueda : ruedas)
        {
            System.out.println((index++) + "- " + rueda);
        }
    }

    private void ordenarPorRarezaRueda(){
        Collections.sort(ruedas, Rueda.comparadorPorRarezaRueda);
        int index = 0;
        for (Rueda rueda : ruedas)
        {
            System.out.println((index++) + "- " + rueda);
        }
    }

    private void ordenarPorPlataformaRueda(){
        Collections.sort(ruedas, Rueda.comparadorPorPlataformaRueda);
        int index = 0;
        for (Rueda rueda : ruedas)
        {
            System.out.println((index++) + "- " + rueda);
        }
    }

    private void ordenarPorNombreNitro(){
        Collections.sort(nitros, Nitro.comparadorPorNombreNitro);
        int index = 0;
        for (Nitro nitro : nitros)
        {
            System.out.println((index++) + "- " + nitro);
        }
    }

    private void ordenarPorRarezaNitro(){
        Collections.sort(nitros, Nitro.comparadorPorRarezaNitro);
        int index = 0;
        for (Nitro nitro : nitros)
        {
            System.out.println((index++) + "- " + nitro);
        }
    }

    private void ordenarPorPlataformaNitro(){
        Collections.sort(nitros, Nitro.comparadorPorPlataformaNitro);
        int index = 0;
        for (Nitro nitro : nitros)
        {
            System.out.println((index++) + "- " + nitro);
        }
    }

    private void ordenarPorNombreAntena(){
        Collections.sort(antenas, Antena.comparadorPorNombreAntena);
        int index = 0;
        for (Antena antena : antenas)
        {
            System.out.println((index++) + "- " + antena);
        }
    }

    private void ordenarPorRarezaeAntena(){
        Collections.sort(antenas, Antena.comparadorPorRarezaAntena);
        int index = 0;
        for (Antena antena : antenas)
        {
            System.out.println((index++) + "- " + antena);
        }
    }

    private void ordenarPorPlataformaAntena(){
        Collections.sort(antenas, Antena.comparadorPorPlataformaAntena);
        int index = 0;
        for (Antena antena : antenas)
        {
            System.out.println((index++) + "- " + antena);
        }
    }

    private void ordenarPorNombreSombrero(){
        Collections.sort(sombreros, Sombrero.comparadorPorNombreSombrero);
        int index = 0;
        for (Sombrero sombrero : sombreros)
        {
            System.out.println((index++) + "- " + sombrero);
        }
    }

    private void ordenarPorRarezaSombrero(){
        Collections.sort(sombreros, Sombrero.comparadorPorRarezaSombrero);
        int index = 0;
        for (Sombrero sombrero : sombreros)
        {
            System.out.println((index++) + "- " + sombrero);
        }
    }

    private void ordenarPorPlataformaSombrero(){
        Collections.sort(sombreros, Sombrero.comparadorPorPlataformaSombrero);
        int index = 0;
        for (Sombrero sombrero : sombreros)
        {
            System.out.println((index++) + "- " + sombrero);
        }
    }

//    public void modifyChasis(String nombre, Rareza rareza, Plataforma plataforma, int index) {
//        chasisArrayList.get(index).setNombre(nombre);
//        chasisArrayList.get(index).setRareza(rareza);
//        chasisArrayList.get(index).setPlataforma(plataforma);
//    }

//    public void upgradeItem() {
//        Scanner input = new Scanner(System.in);
//        String nombre = "";
//        Rareza rareza = Rareza.COMUN;
//        Plataforma plataforma = Plataforma.TODAS;
//        Item item;
//        Chasis chasis = null;
//        int index;
//
//
//        try {
//
//            switch (showTipo()) {
//
//                case 1:
//                    showChasisList();
//
//                    do {
//
//
//                        System.out.println("Introducir el indice: ");
//
//                        index = input.nextInt();
//
//                    } while (!correctIndexChasis(index));
//
//                    item = askItemInfo();
//                    items.set(index, item);
//                    addItem(item);
//

//
//                    break;
//
//                case 2:
//                    showWhellsList();
//                    do {
//
//                        System.out.println("Introducir el indice: ");
//
//                        index = input.nextInt();
//
//                    } while (!correctIndexRueda(index));
//
//                    item = (ArrayList<Item>) (ArrayList<?>) ruedas;
//                    item.remove(index);
//
//                    break;
//
//                case 3:
//
//                    showBoostList();
//                    do {
//
//                        System.out.println("Introducir el indice: ");
//
//                        index = input.nextInt();
//
//                    } while (!correctIndexNitro(index));
//
//                    item = (ArrayList<Item>) (ArrayList<?>) nitros;
//
//                    break;
//
//                case 4:
//                    showAntenaList();
//                    do {
//
//                        System.out.println("Introducir el indice: ");
//
//                        index = input.nextInt();
//
//                    } while (!correctIndexAntena(index));
//
//
//                    item = (ArrayList<Item>) (ArrayList<?>) antenas;
//
//                    break;
//
//                case 5:
//                    showHatList();
//
//                    do {
//
//                        System.out.println("Introducir el indice: ");
//
//                        index = input.nextInt();
//
//                    } while (!correctIndexSombrero(index));
//
//                    item = (ArrayList<Item>) (ArrayList<?>) sombreros;
//
//                    break;
//
//            }
//
//        }catch (InputMismatchException e){
//            System.out.println("Introduzca el indice correcto por favor");
//            upgradeItem();
//        }
//    }

    /**
     * Funcion que se usa para Borrar el item que el usuario ha introducido por pantalla
     * La funcion le muestra por pantalla al usuario el tipo que desea borrar, una vez que el usuario ha elegido el tipo
     * se le muestra por pantalla el ArrayList del tipo que ha elegido ordenados por un indice.
     *Por ultimo se le pide al usuario que ingrese por pantalla el indice del objeto que desea eliminar.
     */
    public void deleteItem(){


        Scanner input = new Scanner(System.in);

        ArrayList<Item> item;
        int index;


        try {

            switch (showTipo()) {

                case 1:
                    showChasisList();


                    do {

                        System.out.println("Introducir el indice: ");

                        index = input.nextInt();

                    } while (!correctIndexChasis(index));

                    item = (ArrayList<Item>) (ArrayList<?>) chasisArrayList;
                    item.remove(index);
                    break;

                case 2:
                    showWhellsList();
                    do {

                        System.out.println("Introducir el indice: ");

                        index = input.nextInt();

                    } while (!correctIndexRueda(index));

                    item = (ArrayList<Item>) (ArrayList<?>) ruedas;
                    item.remove(index);
                    break;

                case 3:

                    showBoostList();
                    do {

                        System.out.println("Introducir el indice: ");

                        index = input.nextInt();

                    } while (!correctIndexNitro(index));

                    item = (ArrayList<Item>) (ArrayList<?>) nitros;
                    item.remove(index);
                    break;

                case 4:
                    showAntenaList();
                    do {

                        System.out.println("Introducir el indice: ");

                        index = input.nextInt();

                    } while (!correctIndexAntena(index));


                    item = (ArrayList<Item>) (ArrayList<?>) antenas;
                    item.remove(index);
                    break;

                case 5:
                    showHatList();

                    do {

                        System.out.println("Introducir el indice: ");

                        index = input.nextInt();

                    } while (!correctIndexSombrero(index));

                    item = (ArrayList<Item>) (ArrayList<?>) sombreros;
                    item.remove(index);
                    break;
            }

        }catch (InputMismatchException e){
            System.out.println("Introduzca el indice correcto por favor");
            deleteItem();
        }
    }

    /**
     * Funcion que al pasarle el parametro index nos devuelve un true o false dependiendo
     * de si es mayor que 0 y menos que el tamaño del array
     * @param index parametro que mete el usuario en la funcion deleteItems()
     * @return
     */
    public boolean correctIndexChasis (int index){

        if(index >=0  && index < chasisArrayList.size() ){
            return true;
        }else{
            return false;
        }
    }

    public boolean correctIndexRueda (int index){

        if(index >=0  && index < ruedas.size() ){
            return true;
        }else{
            return false;
        }
    }

    public boolean correctIndexNitro (int index){

        if(index >=0  && index < nitros.size() ){
            return true;
        }else{
            return false;
        }
    }

    public boolean correctIndexAntena (int index){

        if(index >=0  && index < antenas.size() ){
            return true;
        }else{
            return false;
        }
    }

    public boolean correctIndexSombrero (int index){

        if(index >=0  && index < sombreros.size() ){
            return true;
        }else{
            return false;
        }
    }



//    private void loadChasis(){
//
//
//        chasisArrayList.add(new Chasis("OCTANE", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("SWEET TOOTH", Rareza.COMUN, Plataforma.PLAY));
//        chasisArrayList.add(new Chasis("BACKFIRE", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("BREAKOUT", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("GIZMO", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("HOTSHOT", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("MERC", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("PALADIN", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ROAD HOG", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("VENOM", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("X-DEVIL", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("TAKUMI", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("DOMINUS", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("SCARAB", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ZYPPY", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("DELOREAN TIME MACHINE", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("GROG", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("RIPPER", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("BATMOBILE", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("AFFTERSHOCK", Rareza.COMUN, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("MARAUDER", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("MASAMUNE", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ESPER", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("PROTEUS", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("TRITON", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("VULVAN", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("DOMINUS GT", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ROAD HOG XL", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("TAKUMI RX-T", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("X-DEVIL MK2", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("BREAKOUT TYPE-S", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("OCTANE ZSR", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("TWIN MILL III", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("BONE SHAKER", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ENDO", Rareza.IMPORT, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("ICE CHARGER", Rareza.PREMIUM, Plataforma.TODAS));
//        chasisArrayList.add(new Chasis("MANTIS", Rareza.IMPORT, Plataforma.TODAS));
//    }
//
//    private void loadWhells() {
//
//        ruedas.add(new Rueda("ALCHEMIST",Rareza.COMUN,Plataforma.TODAS));
//        ruedas.add(new Rueda("ALMAS",Rareza.COMUN,Plataforma.TODAS));
//        ruedas.add(new Rueda("BENDER", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("DIECI", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("FALCO", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("FOREMAN", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("INVADER", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("LOWRIDER", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("LUCCI", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("MOUNTAINEER", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("NEPTUNE", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("OCTAVIAN", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("OEM", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("RAT ROD", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("SPYDER", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("STALLION", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("STERN", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("SUNDBURST", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("TEMPEST", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("TOMAHAWK", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("TRAHERE", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("TUNICA", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("VELOCE", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("VORTEX", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("GOLDESTONE", Rareza.LIMITADO, Plataforma.PC));
//        ruedas.add(new Rueda("SWEET TOOTH", Rareza.COMUN, Plataforma.PLAY));
//        ruedas.add(new Rueda("SERVERGATE", Rareza.COMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("CRISTIANO", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("SPINNER", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("ZYPPY", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Scarab", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Carriage", Rareza.LIMITADO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Grog", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Ripper", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Batmobile", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("DeLorean Time Machine", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Aftershock", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Marauder", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Masamune", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Esper", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Chakram", Rareza.MUYRARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Photon", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Looper", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Lobo", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Voltaic", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Triton", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Rhino 2", Rareza.POCOCOMUN, Plataforma.TODAS));
//        ruedas.add(new Rueda("Troika", Rareza.MUYRARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Discotheque", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Pulsus", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Asterias", Rareza.RARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Zeta", Rareza.RARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Proteus", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Vulcan", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Spiralis", Rareza.MUYRARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("FSL", Rareza.IMPORT, Plataforma.TODAS));
//        ruedas.add(new Rueda("Zomba", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("ARA-51", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("WW5SP", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("OH5", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Kalos", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Season 3 - Prospect", Rareza.LIMITADO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Season 3 - Challenger", Rareza.LIMITADO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Season 3 - Star", Rareza.LIMITADO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Season 3 - Champion", Rareza.LIMITADO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Septem", Rareza.MUYRARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Roulette", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Ice Charger", Rareza.PREMIUM, Plataforma.TODAS));
//        ruedas.add(new Rueda("Fireplug", Rareza.MUYRARO, Plataforma.TODAS));
//        ruedas.add(new Rueda("Triplex", Rareza.IMPORT, Plataforma.TODAS));
//        ruedas.add(new Rueda("Draco", Rareza.EXOTICO, Plataforma.TODAS));
//        ruedas.add(new Rueda("K2", Rareza.EXOTICO, Plataforma.TODAS));
//    }
//
//    private void loadBoosts (){
//
//        nitros.add(new Nitro("Confetti", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Datastream", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower Blue", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower Green", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower Purple", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower Red", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flowers", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Gold Rush (Alpha Reward)", Rareza.LIMITADO, Plataforma.PC));
//        nitros.add(new Nitro("Grass", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Hydro", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Blue", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Green", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Pink", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Purple", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Red", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Ion Yellow", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Money", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Plasma", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Rainbow", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Sacred", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Slime", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Snowflakes", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Sparkles", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Standard Blue", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Standard Pink", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Standard Purple", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Standard Red", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Standard Yellow", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal Blue", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal Green", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal Pink", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal Purple", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Thermal Yellow", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Bubbles", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Flamethrower Pink", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Nitrous", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Burnout", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Accelerato", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Battle-Stars", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Candy Corn", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Nuts & Bolts", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Sandstorm", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Portal - Conversion Gel", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Portal - Propulsion Gel", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Portal - Repulsion Gel", Rareza.COMUN, Plataforma.TODAS));
//        nitros.add(new Nitro("Xmas", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Batmobile", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("OutaTime", Rareza.PREMIUM, Plataforma.TODAS));
//        nitros.add(new Nitro("Season 2 - Challenger", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Season 2 - Prospect", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Season 2 - Star", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Season 2 - Champion", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Toon Smoke", Rareza.SUPERARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Frostbite", Rareza.SUPERARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Hearts", Rareza.SUPERARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Lightning", Rareza.SUPERARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Polygonal", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Pixel Fire", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Trinity", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Dark Matter", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Hypernova", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Ink", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Treasure", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Netherworld", Rareza.LIMITADO, Plataforma.TODAS));
//        nitros.add(new Nitro("Proton", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Lightning Yellow", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Xenosplash", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Tachyon", Rareza.IMPORT, Plataforma.TODAS));
//        nitros.add(new Nitro("Hexphase", Rareza.MUYRARO, Plataforma.TODAS));
//        nitros.add(new Nitro("Neo-Thermal", Rareza.IMPORT, Plataforma.TODAS));
//    }
//
//   private void loadAntenas (){
//
//       antenas.add(new Antena("8-Ball", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Blacklight: Retribution", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Blue Chequered Flag", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Camo Flag", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Chroma", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Dollar Sign", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Edge of Space", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Excalibur", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Fenix Rage", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Gingerbread Man", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Gold Nugget (Beta Reward)", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Heart", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Horseshoe", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Jolly Roger", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Lightning Bolt", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Loki", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Peace", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Safety Flag", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Saturn", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Shadowgate", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Skull", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Smiley", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Snowman", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Soccer Ball", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Star", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Strike Vector EX", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Team Fat", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Tennis Ball", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Twitch", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("UFO", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Unreal", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Warframe", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Country Flags", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Blacklight", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Sweet Tooth", Rareza.COMUN, Plataforma.PLAY));
//       antenas.add(new Antena("White Flag", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Disconnect", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Chivalry - Agatha Knights", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Chivalry - Mason Order", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Retro Ball - Urban", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Retro Ball - Utopia", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Calavera", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Dave's Bread", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Fuzzy Brute", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Fuzzy Vamp", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Reddit Snoo", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("The Game Awards - Statue", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Nosgoth - Human", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Nosgoth - Vampire", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Nosgoth", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Oddworld - Necrum", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Unreal Tournament", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Bomb Pole", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Radioactive", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Retro Ball - Wasteland", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("RL Garage", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Candy Cane", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Holiday Gift", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Portal - Companion Cube", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Portal - PotatOS", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Rainbow Flag", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Waffle", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Rubber Duckie", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Rocket", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Piñata", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Parrot", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Moai", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("deadmau5", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Hula Girl", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Genie Lamp", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Foam Finger", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Venus Flytrap", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Sunflower", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Rose", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Donut", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Unreal Tournament - Flak Shell", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Balloon Dog", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Disco Ball", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Cupcake", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Chick Magnet", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Candle", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Alien", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Batman", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Superman", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("Wonder Woman", Rareza.PREMIUM, Plataforma.TODAS));
//       antenas.add(new Antena("9GAG", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("DIV", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Wakeup Ship", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Discord", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("PAX", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Penny Arcade", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("ScrewAttack!", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Harpoon", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Seastar", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Trident", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Fuzzy Skull", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Nutcracker", Rareza.LIMITADO, Plataforma.TODAS));
//       antenas.add(new Antena("Satellite", Rareza.POCOCOMUN, Plataforma.TODAS));
//       antenas.add(new Antena("NoClip", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("NZXT", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("SDMN FC", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Vikkstar", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("RLCS", Rareza.COMUN, Plataforma.TODAS));
//       antenas.add(new Antena("Easter Egg", Rareza.LIMITADO, Plataforma.TODAS));
//   }
//
//   private void loadSombreros (){
//
//       sombreros.add(new Sombrero("Bobby Helmet", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Brünnehilde", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Cherry Top", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Devil Horns", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Fez", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Fire Helmet", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Gold Cap (Alpha Reward)", Rareza.LIMITADO, Plataforma.PC));
//       sombreros.add(new Sombrero("Halo", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Hard Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Mariachi Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pirate's Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pizza Topper", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Propellerhead", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Royal Crown", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Sombrero", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Taxi Topper", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Top Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Witch's Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Wizard Hat", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Cavalier", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Locomotive", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pixelated Shades", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Shark Fin", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pumpkin", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Boombox", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Cow Skull", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Mohawk", Rareza.PREMIUM, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Portal - Cake", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Blitzen", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Christmas Tree", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Sad Sapling", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Santa", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Unicorn", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Traffic Cone", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Tiara", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Shuriken", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Rhino Horns", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Mouse Trap", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Rasta", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Police Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Plunger", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Paper Boat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Graduation Cap", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Bowler", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Fruit Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Brodie Helmet", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Homburg", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Derby", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Deerstalker", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("deadmau5", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Cockroach", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Chef's Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Chainsaw", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Captain's Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Work Boot", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Birthday Cake", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Biker Cap", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Beret", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Antlers", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Season 1 - Bronze", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Season 1 - Silver", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Season 1 - Gold", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Season 1 - Platinum", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("ROBO-Visor", Rareza.RARO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Wildcat Ears", Rareza.RARO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Drink Helmet", Rareza.RARO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pigeon", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Little Bow", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Cattleman", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Pork Pie", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Ivy Cap", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Light Bulb", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Party Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Trucker Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Visor", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("White Hat", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Baseball Cap [F]", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Baseball Cap [B]", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Day Of The Tentacle", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Foam Hat", Rareza.POCOCOMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Clamshell", Rareza.RARO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Bone King", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Ghost", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Helper Elf", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("New Year's 2017", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("SharkBite", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Hot Wheels", Rareza.COMUN, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Bunny Ears", Rareza.LIMITADO, Plataforma.TODAS));
//       sombreros.add(new Sombrero("Easter Basket", Rareza.LIMITADO, Plataforma.TODAS));
//
//   }

}
