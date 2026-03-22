public abstract class Carta {
    protected String nome;
    protected String descricao;
    protected int custo;

    public Carta(String nome, String descricao, int custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    public abstract void usar(Inimigo op, Heroi prota);

    //atributos e metodos de importancia
}