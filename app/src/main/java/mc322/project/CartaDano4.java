package mc322.project;
public class CartaDano4 extends Carta {
    /**
     * carta de dano
     */
    public CartaDano4() {
        super("Rifle", "Causa dano ", 30);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.shoot(op, prota);
    }

    public void shoot(Inimigo op, Heroi prota) {
        op.receive_damage(60);
        System.out.println(">>> Voce atirou e causou 50 de dano!");
    }
}
