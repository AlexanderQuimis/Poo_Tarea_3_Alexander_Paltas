package torneo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultadoArchivo {

    private String nombreArchivo;


    public ResultadoArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarResultados(List<Partido> partidos, String etapa) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {

            writer.write("*************************************\n");
            writer.write("        RESULTADOS DEL SORTEO\n");
            writer.write("Etapa: " + etapa + "\n");
            writer.write("*************************************\n");

            int contador = 1;
            for (Partido p : partidos) {
                writer.write("Partido " + contador + ": ");
                writer.write(p.getEquipo1().getNombre() + " vs " + p.getEquipo2().getNombre() + "\n");
                contador++;
            }

            writer.write("\n\n");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
