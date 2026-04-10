package mc322.project;
public class CartaDano2 extends Carta {
    /**
     * carta de dano
     */
    public CartaDano2() {
        super("Desert", "Precisa carregar antes de atirar", 15);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.shoot(op, prota);
    }

    public void shoot(Inimigo op, Heroi prota) {
        op.receive_damage(40);
        System.out.println(">>> Voce atirou e causou 20 de dano!");
    }
}