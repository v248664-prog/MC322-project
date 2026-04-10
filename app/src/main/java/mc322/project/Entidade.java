package mc322.project;
import java.util.ArrayList;
import java.util.List;
/**
 *declara os atributos, listas e métodos básicos
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
     * remove os efeitos
     */
    public void removerEfeito(Efeito e) {
        efeitos.remove(e);
    }

    /**
     * aplica os eventos
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
     * mostra os eventos no terminal
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