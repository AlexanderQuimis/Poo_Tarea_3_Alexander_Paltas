package torneo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteo {

    private Random random = new Random();

    public List<Partido> sortear(List<Equipo> equipos) {
        List<Partido> partidos = new ArrayList<>();
        List<Equipo> equiposCopia = new ArrayList<>(equipos);

        sorteoRecursivo(equiposCopia, partidos);
        return partidos;
    }

    private void sorteoRecursivo(List<Equipo> equipos, List<Partido> partidos) {
        if (equipos.isEmpty()) {
            return; 
        }

        int i1 = random.nextInt(equipos.size());
        Equipo equipo1 = equipos.remove(i1);

        int i2 = random.nextInt(equipos.size());
        Equipo equipo2 = equipos.remove(i2);

        partidos.add(new Partido(equipo1, equipo2));

        sorteoRecursivo(equipos, partidos); 
    }
}

