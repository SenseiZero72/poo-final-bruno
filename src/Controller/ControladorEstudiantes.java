package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Alumno;
import Model.Facultad;

public class ControladorEstudiantes {

    private Facultad facultad;

    public ControladorEstudiantes(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Alumno> obtenerListaAlumnos() {
        return new ArrayList<>(facultad.getAlumnosMap().values());
    }
}
