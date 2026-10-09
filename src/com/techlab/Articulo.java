package com.techlab;


public class Articulo extends Producto {

    private Categoria categoriaArticulo;

    // CONSTRUCTOR POR PARAMETROS
    public Articulo(String nombreProducto, double precioProducto, int stockProducto, Categoria categoriaArticulo) {
        super(nombreProducto, precioProducto, stockProducto);
        this.categoriaArticulo = categoriaArticulo;
    }

    // GETTER Y SETTER

    public Categoria getCategoriaArticulo() {
        return this.categoriaArticulo;
    }

    public void setCategoriaArticulo(Categoria categoriaArticuloNueva) {
        this.categoriaArticulo = categoriaArticuloNueva;
    }

    // METODO TO STRING

    @Override

    public String toString() {
        return super.toString() + " - Categoria: "
                + (categoriaArticulo != null ? categoriaArticulo.getnombreCategoria() + ")" : "Sin categoria asignada");
    }
}
