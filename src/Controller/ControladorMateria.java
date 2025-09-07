package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Materia;
import Model.Materia.Tipo;
import Model.Facultad;
import Model.Carrera;


public class ControladorMateria {
	private Facultad facultad;

    public ControladorMateria(Facultad facultad) {
        this.facultad = facultad;
    }
    
    public String AgregarMateria(String nombre, Tipo categoria,boolean promo) {
    	String resultado= new String();
    	
    	return resultado;
    }
    public List<Materia> getTodasLasMaterias() {
        Set<Materia> materiasUnicas = new HashSet<>();
        
        for (Carrera carrera : facultad.getCarrerasMap().values()) {
            
        materiasUnicas.addAll(carrera.getPlan().getMaterias());
        }
        
        return new ArrayList<>(materiasUnicas);
    }
}