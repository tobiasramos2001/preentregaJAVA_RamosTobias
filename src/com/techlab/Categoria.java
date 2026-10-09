package com.techlab;

public class Categoria {

    // ATRIBUTOS
    private int idCategoria;
    private String nombreCategoria;

    private static int contId = 0;

    // CONSTRUCTOR POR DEFECTO
    public Categoria() {
        this.idCategoria = ++contId;
        this.nombreCategoria = "";

    }

    // CONSTRUCOR POR PARAMETROS
    public Categoria(String nombreCateoria) {
        this.idCategoria = ++contId;
        this.nombreCategoria = nombreCateoria;
    }

    // METODOS GET Y SET

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public String getnombreCategoria() {
        return this.nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoriaNuevo) {
        this.nombreCategoria = nombreCategoriaNuevo;
    }

    // METODO TO STRING
    @Override

    public String toString() {
        return "(Categoria: ID: " + this.idCategoria + " - Nombre: " + this.nombreCategoria + ")";
    }
}
