package Model;

import java.util.List;
import java.util.Map;

public class PlanB extends PlanDeEstudios {

    @Override
    public boolean puedeCursar(Map<Materia, Cursada> estadosAlumno, Materia materia) {
        List<Materia> correlativas = getCorrelativas(materia);

        for (Materia c : correlativas) {
            Cursada em = estadosAlumno.get(c); // obtenemos el EstadoMateria directamente
            if (em == null) {
                return false;
            }
            if (em.getEstado() == Cursada.Estado.FINAL_APROBADO || 
                    em.getEstado() == Cursada.Estado.PROMOCIONADO) {
                return false;
            }
        }
        return true;
    }
}

