package com.techlab;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudCategorias implements InterfaceCrud<Categoria> {

    private ArrayList<Categoria> categorias;

    // METODO CONSRUCTOR
    public CrudCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    // METODO CREAR
    @Override
    public boolean crear(Scanner sc) {

        System.out.println("Ingrese el nombre de la categoria: ");
        String nombreCategoria = Utilidades.formatearTexto(sc.nextLine());

        if (!nombreCategoria.isEmpty()) {
            Categoria nuevaCategoria = new Categoria(nombreCategoria);
            categorias.add(nuevaCategoria);
            System.out.println( nuevaCategoria.toString() + " creada con exito.");
            return true;
        } else {
            System.out.println("El nombre no puede estar vacio");
            return false;
        }
    }

    // METODO LISTAR CATEOGORIAS
    @Override
    public void listar() {
        for (Categoria cat : categorias) {
            System.out.println(cat.toString());
        }
    }

    // METODO LISTAR CATEGORIA POR ID
    @Override
    public boolean listar(int id) {
        for (Categoria cat : categorias) {
            if (cat.getIdCategoria() == id) {
                System.out.println(cat.toString());
                return true;
            }
        }
        System.out.println("Id de categoria inexistente");
        return false;
    }

    // METODO ELIMINAR CATEGORIA
    @Override
    public boolean eliminar(int id) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getIdCategoria() == id) {
                categorias.remove(i);
                System.out.println("Categoria eliminada con exito");
                return true;
            }
        }
        System.out.println("Id de categoria no encontrado");
        return false;
    }

    // METODO ACTUALIZAR CATEGORIA
    @Override
    public boolean actualizar(Scanner sc) {
        System.out.println("Ingrese el ID de la categoria a modificar");
        int idCat =ManejoExcepciones.leerEntero(sc);
        System.out.println("Ingrese el nuevo nombre de la categoria");
        String nuevoNombreCat = Utilidades.formatearTexto(sc.nextLine());

        if (!nuevoNombreCat.isEmpty()) {

            for (Categoria cat : categorias) {
                if (cat.getIdCategoria() == idCat) {
                    cat.setNombreCategoria(nuevoNombreCat);
                    System.out.println("Nombre de categoria actualizado con exito");
                    return true;
                }
            }

            System.out.println("Id de categoria no encontrado");
            return false;
        } else {
            System.out.println("El nombre de la categoria no puede estar vacio");
            return false;
        }
    }

    // METODO MOSTRAR MENU
    @Override
    public void mostrarMenu(Scanner sc) {

        int opcion = -1;
        boolean answer = false;
        do {
            System.out.println("\n-------MENU CATEGORIAS-------");
            System.out.println("1) Crear categoria");
            System.out.println("2) Listar categorias");
            System.out.println("3) Listar ID especifico de categoria");
            System.out.println("4) Eliminar categoria");
            System.out.println("5) Modificar categoria");
            System.out.println("0) Volver al menu anterior");
            System.out.println("\nIndique la opcion requerida");
            
            opcion = ManejoExcepciones.leerEntero(sc);

            switch (opcion) {
                case 1:

                    do {
                        answer = crear(sc);
                    } while (answer == false);

                    break;

                case 2:

                    listar();
                    break;

                case 3:

                    do {
                        System.out.println("Ingrese el ID de la categoria a listar: ");
                        int idListar =ManejoExcepciones.leerEntero(sc);
                        answer = listar(idListar);
                    } while (answer == false);

                    break;

                case 4:

                    do {
                        System.out.println("Ingrese el ID de categoria a eliminar: ");
                        int idEliminar =ManejoExcepciones.leerEntero(sc);
                        answer = eliminar(idEliminar);
                    } while (answer == false);

                    break;

                case 5:

                    do {
                        answer = actualizar(sc);
                    } while (answer == false);

                    break;

                case 0:
                    System.out.println("Volviendo al menu anterior....");

                    break;
                default:

                    System.out.println("Opcion invalida");
                    break;
            }

        } while (opcion != 0);
    }
}