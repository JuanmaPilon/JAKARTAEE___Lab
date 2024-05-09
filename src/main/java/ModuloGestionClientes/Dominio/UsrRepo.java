package ModuloGestionClientes.Dominio;

    public interface UsrRepo {
        /**
         * Devuelve el usuario asignado al vehiculo
         * @param tag
         * @return
         */
        public Usuario findByTag(int tag);
    }