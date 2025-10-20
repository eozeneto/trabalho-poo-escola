public class Discipline{
    private String codigo;
    private String nome;

    public Discipline(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}