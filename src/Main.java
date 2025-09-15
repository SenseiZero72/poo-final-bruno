import View.Componentes.Ventana;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/alumnos.txt";
        Cargador.cargarAlumnosDesdeArchivo(rutaArchivo);
        String rutaArchivoMateria = "src/materias.txt";
        Cargador.cargarMateriasDesdeArchivo(rutaArchivoMateria);
        String rutaArchivoCarrera = "src/carreras.txt";
        Cargador.cargarCarrerasDesdeArchivo(rutaArchivoCarrera);
        Cargador.cargarMateriasCarrera();
        Cargador.cargarCorrelativasCarrera();
//        System.out.println("Listado de alumnos cargados:");
//        Facultad facultad = Facultad.getInstanciaFacultad();
//        facultad.getAlumnosMap().forEach((dni, alumno) -> {
//            System.out.println(dni + " - " + alumno.getNombre());
//        });

        var vent = new Ventana();
        vent.setVisible(true);
    }


}
