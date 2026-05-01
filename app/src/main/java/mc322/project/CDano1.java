package mc322.project;

public class CDano1 implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        Baralho bar = pt.getBaralho();
        bar.adicionar_a_colecao(new CartaDano());
        System.out.println("Você comprou uma bomba");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Bomba";
    }
}
