import Model.Facultad;
import Model.Materia;
import Model.Carrera;

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

    public static void cargarMateriasDesdeArchivo(String rutaArchivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

            for (String linea : lineas) {
                String[] datos = linea.split(";");
                if (datos.length != 3) continue; // validar formato

                String nombre = datos[0].trim();
                Materia.Tipo tipo = Materia.Tipo.valueOf(datos[1].trim().toUpperCase());
                boolean tienePromocion = Boolean.parseBoolean(datos[2].trim());

                boolean agregado = Facultad.getInstanciaFacultad()
                        .nuevaMateria(nombre, tipo, tienePromocion);

                if (!agregado) {
                    System.out.println("La materia ya existe: " + nombre);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el formato del tipo de materia: " + e.getMessage());
        }
    }
    public static void cargarCarrerasDesdeArchivo(String rutaArchivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

            for (String linea : lineas) {
                String[] datos = linea.split(";");
                if (datos.length != 3) continue; // validar formato

                String nombre = datos[0].trim();
                int cantidadOptativas = Integer.parseInt(datos[1].trim());
                String tipoPlan = datos[2].trim().toUpperCase();

                Facultad.getInstanciaFacultad().agregarCarrera(nombre, cantidadOptativas, tipoPlan);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error en el número de optativas: " + e.getMessage());
        }
    }
    public static void cargarMateriasCarrera() {
        Facultad facultad = Facultad.getInstanciaFacultad();

        // Buscar la carrera existente
        Carrera carrera = facultad.getCarrerasMap().get("Ingeniería Informática");
        if (carrera == null) {
            System.out.println("La carrera Ingeniería Informática no existe");
            return;
        }

        // Listado de nombres de materias a agregar
        String[] nombresMaterias = {
                "Matemática1",
                "Matemática2",
                "Química",
                "Programación1",
                "Programación2"
        };

        // Buscar cada materia en la facultad y agregarla al plan de la carrera
        for (String nombreMateria : nombresMaterias) {
            Materia materiaEncontrada = null;

            // Buscar la materia en la facultad
            for (Materia m : facultad.getMaterias()) {
                if (m.getNombre().equalsIgnoreCase(nombreMateria)) {
                    materiaEncontrada = m;
                    break;
                }
            }

            if (materiaEncontrada != null) {
                // Determinar cuatrimestre
                int cuatrimestre = 1; // por defecto 1er cuatrimestre
                if (nombreMateria.equalsIgnoreCase("Matemática2") ||
                        nombreMateria.equalsIgnoreCase("Programación2")) {
                    cuatrimestre = 2; // 2do cuatrimestre
                }

                carrera.agregarMateriaAlPlan(materiaEncontrada, cuatrimestre);
                System.out.println("Materia agregada: " + nombreMateria + " (cuatrimestre " + cuatrimestre + ")");
            } else {
                System.out.println("Materia no encontrada en la facultad: " + nombreMateria);
            }
        }
    }
    public static void cargarCorrelativasCarrera() {
        Facultad facultad = Facultad.getInstanciaFacultad();

        // Buscar la carrera existente
        Carrera carrera = facultad.getCarrerasMap().get("Ingeniería Informática");
        if (carrera == null) {
            System.out.println("La carrera Ingeniería Informática no existe");
            return;
        }

        // Buscar las materias
        Materia matematica1 = null;
        Materia matematica2 = null;
        Materia programacion1 = null;
        Materia programacion2 = null;

        for (Materia m : facultad.getMaterias()) {
            if (m.getNombre().equalsIgnoreCase("Matemática1")) matematica1 = m;
            if (m.getNombre().equalsIgnoreCase("Matemática2")) matematica2 = m;
            if (m.getNombre().equalsIgnoreCase("Programación1")) programacion1 = m;
            if (m.getNombre().equalsIgnoreCase("Programación2")) programacion2 = m;
        }

        // Agregar correlativas
        if (matematica1 != null && matematica2 != null) {
            carrera.agregarCorrelativaMateria(matematica2, matematica1);
            List<Materia> correlativasMat2 = carrera.getPlan().getCorrelativas(matematica2);
            System.out.println("Correlativas de Matemática 2:");
            for (Materia corr : correlativasMat2) {
                System.out.println(" - " + corr.getNombre());
            }
        } else {

            System.out.println("No se pudieron agregar correlativas de Matemática");
        }

        if (programacion1 != null && programacion2 != null) {
            carrera.agregarCorrelativaMateria(programacion2, programacion1);
            List<Materia> correlativasMat2 = carrera.getPlan().getCorrelativas(programacion2);
            System.out.println("Correlativas de Programacion2:");
            for (Materia corr : correlativasMat2) {
                System.out.println(" - " + corr.getNombre());
            }
    }

}}
