import Model.Facultad;
import View.Componentes.Ventana;
import Model.Alumno;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/alumnos.txt";
        Cargador.cargarAlumnosDesdeArchivo(rutaArchivo);

//        System.out.println("Listado de alumnos cargados:");
//        Facultad facultad = Facultad.getInstanciaFacultad();
//        facultad.getAlumnosMap().forEach((dni, alumno) -> {
//            System.out.println(dni + " - " + alumno.getNombre());
//        });
        
        var vent = new Ventana();        
    }
    
    
}
