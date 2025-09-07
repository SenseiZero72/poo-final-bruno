package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Facultad {
	private Map<Integer, Alumno> alumnosMap;
	private Map<String, Carrera> carrerasMap;
	private Set<Materia> materias = new HashSet<>();
	
	private static Facultad instanciaFacultad=null;
	private Facultad() {
        alumnosMap = new HashMap<>();
        carrerasMap = new HashMap<>();
        materias = new HashSet<Materia>();
    }

	public static Facultad getInstanciaFacultad() {
		if (instanciaFacultad==null) {
			instanciaFacultad=new Facultad();
		}
		return instanciaFacultad;
	}
	public void agregarAlumno(Integer dni, String nombre) {
		Alumno alumno = new Alumno(dni, nombre);
	    alumnosMap.put(dni, alumno);
	}
//	public boolean nuevaMateria() {
//		materias.add()
//	}
	

	public Map<Integer, Alumno> getAlumnosMap() {
		return alumnosMap;
	}

	public Map<String, Carrera> getCarrerasMap() {
		return carrerasMap;
	}

	public void setCarrerasMap(Map<String, Carrera> carrerasMap) {
		this.carrerasMap = carrerasMap;
	}	
	
//	agregar varios alumnos 
	
	
}
