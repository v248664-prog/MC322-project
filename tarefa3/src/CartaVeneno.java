public class CartaVeneno extends Carta {
    
    public CartaVeneno() {
        super("Frasco Toxico", "Aplica 3 acumulos de veneno no inimigo", 15);
    }

    public void usar(Inimigo op, Heroi prota, Publisher jogo) {
        if (prota.energy >= this.custo) {
            // Instancia o efeito passando o inimigo como alvo
            EfeitoVeneno veneno = new EfeitoVeneno(op, 3);
            op.aplicarEfeito(veneno, jogo);
            System.out.println(">>> Voce aplicou Veneno no inimigo!");
        }
    }
}
