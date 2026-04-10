package mc322.project;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa uma entidade do jogo.
 */
public abstract class Entidade {
    protected String name;
    protected int attack;
    protected int defence;
    protected int energy;
    protected int health;

    protected List<Efeito> efeitos = new ArrayList<>();

    abstract void receive_damage(int dmg);
    abstract void show();
    abstract void receive_energy();
    abstract void ASCII();

    /**
     * Remove um efeito da entidade.
     * 
     * @param e efeito a ser removido.
     */
    public void removerEfeito(Efeito e) {
        efeitos.remove(e);
    }

    /**
     * Aplica um novo efeito à entidade. 
     * @param novoEfeito efeito a ser aplicado.
     * @param jogo sistema de eventos (Publisher).
     */
    public void aplicarEfeito(Efeito novoEfeito, Publisher jogo) {
        for (Efeito e : efeitos) {
            if (e.getClass().equals(novoEfeito.getClass())) {
                e.adicionarAcumulos(novoEfeito.getAcumulos());
                return;
            }
        }
        efeitos.add(novoEfeito);
        jogo.inscrever(novoEfeito);
    }
    

    /**
     * Exibe todos os efeitos ativos da entidade no terminal.
     */
    public void mostrarEfeitos() {
        if (!efeitos.isEmpty()) {
            System.out.print("Efeitos em " + this.name + ": ");
            for (Efeito e : efeitos) {
                System.out.print(e.getString() + " ");
            }
            System.out.println();
        }
    }
}