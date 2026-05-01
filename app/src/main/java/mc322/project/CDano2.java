package mc322.project;

public class CDano2 implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaDano2());
        System.out.println("Você comprou uma Desert");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Desert";
    }
}
