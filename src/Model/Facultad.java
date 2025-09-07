package Model;

import java.util.HashMap;
import java.util.Map;

public class Facultad {
	private Map<Integer, Alumno> alumnosMap;
	private Map<String, Carrera> carrerasMap;
	
	private static Facultad instanciaFacultad=null;
	private Facultad() {
        alumnosMap = new HashMap<>();
        carrerasMap = new HashMap<>();
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
