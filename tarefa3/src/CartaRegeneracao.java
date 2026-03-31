public class CartaRegeneracao extends Carta {
    public CartaRegeneracao() {
        super("Pocao de Regeneracao", "Aplica 2 acumulos de cura continua", 15);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            EfeitoRegeneracao regen = new EfeitoRegeneracao(prota, 2);
            prota.aplicarEfeito(regen, jogo);
            System.out.println(">>> Voce aplicou Regeneracao em si mesmo!");
        }
    }
}
