package torneo;

public enum EtapaTorneo {
    OCTAVOS("Octavos de Final", 16),
    CUARTOS("Cuartos de Final", 8),
    SEMIFINAL("Semifinales", 4);

    private String nombre;
    private int cantidadEquipos;

    EtapaTorneo(String nombre, int cantidadEquipos) {
        this.nombre = nombre;
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public static EtapaTorneo desdeTexto(String texto) {
        texto = texto.toLowerCase();
        switch (texto) {
            case "octavos":
                return OCTAVOS;
            case "cuartos":
                return CUARTOS;
            case "semifinal":
            case "semifinales":
                return SEMIFINAL;
            default:
                return null;
        }
    }
}
