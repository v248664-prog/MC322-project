package mc322.project;

public class CRegeneracao implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaRegeneracao());
        System.out.println("Você comprou Curativos");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Curativos";
    }
}
