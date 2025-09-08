package Controller;

import java.util.Set;

import Model.Materia;
import Model.Materia.Tipo;
import Model.Facultad;


public class ControladorMateria {
	private Facultad facultad;

    public ControladorMateria(Facultad facultad) {
        this.facultad = facultad;
    }
    
    public boolean AgregarMateria(String nombre, Tipo categoria,boolean promo) {
    	
    	return facultad.nuevaMateria(nombre, categoria, promo);
    }
    public Set<Materia> getTodasLasMaterias() {
        return facultad.getMaterias();
    }
}