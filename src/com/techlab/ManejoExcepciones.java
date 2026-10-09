package com.techlab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManejoExcepciones {

    public static int leerEntero(Scanner sc) {
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un numero entero.");
                sc.nextLine();
            }
        }
    }

    public static double leerDecimal(Scanner sc){
        while (true) {
            try {
                double numero= sc.nextDouble();
                sc.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un numero decimal.");
                sc.nextLine();
            }
        }
    }
}
