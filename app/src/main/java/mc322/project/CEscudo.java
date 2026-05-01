package mc322.project;

public class CEscudo implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaEscudo());
        System.out.println("Você aprendeu a habilidade Hide");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Hide";
    }
}
