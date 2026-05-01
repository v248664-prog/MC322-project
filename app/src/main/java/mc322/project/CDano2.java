package mc322.project;

/**
 * Produto da loja que representa a carta.
 */
public class CDano2 implements Produtos{
    
    private int preco = 30;

    /**
     * Adiciona uma Carta de Dano2 ao baralho.
     * @param pt
     */
    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaDano2());
        System.out.println("Você comprou uma Desert");
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
        return "Desert";
    }
}
