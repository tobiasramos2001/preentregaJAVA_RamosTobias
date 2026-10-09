package com.techlab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Categoria> categorias = new ArrayList<>();
        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        CrudCategorias crudCategorias =
            new CrudCategorias(categorias);

        CrudArticulos crudArticulos =
            new CrudArticulos(articulos, categorias);

        CrudPedidos crudPedidos =
            new CrudPedidos(pedidos, articulos);

        int opcion = -1;

        do {
            System.out.println("======= MENU PRINCIPAL =======");
            System.out.println("1) Gestionar categorias");
            System.out.println("2) Gestionar articulos");
            System.out.println("3) Gestionar pedidos");
            System.out.println("0) Salir");
            System.out.println("\nIndique la opcion requerida");

            opcion = ManejoExcepciones.leerEntero(sc);
            

            switch (opcion) {
                case 1:
                    crudCategorias.mostrarMenu(sc);
                    break;

                case 2:
                    System.out.println("Entrando al menu de articulos...");
                    crudArticulos.mostrarMenu(sc);
                    break;

                case 3:
                    crudPedidos.mostrarMenu(sc);
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
