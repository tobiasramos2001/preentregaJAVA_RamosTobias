package com.techlab;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudPedidos {

    private ArrayList<Pedido> pedidos;
    private ArrayList<Articulo> articulos;

    public CrudPedidos(ArrayList<Pedido> pedidos, ArrayList<Articulo> articulos) {
        this.pedidos = pedidos;
        this.articulos = articulos;
    }

    // METODO CREAR
    public boolean crear(Scanner sc) {
        if (articulos.isEmpty()) {
            System.out.println("No hay articulos disponibles para crear un pedido.");
            return true;
        }
        Pedido pedido = new Pedido();
        boolean continuar = true;
        boolean tieneLineas = false;
        while (continuar) {
            System.out.println("----- ARTICULOS DISPONIBLES -----");
            for (Articulo art : articulos) {
                System.out.println(art);
                System.out.println("Stock disponible: " + art.getStockProducto());
            }
            System.out.println("Ingrese el ID del articulo:");
            int idArticulo = ManejoExcepciones.leerEntero(sc);
            Articulo articuloSeleccionado = null;
            for (Articulo art : articulos) {
                if (art.getIdProducto() == idArticulo) {
                    articuloSeleccionado = art;
                    break;
                }
            }
            if (articuloSeleccionado == null) {
                System.out.println("No existe un articulo con ese ID.");
                continue;
            }
            System.out.println("Ingrese la cantidad deseada:");
            int cantidad = ManejoExcepciones.leerEntero(sc);
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                continue;
            } 
            // Contar unidades del mismo articulo ya agregadas
            int cantidadEnPedido = 0;
            for (LineaPedido linea : pedido.getLineas()) {
                if (linea.getArticulo().getIdProducto() == articuloSeleccionado.getIdProducto()) {
                    cantidadEnPedido += linea.getCantidad();
                }
            }
            if (cantidad + cantidadEnPedido > articuloSeleccionado.getStockProducto()) {
                System.out.println("Stock insuficiente para esa cantidad.");
                System.out.println("Stock disponible: " + (articuloSeleccionado.getStockProducto() - cantidadEnPedido));
                continue;
            }
            LineaPedido linea = new LineaPedido(articuloSeleccionado, cantidad);
            pedido.agregarLinea(linea);
            tieneLineas = true;
            System.out.println("Linea agregada correctamente.");
            System.out.println(linea);
            System.out.println("¿Desea agregar otro articulo? (1: Si / 0: No)");
            int opcion = ManejoExcepciones.leerEntero(sc);
            continuar = opcion == 1;
        }
        if (!tieneLineas) {
            System.out.println("No se agregaron articulos al pedido.");
            return true;
        }
        System.out.println("----- RESUMEN DEL PEDIDO -----");
        System.out.println("ID del pedido: " + pedido.getIdPedido());
        System.out.println(pedido);
        System.out.println("¿Confirma el pedido? (1: Si / 0: No)");
        int confirmar = ManejoExcepciones.leerEntero(sc);
        if (confirmar != 1) {
            System.out.println("Pedido cancelado.");
            return true;
        } 
        // Validar el stock 
        for (LineaPedido linea : pedido.getLineas()) {
            int cantidadTotal = 0;
            for (LineaPedido otra : pedido.getLineas()) {
                if (otra.getArticulo().getIdProducto() == linea.getArticulo().getIdProducto()) {
                    cantidadTotal += otra.getCantidad();
                }
            }
            if (cantidadTotal > linea.getArticulo().getStockProducto()) {
                System.out.println("Stock insuficiente para " + linea.getArticulo().getNombreProducto());
                System.out.println("No se confirmó el pedido.");
                return false;
            }
        } // Descontar stock 
        for (LineaPedido linea : pedido.getLineas()) {
            Articulo art = linea.getArticulo();
            art.setStockProducto(art.getStockProducto() - linea.getCantidad());
        }
        pedidos.add(pedido);
        System.out.println("Pedido confirmado correctamente.");
        return true;
    }

    // METODO LISTAR
    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("ID del pedido: " + pedido.getIdPedido());
            System.out.println(pedido);
            System.out.println("------------------------------");
        }
    }

    // METODO LISTAR POR ID
    public boolean listar(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                System.out.println(pedido);
                return true;
            }
        }

        System.out.println("No se encontró un pedido con ese ID.");
        return false;
    }

    // METODO MOSTRAR MENU
    public void mostrarMenu(Scanner sc) {
        int opcion = -1;
        boolean answer = false;

        do {
            System.out.println("\n------- MENU PEDIDOS -------");
            System.out.println("1) Crear pedido");
            System.out.println("2) Listar todos los pedidos");
            System.out.println("3) Buscar pedido por ID");
            System.out.println("0) Volver al menu principal");
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
                        System.out.println("Ingrese el ID del pedido:");
                        int id = ManejoExcepciones.leerEntero(sc);
                        answer = listar(id);
                    } while (answer == false);

                    break;

                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 0);
    }
}
