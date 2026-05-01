package mc322.project;
import java.util.Random;

public class No {
    private static Random ram = new Random();

    /**
     * Gera um evento aleatório para cada nó.
     * @param qnt
     * @return
     */
    public Eventos gerarEvento(int qnt) {
        int prob = ram.nextInt(100);

        if (prob < 60) {
            return new Batalha(qnt, false);
        }
        else if (prob < 75) {
            return new Loja(qnt);
        }
        else if (prob < 90) {
            return new Fogueira(qnt);
        }
        else {
            return new Escolha(qnt);
        }
    }
}
