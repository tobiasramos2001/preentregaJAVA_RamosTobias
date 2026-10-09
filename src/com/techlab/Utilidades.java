package com.techlab;

public class Utilidades {

    public static String formatearTexto(String texto) {
        // Quita espacios de los extremos y convierte todo a minúsculas
        texto = texto.trim().toLowerCase();
        // Separa el texto en palabras
        String[] palabras = texto.split(" ");
        // Acá vamos construyendo el resultado
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].isEmpty()) {
                // Primera letra en mayúscula
                String primeraLetra = palabras[i].substring(0, 1).toUpperCase();
                // Resto de la palabra
                String resto = palabras[i].substring(1);
                // Agregamos las dos partes
                sb.append(primeraLetra).append(resto);
                // Agregamos espacio excepto después de la última palabra
                if (i < palabras.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
