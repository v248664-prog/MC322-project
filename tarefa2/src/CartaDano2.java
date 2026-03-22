public class CartaDano2 extends Carta{

   public CartaDano2() {
      super("Arma", "Precisa carregar antes de atirar", 15);
   }
    public void usar(Inimigo op, Heroi prota) {
        this.shoot(op, prota);
    }

   public void shoot(Inimigo op, Heroi prota) {
      op.receive_damage(20);
   }
   // o metodo de carregar parecia interensante mas não trouxe
   // a jogabilidade pretendida
}