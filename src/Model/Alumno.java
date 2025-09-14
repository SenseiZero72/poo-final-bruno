package Model;
import java.util.*;

public class Alumno {
	private String nombre;
	private int dni;
    private Set<Carrera> carreras = new HashSet<>();
	private Map<Materia,Cursada> estadosMateria;
	
	public Alumno(int dni, String nombre) {
        this.nombre = nombre;
        this.dni = dni;
        this.estadosMateria = new HashMap<>();
        this.carreras = new HashSet<Carrera>();
    }
	
	public boolean inscribirseCarrera(Carrera c) {
        return carreras.add(c);
    }
	public Map<Materia,Cursada> getestadosMateria(){
	    return estadosMateria;
	}
	public void inscribirseMateria(Carrera c, Materia materia) {
	    if (estadosMateria.containsKey(materia) ||  !carreras.contains(c)) {
	        return;
	    }
	    if (c.puedeCursar(estadosMateria, materia)) {
	        estadosMateria.put(materia, new Cursada(Cursada.Estado.INSCRIPTO, -1));
	    }
	}
	public boolean finalizoCarrera(Carrera c) {
		if (!carreras.contains(c)) {
	        return false;
	    }
		return c.finalizo(estadosMateria);
	}
	public void aprobarMateria(Materia materia) {
	    if (estadosMateria.containsKey(materia)) {
	        estadosMateria.put(materia, new Cursada(Cursada.Estado.APROBADO_PARCIAL, -1));
	    }
	}
	public void aprobarFinal(Materia m, double n) {
	    if (estadosMateria.containsKey(m)) {
	        estadosMateria.put(m, new Cursada(Cursada.Estado.FINAL_APROBADO, n));
	    }
	}
	public void promocion(Materia m, double n) {
	    if (estadosMateria.containsKey(m)) {
	        estadosMateria.put(m, new Cursada(Cursada.Estado.PROMOCIONADO, n));
	    }
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}	
	
}
