package mc322.project;
/**
 * Classe abstrata que representa um efeito aplicado a uma entidade.
 */
public abstract class Efeito implements Subscriber {
    protected String nome;
    protected Entidade dono;
    protected int acumulos;
    protected int dano;

    /**
     * Construtor do efeito.
     */
    public Efeito(String nome, Entidade dono, int acumulos, int dano) {
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
        this.dano = dano;
    }

    /**
     * Retorna a quantidade de acúmulos do efeito.
     * 
     * @return número de acúmulos.
     */
    public int getAcumulos() {
        return this.acumulos;
    }

    /**
     * Adiciona acúmulos ao efeito.
     * 
     * @param valor quantidade a ser adicionada.
     */
    public void adicionarAcumulos(int valor) {
        this.acumulos += valor;
    }

    /**
     * Retorna uma representação textual do efeito.
     * 
     * @return string no formato "Nome [acúmulos]".
    */
    public String getString() {
        return nome + " [" + acumulos + "]";
    }
}