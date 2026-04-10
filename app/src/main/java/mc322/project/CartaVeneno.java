package mc322.project;
public class CartaVeneno extends Carta {
    
    public CartaVeneno() {
        /**
         * construtor
         */
        super("Bomba de Gás", "Aplica 3 acumulos de veneno no inimigo", 15);
    }

    /**
     * usa contra o inimigo
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            // Instancia o efeito passando o inimigo como alvo
            EfeitoVeneno veneno = new EfeitoVeneno(op, 3, 20);
            op.aplicarEfeito(veneno, jogo);
            System.out.println(">>> Voce aplicou Veneno no inimigo!");
        }
    }
}
