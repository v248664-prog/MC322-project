package mc322.project;

public class PocaoCura implements produtos{
    
    private int preco = 15;

    public void comprar(Heroi pt) {
        pt.health += 30;
        System.out.println("Você usou uma poção e recuperou 30 de vida.");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Poção de Cura";
    }
}
