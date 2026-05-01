package mc322.project;
import java.util.Random;

public class No {
    private static Random rand = new Random();

    public Eventos gerarEvento(int qnt) {
        int r = rand.nextInt(100);

        if (r < 60) {
            return new Batalha(qnt);
        }
        else if (r < 75) {
            return new Loja(qnt);
        }
        else if (r < 85) {
            return new Fogueira(qnt);
        }
        else {
            return new Escolha(qnt);
        }
    }
}
