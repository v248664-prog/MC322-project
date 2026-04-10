package mc322.project;
import java.util.Random;

/**
 * Carta que causa dano aleatório ao inimigo.
 */
public class CartaDano extends Carta {
    /**
     * Construtor da carta de dano.
     * Define nome, descrição e custo de energia.
     */
    public CartaDano() {
        super("Bomba", "Causa dano aleatorio", 30);
    }

    /**
     * Executa o efeito da carta, causando dano aleatório ao inimigo.
     * 
     * @param op inimigo que receberá o dano
     * @param prota herói que utiliza a carta
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= 3) {
            Random ram = new Random();
            int dano = ram.nextInt(150);
            op.receive_damage(dano);
            System.out.println(">>> A Bomba explodiu causando " + dano + " de dano!");
        }
    }
}