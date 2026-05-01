package mc322.project;

public class PocaoEnergia implements produtos{
    
    private int preco = 30;

    public void comprar(Heroi pt) {
        pt.energy = pt.energy_total = 60;
        System.out.println("Você usou uma poção e a sua energia máxima dobrou");
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return "Poção de Energia";
    }
}
