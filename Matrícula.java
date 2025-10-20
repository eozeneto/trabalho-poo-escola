public class Matrícula {
    private final String codigoDisciplina; 
    private double nota;                   

    
    public Matrícula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = codigoDisciplina;
        this.nota = nota;
    }

    
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return codigoDisciplina + "(" + nota + ")";
    }
    
}