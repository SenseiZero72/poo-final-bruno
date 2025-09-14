package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Alumno;
import Model.Facultad;
import Model.Carrera;
import Model.Materia;



public class ControladorEstudiantes {

    private final Facultad facultad;

    public ControladorEstudiantes(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<String[]> obtenerListaAlumnos() {
        List<String[]> lista = new ArrayList<>();
        for (Alumno a : this.facultad.getAlumnosMap().values()) {
            lista.add(new String[]{String.valueOf(a.getDni()), a.getNombre()});
        }
        return lista;
    }
    public String crearAlumno(int dni, String nombre) {
        if (facultad.getAlumnosMap().containsKey(dni)) {
            return "Alumno ya existe";
        } else {
            facultad.agregarAlumno(dni, nombre);
            return "Exito";
        }
    }
    public String inscribirAlumnoEnCarrera(int dni, String nombreCarrera) {
        Alumno alumno = facultad.getAlumnosMap().get(dni);
        Carrera carrera = facultad.getCarrerasMap().get(nombreCarrera);
        boolean agregado = alumno.inscribirseCarrera(carrera);

        return agregado ? "Exito" : "El alumno ya estaba inscripto en esa carrera";
    }
    public String inscribirMateria(int dni, String nombreCarrera, String nombreMateria) {
        Alumno alumno = facultad.getAlumnosMap().get(dni);
        Carrera carrera = facultad.getCarrerasMap().get(nombreCarrera);

        Materia materia = carrera.getPlan().getMaterias()
                .stream()
                .filter(m -> m.getNombre().equalsIgnoreCase(nombreMateria))
                .findFirst()
                .orElse(null);

        if (alumno.getestadosMateria().containsKey(materia)) {
            return "El alumno ya está inscripto en esa materia";
        }

        alumno.inscribirseMateria(carrera, materia);
        if (alumno.getestadosMateria().containsKey(materia)) {
            return "Éxito";
        } else {
            return "No cumple requisitos para cursar la materia";
        }
    }
    public String verificarFinalizacionCarrera(Integer dni, String nombreCarrera) {
        Alumno alumno = facultad.getAlumnosMap().get(dni);
        Carrera carrera = facultad.getCarrerasMap().get(nombreCarrera);

        boolean finalizo = alumno.finalizoCarrera(carrera);

        return finalizo ? "Graduado" : "Todavia falta";
    }
    public List<String> obtenerMateriasDisponibles(int dniAlumno, String nombreCarrera) {
        List<String> disponibles = new ArrayList<>();

        Alumno alumno = facultad.getAlumnosMap().get(dniAlumno);
        if (alumno == null) return disponibles;

        Carrera carrera = facultad.getCarrerasMap().get(nombreCarrera);
        if (carrera == null) return disponibles;

        List<Materia> materias = carrera.materiasPosibles(alumno.getestadosMateria());

        for (Materia m : materias) {
            disponibles.add(m.getNombre());
        }

        return disponibles;
    }
}
