package ModuloPeaje.Dominio;

public enum Nacionalidad {
        NACIONAL(1),
        EXTRANJERO(2);

        private int id;
        Nacionalidad(int id) { this.id = id; }
        public int getId() { return id; }
    }
