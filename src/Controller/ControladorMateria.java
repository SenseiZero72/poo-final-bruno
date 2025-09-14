package Controller;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import Model.Materia;
import Model.Materia.Tipo;
import Model.Facultad;


public class ControladorMateria {
	private final Facultad facultad;
    public ControladorMateria() {
        this.facultad = Facultad.getInstanciaFacultad();
    }
    
    public boolean AgregarMateria(String nombre, Tipo categoria,boolean promo) {
    	
    	return facultad.nuevaMateria(nombre, categoria, promo);
    }
    public List<String> getTodasLasMaterias() {
        List<String> nombres = new ArrayList<>();
        for (Materia m : facultad.getMaterias()) {
            nombres.add(m.getNombre());
        }
        return nombres;
    }

}