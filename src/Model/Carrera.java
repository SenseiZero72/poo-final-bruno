package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Carrera {
    
private String nombre;
private int cantidadOptativasNecesarias;
private PlanDeEstudios plan;

public String getNombre() { return nombre; }
public Carrera(String nombre, int cantidadOptativasNecesarias) {
    this.nombre = nombre;
    this.cantidadOptativasNecesarias = cantidadOptativasNecesarias;
    this.plan = null;
}


public PlanDeEstudios getPlan() {
	return plan;
}
public int getCantidadOptativasNecesarias() { return cantidadOptativasNecesarias; }
public void setCantidadOptativasNecesarias(int cantidadOptativasNecesarias) { 
    this.cantidadOptativasNecesarias = cantidadOptativasNecesarias; 
}
public void crearPlan(String tipo) {
        switch (tipo) {
            case "A":
                plan = new PlanA();
                break;
            case "B":
                plan = new PlanB();
                break;
            case "C":
                plan = new PlanC();
                break;
            case "E":
                plan = new PlanE();
                break;
            default:
                throw new IllegalArgumentException("Tipo de plan desconocido: " + tipo);
        }
}
	public boolean puedeCursar(Map<Materia, Cursada> m,Materia mat){
	    return plan.puedeCursar(m, mat);
	}
	public List<Materia> materiasPosibles(Map<Materia,Cursada> estadosAlumno){
	        List<Materia> disponibles = new ArrayList<>();
        
        for (Materia m : plan.getMaterias()) {
            if (!estadosAlumno.containsKey(m) && plan.puedeCursar(estadosAlumno, m)) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }
	public boolean finalizo(Map<Materia,Cursada> estado){
		return plan.termino(estado,cantidadOptativasNecesarias);
	}
}
