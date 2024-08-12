package examen1;

import javax.swing.*;

public class BarcoPasajero {
    private String[] pasajeros;
    private double precioBoleto;
    private int contadorPasajeros;

    public BarcoPasajero(int capacidadBarco,double precioBoleto) {
        this.pasajeros=new String[capacidadBarco];
        this.precioBoleto=precioBoleto;
        this.contadorPasajeros=0;
    }

    public void agregarElemento(){
        if(contadorPasajeros<pasajeros.length){
            String nombrePasajero=JOptionPane.showInputDialog(null, "Ingrese el nombre del pasajero: ");
            if (nombrePasajero!=null&&!nombrePasajero.isEmpty()){
                pasajeros[contadorPasajeros]=nombrePasajero;
                contadorPasajeros++;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay espacio en el barco");
        }
    }

    public double vaciarCobrar() {
        double totalGenerado=contadorPasajeros*precioBoleto;
        contadorPasajeros=0;
        return totalGenerado;
    }

    public double precioElemento(){
        return precioBoleto;
    }

    public String toString() {
        return super.toString()+"\nCantidad de Pasajeros que compraron boleto: #"+contadorPasajeros;
    }

    public void listarPasajeros(){
        if(contadorPasajeros==0){
            JOptionPane.showMessageDialog(null, "No hay pasajeros en el barco");
        }else{
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<contadorPasajeros;i++){
                sb.append(pasajeros[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null,sb.toString());
        }
    }
}

