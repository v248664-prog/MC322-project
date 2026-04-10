package mc322.project;
public class CartaQueimadura extends Carta {

    public CartaQueimadura() {
        /**
         * construtor
         */
        super("Lança-chamas", "Aplica 3 acumulos de queimadura no inimigo", 15);
    }

    /**
     * usa contra o inimigo
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            // Instancia o efeito passando o inimigo como alvo
            EfeitoQueimadura Queimadura = new EfeitoQueimadura(op, 3, 30);
            op.aplicarEfeito(Queimadura, jogo);
            System.out.println(">>> Voce incendiou o inimigo!");
        }
    }
}
