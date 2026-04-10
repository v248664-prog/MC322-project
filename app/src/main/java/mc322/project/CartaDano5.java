package mc322.project;
public class CartaDano5 extends Carta {
    /**
     * carta de dano
     */
    public CartaDano5() {
        super("Revolver", "Causa dano ", 15);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.shoot(op, prota);
    }

    public void shoot(Inimigo op, Heroi prota) {
        op.receive_damage(30);
        System.out.println(">>> Voce atirou e causou 50 de dano!");
    }
}
