package mc322.project;

public class CQueimadura implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaQueimadura());
        System.out.println("Você comprou Lança-chamas");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Lança-chamas";
    }
}
