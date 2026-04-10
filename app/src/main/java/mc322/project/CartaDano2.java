package mc322.project;
public class CartaDano2 extends Carta {
    /**
    * Carta que causa dano fixo ao inimigo.
    */
    public CartaDano2() {
        super("Desert", "Precisa carregar antes de atirar", 15);
    }

    /**
     * Executa o efeito da carta, causando dano aleatório ao inimigo.
     * 
     * @param op inimigo que receberá o dano
     * @param prota herói que utiliza a carta
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        this.shoot(op, prota);
    }

    /**
     * Aplica dano fixo ao inimigo
     */
    public void shoot(Inimigo op, Heroi prota) {
        op.receive_damage(40);
        System.out.println(">>> Voce atirou e causou 20 de dano!");
    }
}