package examen1;

public enum TipoPesquero{
    PEZ(50),CAMARON(125),LANGOSTA(200);

    public final double price;

    TipoPesquero(double price){
        this.price=price;
    }
}
