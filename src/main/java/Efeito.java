public abstract class Efeito implements Subscriber {
    protected String nome;
    protected Entidade dono;
    protected int acumulos;

    public Efeito(String nome, Entidade dono, int acumulos) {
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
    }

    public int getAcumulos() {
        return this.acumulos;
    }

    public void adicionarAcumulos(int valor) {
        this.acumulos += valor;
    }

    public String getString() {
        return nome + " [" + acumulos + "]";
    }
}