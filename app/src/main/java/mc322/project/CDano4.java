package mc322.project;

public class CDano4 implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaDano4());
        System.out.println("Você comprou um Rifle");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Rifle";
    }
}
