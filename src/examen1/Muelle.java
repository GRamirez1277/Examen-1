package examen1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Muelle {
    private ArrayList<Barco> barcos;

    public Muelle() {
        barcos=new ArrayList<>();
    }

    public static void main(String[] args) {
        Muelle muelle=new Muelle();

        JFrame frame=new JFrame("Muelle");
        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets=new Insets(10, 10, 10, 10);

        JButton btnAgregarBarco=new JButton("Agregar Barco");
        JButton btnAgregarElemento=new JButton("Agregar Elemento");
        JButton btnVaciarBarco=new JButton("Vaciar Barco");
        JButton btnBarcosDesde=new JButton("Barcos Desde");
        JButton btnSalir=new JButton("Salir");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(btnAgregarBarco, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(btnAgregarElemento, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        frame.add(btnVaciarBarco, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(btnBarcosDesde, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        frame.add(btnSalir, gbc);

        btnAgregarBarco.addActionListener(e -> {
            String tipoBarco = JOptionPane.showInputDialog("Ingrese el tipo de barco (Pesquero o Pasajero):");
            if (tipoBarco!=null) {
                muelle.agregarBarco(tipoBarco.toUpperCase());
            }
        });

        btnAgregarElemento.addActionListener(e -> {
            String nombreBarco=JOptionPane.showInputDialog("Ingrese el nombre del barco:");
            if(nombreBarco!=null){
                muelle.agregarElemento(nombreBarco);
            }
        });

        btnVaciarBarco.addActionListener(e -> {
            String nombreBarcoVaciar = JOptionPane.showInputDialog("Ingrese el nombre del barco:");
            if (nombreBarcoVaciar != null) {
                double total = muelle.vaciarBarco(nombreBarcoVaciar);
                JOptionPane.showMessageDialog(null, "Total generado: $" + total);
            }
        });

        btnBarcosDesde.addActionListener(e -> {
            String yearStr = JOptionPane.showInputDialog("Ingrese el año de circulación:");
            if (yearStr != null) {
                try {
                    int year = Integer.parseInt(yearStr);
                    muelle.barcosDesde(year);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Año no válido");
                }
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    public void agregarBarco(String tipo) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del barco:");
        if (nombre != null && !nombre.isEmpty()) {
            for (Barco barco : barcos) {
                if (barco.getNombre().equalsIgnoreCase(nombre)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un barco con ese nombre");
                    return;
                }
            }

            if (tipo.equals("PESQUERO")) {
                String[] tiposPesqueros = {"PEZ", "CAMARON", "LANGOSTA"};
                String tipoPesquero = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de pesquero:", "Tipo Pesquero", JOptionPane.QUESTION_MESSAGE, null, tiposPesqueros, tiposPesqueros[0]);
                if (tipoPesquero != null) {
                    barcos.add(new BarcoPesquero(nombre, TipoPesquero.valueOf(tipoPesquero)));
                    JOptionPane.showMessageDialog(null, "Barco agregado exitosamente");
                }
            } else if (tipo.equals("PASAJERO")) {
                String capacidadStr = JOptionPane.showInputDialog("Ingrese la capacidad del barco:");
                String precioBoletoStr = JOptionPane.showInputDialog("Ingrese el precio del boleto:");
                try {
                    int capacidad = Integer.parseInt(capacidadStr);
                    double precioBoleto = Double.parseDouble(precioBoletoStr);
                    barcos.add(new BarcoPasajero(nombre, capacidad, precioBoleto));
                    JOptionPane.showMessageDialog(null, "Barco agregado exitosamente");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Capacidad o precio inválido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de barco no válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre del barco no puede estar vacío");
        }
    }

    public void agregarElemento(String nombre) {
        for (Barco barco : barcos) {
            if (barco.getNombre().equalsIgnoreCase(nombre)) {
                barco.agregarElemento();
                JOptionPane.showMessageDialog(null, "Elemento agregado: "+nombre);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el barco");
    }

    public double vaciarBarco(String nombre) {
        for (Barco barco : barcos) {
            if (barco.getNombre().equalsIgnoreCase(nombre)) {
                double total = barco.vaciarCobrar();
                JOptionPane.showMessageDialog(null, barco.toString());
                if (barco instanceof BarcoPasajero) {
                    ((BarcoPasajero) barco).listarPasajeros();
                }
                return total;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el barco");
        return 0;
    }

    public void barcosDesde(int year) {
        listarBarcosDesdeRecursivo(year, 0);
    }

    private void listarBarcosDesdeRecursivo(int year, int index) {
        if (index < barcos.size()) {
            Barco barco = barcos.get(index);
            int barcoYear = barco.getCirculacion().get(Calendar.YEAR);
            if (barcoYear >= year) {
                JOptionPane.showMessageDialog(null, "Nombre del barco: " + barco.getNombre() + " - Fecha de circulación: " + barco.getCirculacion().getTime());
            }
            listarBarcosDesdeRecursivo(year, index + 1);
        }
    }
}
