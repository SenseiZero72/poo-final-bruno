package Model;

public class Materia {

public enum Tipo { OBLIGATORIA, OPTATIVA }

private String nombre;
private Tipo tipo;
private boolean tienePromocion;

public Materia(String nombre, Tipo tipo, boolean tienePromocion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tienePromocion = tienePromocion;
    }
public String getNombre() { return nombre; }
public Tipo getTipo() { return tipo; }
public boolean gettienePromocion() { return tienePromocion; }

}

