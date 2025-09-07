import Model.Facultad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Cargador {

    public static void cargarAlumnosDesdeArchivo(String rutaArchivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

            lineas.stream()
                  .map(linea -> linea.split(","))
                  .forEach(datos -> Facultad.getInstanciaFacultad()
                                             .agregarAlumno(
                                                 Integer.parseInt(datos[0].trim()), 
                                                 datos[1].trim()
                                             ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

