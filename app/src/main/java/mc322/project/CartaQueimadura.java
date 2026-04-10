package mc322.project;
public class CartaQueimadura extends Carta {

    /**
    * Carta que aplica o efeito de queimadura.
    */
    public CartaQueimadura() {
        /**
        * Construtor da carta.
        */
        super("Lança-chamas", "Aplica 3 acumulos de queimadura no inimigo", 15);
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
            EfeitoQueimadura Queimadura = new EfeitoQueimadura(op, 3, 30);
            op.aplicarEfeito(Queimadura, jogo);
            System.out.println(">>> Voce incendiou o inimigo!");
        }
    }
}
