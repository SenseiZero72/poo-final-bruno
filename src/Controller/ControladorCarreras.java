package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.Alumno;
import Model.Facultad;
import Model.Carrera;
import Model.Materia;



public class ControladorCarreras {

    private final Facultad facultad;

    public ControladorCarreras() {
        this.facultad = Facultad.getInstanciaFacultad();
    }
    public Map<String, Carrera> obtenerNombresCarreras() {
        return facultad.getCarrerasMap();
    }
    public String darAltaCarrera(String nombre, int cantOptativas, String tipoPlan) {
        if (facultad.getCarrerasMap().containsKey(nombre)) {
            return "Ya existe";
        }
        facultad.agregarCarrera(nombre, cantOptativas, tipoPlan);
        return "Exito";
    }
    public String agregarMateria(String nombreCarrera, String nombreMateria, int cuatrimestre) {
        Carrera carrera = facultad.getCarrerasMap().get(nombreCarrera);
        Materia materia = null;
        for (Materia m : facultad.getMaterias()) {
            if (m.getNombre().equalsIgnoreCase(nombreMateria)) {
                materia = m;
                break;
            }
        }
        carrera.agregarMateriaAlPlan(materia, cuatrimestre);
        return "Exito";
    }
}
