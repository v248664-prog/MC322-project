package mc322.project;

/**
 * Produto da loja que representa a carta.
 */
public class CDano1 implements Produtos{
    
    private int preco = 30;

    /**
     * Adiciona uma Carta de Dano ao baralho.
     * @param pt
     */
    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaDano());
        System.out.println("Você comprou uma bomba");
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
        return "Bomba";
    }
}
