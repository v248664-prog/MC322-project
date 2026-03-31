public class CartaDano2 extends Carta {

    public CartaDano2() {
        super("Arma", "Precisa carregar antes de atirar", 15);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.shoot(op, prota);
    }

    public void shoot(Inimigo op, Heroi prota) {
        op.receive_damage(20);
        System.out.println(">>> Voce atirou e causou 20 de dano!");
    }
}