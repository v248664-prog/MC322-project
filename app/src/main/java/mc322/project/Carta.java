package mc322.project;
/**
 * classe abstrata de carta
 */
public abstract class Carta {
    protected String nome;
    protected String descricao;
    protected int custo;

    /**
     * Construtor da carta.
     * 
     * @param nome nome da carta.
     * @param descricao descrição do efeito da carta.
     * @param custo custo de energia para utilização.
     */
    public Carta(String nome, String descricao, int custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    /**
     * Executa o efeito da carta.
     * 
     * @param op inimigo alvo da carta.
     * @param prota herói que utiliza a carta.
     * @param jogo sistema de eventos do jogo (Publisher).
     */
    public abstract void usar(Inimigo op, Heroi prota, Publisher jogo);
}