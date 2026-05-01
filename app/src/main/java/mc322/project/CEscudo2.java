package mc322.project;

/**
 * Produto da loja que representa a carta.
 */
public class CEscudo2 implements Produtos{
    
    private int preco = 30;

    /**
     * Adiciona uma Carta de Escudo2 ao baralho.
     * @param pt
     */
    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaEscudo());
        System.out.println("Você comprou uma armadura");
    }

    /**
     * Retorna o preço do produto.
     * @return
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Retorna o nome de exibição do produto.
     * @return
     */
    public String getNome() {
        return "Armadura";
    }
}
