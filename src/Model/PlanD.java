package Model;

import java.util.List;
import java.util.Map;

public class PlanD extends PlanDeEstudios {
    @Override
    public boolean puedeCursar(Map<Materia, Cursada> estadosAlumno, Materia materia) {
        List<Materia> correlativas = getCorrelativas(materia);
        for (Materia c : correlativas) {
            Cursada em = estadosAlumno.get(c);
            if (em == null || em.getEstado() == Cursada.Estado.INSCRIPTO) {
                return false;
            }
        }
        int cuatrMateria = obtenerCuatrimestre(materia);
        int inicio = Math.max(1, cuatrMateria - 3);
        for (int c = inicio; c < cuatrMateria; c++) {
            List<Materia> materiasCuatr = obtenerMateriasPorCuatrimestre(c);
            for (Materia mPrev : materiasCuatr) {
                Cursada em = estadosAlumno.get(mPrev);
                if (em == null || 
                    !(em.getEstado() == Cursada.Estado.FINAL_APROBADO ||
                      em.getEstado() == Cursada.Estado.PROMOCIONADO)) {
                    return false;
                }
            }
        }
        return true;
    }
}

    
