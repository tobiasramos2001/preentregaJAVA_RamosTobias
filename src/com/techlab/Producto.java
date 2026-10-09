package com.techlab;

public abstract class Producto {

    // CONTADOR ID
    private static int contId = 0;

    // ATRIBUTOS
    private int idProducto;
    private String nombreProducto;
    private double precioProducto;
    private int stockProducto;

    // CONSTRUCTOR POR DEFECTO

    public Producto() {
        this.idProducto = ++contId;
        this.nombreProducto = "";
        this.precioProducto = 0;
        this.stockProducto = 0;
    }

    // CONSTRUCTOR POR PARAMETROS

    public Producto(String nombreProducto, double precioProducto, int stockProducto) {
        this.idProducto = ++contId;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
    }

    // METODOS GET Y SET
    // GET
    public int getIdProducto() {
        return this.idProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public double getPrecioProducto() {
        return this.precioProducto;
    }

    public int getStockProducto() {
        return this.stockProducto;
    }

    // SET

    public void setNombreProducto(String nombreProductoNuevo) {
        this.nombreProducto = nombreProductoNuevo;
    }

    public void setPrecioProducto(double precioProductoNuevo) {
        this.precioProducto = precioProductoNuevo;
    }

    public void setStockProducto(int stockProductoNuevo) {
        this.stockProducto = stockProductoNuevo;
    }

    // METODO toSting
    @Override
    public String toString() {
        return "Producto (ID: " + this.idProducto + " - Nombre: " + this.nombreProducto + " - Precio: $"
                + this.precioProducto + " - Stock: " + this.stockProducto;
    }
}
