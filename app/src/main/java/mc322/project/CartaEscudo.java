package mc322.project;
import java.util.Random;

/**
 * aumenta a defesa temporariamente
 * usa o mesmo sistema de decisão do inigo
 */
public class CartaEscudo extends Carta {

    public int lucky_number = 5;
    public boolean tryed = false;

    public CartaEscudo() {
        super("hide", "Se esconder", 30);
    }

    // Adicionado o parâmetro Publisher jogo
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.find_shelter(prota);
    }

    public void find_shelter(Heroi prota) {
        this.tryed = true;
        Random ram = new Random();
        int num = ram.nextInt(4);

        if (num == 3) {
            prota.defence += 0;
            lucky_number = 3;
            System.out.println(">>> Voce nao achou um bom esconderijo...");
        } else if (num == 2) {
            prota.defence += 25;
            lucky_number = 2;
            System.out.println(">>> Abrigo razoavel! Defesa +25");
        } else if (num == 1) {
            prota.defence += 50;
            lucky_number = 1;
            System.out.println(">>> Otimo abrigo! Defesa +50");
        } else if (num == 0) {
            prota.defence += 75;
            prota.health += 5;
            if (prota.health > 100) prota.health = 100;
            lucky_number = 0;
            System.out.println(">>> Bunkers encontrados! Defesa +75 e recuperou 5 de vida!");
        }
    }

    public void ending_bonus(Heroi prota) {
        if (lucky_number == 2) prota.defence -= 25;
        else if (lucky_number == 1) prota.defence -= 50;
        else if (lucky_number == 0) prota.defence -= 75;
        
        this.tryed = false;
    }
}