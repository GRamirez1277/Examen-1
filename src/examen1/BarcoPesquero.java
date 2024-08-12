package examen1;

public class BarcoPesquero extends Barco {
    private int pecesCapturados;
    private TipoPesquero tipoPesquero;

    public BarcoPesquero(TipoPesquero tipoPesquero) {
        super("PESQUERO");
        pecesCapturados=0;
    }

    public void agregarElemento() {
        pecesCapturados++;
    }

    public double vaciarCobrar() {
        double total=pecesCapturados*tipoPesquero.price;
        pecesCapturados=0;
        return total;
    }

    public double precioElemento() {
        return tipoPesquero.price;
    }

    public String toString() {
        return "\nBarco Pesquero: "+tipoPesquero+"\nPeces Capturados: "+pecesCapturados;
    }
}
