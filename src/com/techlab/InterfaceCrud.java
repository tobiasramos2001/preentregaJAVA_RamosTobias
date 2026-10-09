package com.techlab;

import java.util.Scanner;

public interface InterfaceCrud<T> {
    boolean crear(Scanner sc);
    void listar();
    boolean listar(int id);
    boolean eliminar(int id);
    boolean actualizar(Scanner sc);

    void mostrarMenu(Scanner sc);

}
