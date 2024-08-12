package examen1;

public final class BarcoPesquero extends Barco {
    private int pecesCapturados;
    private TipoPesquero tipoPesquero;

    public BarcoPesquero(String nombre, TipoPesquero tipoPesquero) {
        super(nombre);
        this.tipoPesquero = tipoPesquero;
        this.pecesCapturados = 0;
    }

    @Override
    public void agregarElemento(){
        pecesCapturados++;
    }

    @Override
    public double vaciarCobrar(){
        double total=pecesCapturados*tipoPesquero.price;
        pecesCapturados=0;
        return total;
    }

    @Override
    public double precioElemento(){
        return tipoPesquero.price;
    }

    @Override
    public String toString(){
        return super.toString()+"\nBarco pesquero de "+tipoPesquero+"\nCantidad de peces capturados: "+pecesCapturados;
    }
}
