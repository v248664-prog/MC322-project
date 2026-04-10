package mc322.project;
import java.util.Random;

public class CartaDano extends Carta {
    /**
     * carta de dano
     */
    public CartaDano() {
        super("Bomba", "Causa dano aleatorio", 30);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= 3) {
            Random ram = new Random();
            int dano = ram.nextInt(150);
            op.receive_damage(dano);
            System.out.println(">>> A Bomba explodiu causando " + dano + " de dano!");
        }
    }
}