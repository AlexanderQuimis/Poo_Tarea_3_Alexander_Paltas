package app;

import torneo.*;
import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("===== SORTEO DEL TORNEO DE FÚTBOL =====");

        EtapaTorneo etapa = null;

        while (etapa == null) {
            System.out.print("Ingrese la etapa (octavos, cuartos, semifinales, final): ");
            String etapaTexto = scanner.nextLine().trim();

            etapa = EtapaTorneo.desdeTexto(etapaTexto);

            if (etapa == null) {
                System.out.println("Etapa no válida. Intente nuevamente.\n");
            }
        }


        int n = etapa.getCantidadEquipos();
        List<Equipo> equipos = new ArrayList<>();

        System.out.println("\nIngrese los nombres de los " + n + " equipos:");
        for (int i = 1; i <= n; i++) {
            System.out.print("Equipo " + i + ": ");
            String nombre = scanner.nextLine();
            equipos.add(new Equipo(nombre));
        }

        Sorteo sorteador = new Sorteo();
        List<Partido> partidos = sorteador.sortear(equipos);

        System.out.println("\n=== Resultados del Sorteo: " + etapa.getNombre() + " ===");
        int contador = 1;
        for (Partido p : partidos) {
            System.out.println("Partido " + contador + ": " + p);
            contador++;
        }

        System.out.println("\n=========================================");
        System.out.println("SORTEO COMPLETADO");
        
        ResultadoArchivo archivo = new ResultadoArchivo("archivos/resultados_torneo.txt");

        archivo.guardarResultados(partidos, etapa.getNombre());

    }
    
}
