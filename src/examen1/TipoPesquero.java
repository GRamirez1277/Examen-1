package examen1;

public enum TipoPesquero {
    PEZ(75),CAMARON(200),LANGOSTA(500);
    
    public final double price;
    TipoPesquero(double price){
        this.price=price;
        price=350;
    }
}
