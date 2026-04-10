package mc322.project;
public class CartaRegeneracao extends Carta {
    /**
    * Carta que aplica o efeito de cura.
    */
    public CartaRegeneracao() {
        /**
        * Construtor da carta.
        */
        super("Curativos", "Aplica 2 acumulos de cura continua", 15);
    }

    /**
     * Executa o efeito da carta, aplicando queimadura no inimigo.
     * 
     * @param prota herói que utiliza a carta.
     * @param jogo sistema de eventos do jogo.
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            EfeitoRegeneracao regen = new EfeitoRegeneracao(prota, 2, 15);
            prota.aplicarEfeito(regen, jogo);
            System.out.println(">>> Voce aplicou Regeneracao em si mesmo!");
        }
    }
}
