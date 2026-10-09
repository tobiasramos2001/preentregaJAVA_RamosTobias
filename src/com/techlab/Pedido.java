package com.techlab;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<LineaPedido> lineas;
    private int idPedido;
    private static int contId=0;

    //METODO CONSTRUCTOR POR PARAMETROS
    public Pedido(){
        this.idPedido= ++contId;
        this.lineas=new ArrayList<>();
    }

    //METODOS GET
    public int getIdPedido(){
        return this.idPedido;
    }

    public ArrayList<LineaPedido> getLineas(){
        return lineas;
    }
    //METODO AGREGAR LINEA PEDIDO
    public void agregarLinea(LineaPedido linea){
        this.lineas.add(linea);
    }

    //METODO CALCULO TOTAL
    public double calcularTotal(){
        double total=0;

        for (LineaPedido linea : lineas) {

            total+=linea.getSubtotal();
            
        }

        return total;
    }

    //METODO TO STRING
    @Override 
    public String toString(){
        return lineas.toString() 
             + " Total: $" + calcularTotal();
    }
}
