package com.techlab;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudArticulos implements InterfaceCrud<Articulo> {

    private ArrayList<Articulo> articulos;
    private ArrayList<Categoria> categorias;

    // METODO CONSTRUCTOR
    public CrudArticulos(ArrayList<Articulo> articulos, ArrayList<Categoria> categorias) {
        this.articulos = articulos;
        this.categorias = categorias;
    }

    // METODO CREAR ARTICULO
    public boolean crear(Scanner sc) {

        System.out.println("Ingrese el nombre del nuevo articulo");
        String nombreNuevoArt = Utilidades.formatearTexto(sc.nextLine());
        System.out.println("Ingres el precio del articulo");
        double precioNuevoArt = ManejoExcepciones.leerDecimal(sc);
        System.out.println("Ingrese el stock del articulo");
        int stockNuevoArt = ManejoExcepciones.leerEntero(sc);
        System.out.println("Ingrese un ID de categoria existente");
        int idCategoriaArt = ManejoExcepciones.leerEntero(sc);

        Categoria categoriaSeleccionada = null;
        for (Categoria cat : categorias) {
            if (cat.getIdCategoria() == idCategoriaArt) {
                categoriaSeleccionada = cat;
                break;
            }
        }

        if (categoriaSeleccionada == null) {
            System.out.println("ID de categoria ingresado inexistente");
            return false;
        }

        if (!nombreNuevoArt.isEmpty()) {
            Articulo nuevoArticulo = new Articulo(nombreNuevoArt, precioNuevoArt, stockNuevoArt, categoriaSeleccionada);
            articulos.add(nuevoArticulo);
            System.out.println(nuevoArticulo.toString() + " creado con exito");
            return true;
        } else {
            System.out.println("El nombre del articulo no puede estar vacio");
            return false;
        }
    }

    // METODO LISTAR ARTICULOS

    public void listar() {
        for (Articulo art : articulos) {
            System.out.println(art.toString());
        }
    }

    // METODO LISTAR ARIUCLO ID ESPECIFICO
    public boolean listar(int id) {

        for (Articulo art : articulos) {
            if (art.getIdProducto() == id) {
                System.out.println(art.toString());
                return true;
            }
        }

        System.out.println("Id de articulo inexistente");
        return false;
    }

    // METODO ELIMINAR ARTICULO
    public boolean eliminar(int id) {

        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getIdProducto() == id) {
                articulos.remove(i);
                System.out.println("Articulo eliminado con exito");
                return true;
            }
        }

        System.out.println("Id ingresado no existe");
        return false;
    }

    //METODO ACTULIZAR
    public boolean actualizar(Scanner sc) {

        System.out.println("Ingrese el ID del articulo a modificar");
        int idArt = ManejoExcepciones.leerEntero(sc);
        System.out.println("Ingrese el nombre nuevo");
        String nuevoNombreArt = sc.nextLine();
        System.out.println("Ingrese el precio nuevo del articulo");
        double nuevoPrecioArticulo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el stock nuevo del articulo");
        int nuevoStockaArticulo = ManejoExcepciones.leerEntero(sc);
        System.out.println("¿Desea modificar la categoria del articulo? (1. Si - 2. No)");
        int opcionCat = ManejoExcepciones.leerEntero(sc);

        if (opcionCat == 1) {
            System.out.println("Ingrese ID de categoria existente");
            int idCatNueva = ManejoExcepciones.leerEntero(sc);
            Categoria nuevCategoria = null;
            for (Categoria cat : categorias) {
                if (cat.getIdCategoria() == idCatNueva) {
                    nuevCategoria = cat;
                    break;
                }
            }
            if (nuevCategoria == null) {
                System.out.println("ID de categoria inexistente, no modifco el articulo");
                return false;
            }

            for (Articulo art : articulos) {
                if (art.getIdProducto() == idArt) {
                    art.setNombreProducto(nuevoNombreArt);
                    art.setPrecioProducto(nuevoPrecioArticulo);
                    art.setStockProducto(nuevoStockaArticulo);
                    art.setCategoriaArticulo(nuevCategoria);
                    System.out.println(art.toString() + " modificado con exito");
                    return true;
                }
            }
            System.out.println("ID de articulo especificado inexistente");
            return false;

        } else {

            for (Articulo art : articulos) {
                if (art.getIdProducto() == idArt) {
                    art.setNombreProducto(nuevoNombreArt);
                    art.setPrecioProducto(nuevoPrecioArticulo);
                    art.setStockProducto(nuevoStockaArticulo);
                    System.out.println(art.toString() + " modificado con exito");
                    return true;
                }
            }
            System.out.println("ID de articulo especificado inexistente");
            return false;
        }
    }

    //METODO MOSTRAR MENU
    public void mostrarMenu(Scanner sc){
        int opcion=-1;
        boolean answer=false;
        do{
            System.out.println("\n-------MENU ARTICULOS-------");
            System.out.println("1) Crear articulo");
            System.out.println("2) Listar articulos");
            System.out.println("3) Listar articulo ID especifico");
            System.out.println("4) Eliminar articulo");
            System.out.println("5) Modificar articulo");
            System.out.println("0) Volver al menu anterior");
            System.out.println("\nIndique la opcion requerida");

            opcion = ManejoExcepciones.leerEntero(sc);

            switch (opcion) {
                case 1:

                    do{
                        answer=crear(sc);
                    }while (answer==false);

                    break;

                case 2:

                    listar();
                    break;

                case 3:

                    do {
                        System.out.println("Ingrese ID de articulo a listar");
                        int idArt=ManejoExcepciones.leerEntero(sc);
                        answer=listar(idArt);
                    } while (answer==false);
                    break;

                case 4:

                do {
                    System.out.println("Ingrese ID de articulo a eliminar");
                    int idArt=ManejoExcepciones.leerEntero(sc);
                    answer=eliminar(idArt);
                } while (answer==false);

                break;

                case 5:

                do {
                    answer=actualizar(sc);
                } while (answer==false);

                break;

                case 0: 
                    System.out.println("Volviendo al menu anterior....");
                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcion!=0);
    }
}
