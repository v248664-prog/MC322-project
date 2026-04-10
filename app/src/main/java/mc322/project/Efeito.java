package mc322.project;
/**
 * declara os métodos e atributos básicos
 */
public abstract class Efeito implements Subscriber {
    protected String nome;
    protected Entidade dono;
    protected int acumulos;
    protected int dano;

    public Efeito(String nome, Entidade dono, int acumulos, int dano) {
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
        this.dano = dano;
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