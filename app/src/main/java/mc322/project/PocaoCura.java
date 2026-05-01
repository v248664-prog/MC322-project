package mc322.project;

/**
 * Produto da loja que recupera 30 pontos de vida do herói ao ser comprado.
 */
public class PocaoCura implements Produtos{
    
    private int preco = 15;

    /**
     * Cura 30 pontos de vida
     * @param pt
     */
    public void comprar(Heroi pt) {
        pt.health += 30;
        System.out.println("Você usou uma poção e recuperou 30 de vida.");
    }

    /**
     * Retorna o preço de exibição da opção.
     * @return
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Retorna o nome de exibição da opção.
     * @return
     */
    public String getNome() {
        return "Poção de Cura";
    }
}
