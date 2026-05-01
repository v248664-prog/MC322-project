package mc322.project;

/**
 * Produto da loja que dobra a energia máxima do herói para 60 ao ser comprado.
 */
public class PocaoEnergia implements Produtos{
    
    private int preco = 30;

    /**
     * Define a energia atual e total do herói para 60.
     * @param pt
     */
    public void comprar(Heroi pt) {
        pt.energy = pt.energy_total = 60;
        System.out.println("Você usou uma poção e a sua energia máxima dobrou");
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
        return "Poção de Energia";
    }
}
