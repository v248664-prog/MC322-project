package mc322.project;
public class CartaVeneno extends Carta {
    /**
    * Carta que aplica o efeito de veneno.
    */
    public CartaVeneno() {
        /**
        * Construtor da carta.
        */
        super("Bomba de Gás", "Aplica 3 acumulos de veneno no inimigo", 15);
    }

    /**
     * Executa o efeito da carta, aplicando queimadura no inimigo.
     * 
     * @param op inimigo que receberá o efeito.
     * @param prota herói que utiliza a carta.
     * @param jogo sistema de eventos do jogo.
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
