package mc322.project;
public class CartaRegeneracao extends Carta {
    public CartaRegeneracao() {
        /**
         * construtor
         */
        super("Curativos", "Aplica 2 acumulos de cura continua", 15);
    }

    /**
     * cura o heroi
     */
    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            EfeitoRegeneracao regen = new EfeitoRegeneracao(prota, 2, 15);
            prota.aplicarEfeito(regen, jogo);
            System.out.println(">>> Voce aplicou Regeneracao em si mesmo!");
        }
    }
}
