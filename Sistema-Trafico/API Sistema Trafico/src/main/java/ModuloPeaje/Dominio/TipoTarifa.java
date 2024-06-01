package ModuloPeaje.Dominio;

public enum TipoTarifa {
    COMUN(1),
    PREFERENCIAL(2);

    private int id;
    TipoTarifa(int id) { this.id = id; }
    public int getId() { return id; }
}





