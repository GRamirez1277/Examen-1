package examen1;

import javax.swing.*;

public final class BarcoPasajero extends Barco{
    private String[] pasajeros;
    private double precioBoleto;
    private int contadorPasajeros;

    public BarcoPasajero(String nombre, int capacidadBarco,double precioBoleto){
        super(nombre);
        this.pasajeros=new String[capacidadBarco];
        this.precioBoleto=precioBoleto;
        this.contadorPasajeros=0;
    }

    @Override
    public void agregarElemento(){
        if (contadorPasajeros<pasajeros.length){
            String nombrePasajero=JOptionPane.showInputDialog(null, "Ingrese el nombre del pasajero: ");
            if(nombrePasajero!=null&&!nombrePasajero.isEmpty()){
                pasajeros[contadorPasajeros]=nombrePasajero;
                contadorPasajeros++;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay espacio en el barco");
        }
    }

    @Override
    public double vaciarCobrar(){
        double totalGenerado=contadorPasajeros*precioBoleto;
        contadorPasajeros=0;
        return totalGenerado;
    }

    @Override
    public double precioElemento(){
        return precioBoleto;
    }

    @Override
    public String toString(){
        return super.toString()+"\nCantidad de Pasajeros que compraron boleto: #"+contadorPasajeros;
    }

    public void listarPasajeros(){
        if(contadorPasajeros==0){
            JOptionPane.showMessageDialog(null, "No hay pasajeros en el barco");
        }else{
            listarPasajerosRecursivamente(0);
        }
    }

    private void listarPasajerosRecursivamente(int index){
        if(index<contadorPasajeros){
            JOptionPane.showMessageDialog(null, pasajeros[index]);
            listarPasajerosRecursivamente(index+1);
        }
    }
}
