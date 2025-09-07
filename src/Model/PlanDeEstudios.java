package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PlanDeEstudios {

private Map<Materia, Integer> materias; 
private Map<Materia, List<Materia>> correlativas;

    public PlanDeEstudios() {
        materias = new HashMap<>();
        correlativas = new HashMap<>();
    }

    public List<Materia> getMaterias() {
        return new ArrayList<>(materias.keySet());
    }
    public void agregarMateria(Materia m, int cuatrimestre) {
        materias.put(m, cuatrimestre);
    }
    public void agregarCorrelativa(Materia m, Materia correlativa) {
        if (obtenerCuatrimestre(m)>obtenerCuatrimestre(correlativa)){
        correlativas.computeIfAbsent(m, k -> new ArrayList<>()).add(correlativa);
        }
    }
    public List<Materia> getCorrelativas(Materia m) {
        return correlativas.getOrDefault(m, new ArrayList<>());
    }
    public int obtenerCuatrimestre(Materia m) {
        return materias.getOrDefault(m, -1); // -1 si no existe
    }
    public List<Materia> obtenerMateriasPorCuatrimestre(int cuatrimestre) {
        List<Materia> resultado = new ArrayList<>();
        for (Map.Entry<Materia, Integer> entry : materias.entrySet()) {
            if (entry.getValue() == cuatrimestre) {
                resultado.add(entry.getKey());
            }
        }
        return resultado;
    }
    public boolean puedeCursar(Map<Materia,Cursada> estadosAlumno, Materia materia) {
        return false;
    }
    public boolean termino(Map<Materia, Cursada> estadoAlumno, int optativasNecesarias) {
        int optativasAprobadas = 0;

        for (Materia m : materias.keySet()) {
            Cursada cursada = estadoAlumno.get(m);
            boolean aprobada = cursada != null &&
                    (cursada.getEstado() == Cursada.Estado.FINAL_APROBADO ||
                     cursada.getEstado() == Cursada.Estado.PROMOCIONADO);

            if (m.getTipo() == Materia.Tipo.OBLIGATORIA) {
                if (!aprobada) return false;
            } else {
                if (aprobada) optativasAprobadas++;
            }
        }
        return optativasAprobadas >= optativasNecesarias;
    }
}

