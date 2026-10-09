package com.techlab;

public class LineaPedido {

    private Articulo articulo;
    private int cantidad;
    private double subtotal;

    //CONSTRUCTOR POR PARAMETROS
    public LineaPedido(Articulo articulo, int cantidad){
        this.articulo=articulo;
        this.cantidad=cantidad;
        this.subtotal=articulo.getPrecioProducto()*cantidad;
    }

    //METODO GET
    public Articulo getArticulo(){
        return this.articulo;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public double getSubtotal(){
        return this.subtotal;
    }


    //METODO TOSTRING
    @Override 
    public String toString(){
        return "Producto: " + this.articulo.getNombreProducto()
             + " | Precio: $" + this.articulo.getPrecioProducto() 
             + " | Cantidad: " + this.cantidad 
             + " | Subtotal: $" + this.subtotal; 
    }

}
