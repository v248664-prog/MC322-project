package mc322.project;

/**
 * Interface que define o contrato para todos os produtos disponíveis na loja.
 */
public interface Produtos {
    
    /**
     * Retorna o efeito de exibição do produto.
     * @return
     */
    public void comprar(Heroi pt);
    /**
     * Retorna o preço de exibição do produto.
     * @return
     */
    public int getPreco();
    /**
     * Retorna o nome de exibição do produto.
     * @return
     */
    public String getNome();
}
