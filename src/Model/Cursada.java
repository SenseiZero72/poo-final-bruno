package Model;

public class Cursada{
public enum Estado {
    INSCRIPTO,
    APROBADO_PARCIAL,
    FINAL_APROBADO,
    PROMOCIONADO
}
    private Estado estado;
    private double notaFinal; // -1 si no aplica

    public Cursada(Estado estado, double notaFinal) {
        this.estado = estado;
        this.notaFinal = notaFinal;
    }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
}
