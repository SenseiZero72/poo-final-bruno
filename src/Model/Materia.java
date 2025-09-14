package Model;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        // unicidad basada en el nombre (ignorando mayúsculas)
        return Objects.equals(nombre.toLowerCase(), materia.nombre.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
}

