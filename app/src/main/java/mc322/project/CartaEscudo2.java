package mc322.project;
import java.util.Random;

/**
 * aumenta a defesa permanentemente
 */
public class CartaEscudo2 extends Carta {

    public CartaEscudo2() {
        super("armadura", "", 30);
    }

    // Adicionado o parâmetro Publisher jogo
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.find_armor(prota);
    }

    public void find_armor(Heroi prota) {
        Random ram = new Random();
        int num = ram.nextInt(4);

        if (num == 3) {
            prota.defence += 0;
            System.out.println(">>> Voce achou trapos...");
        } else if (num == 2) {
            prota.defence += 1;
            System.out.println(">>> Roupas Velhas Defesa +1");
        } else if (num == 1) {
            prota.defence += 2;
            System.out.println(">>> Armadura Velha! Defesa +2");
        } else if (num == 0) {
            prota.defence += 5;
            System.out.println(">>> Armadura Nova! Defesa +5");
        }
    }

}
