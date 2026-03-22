public class CartaDano2 extends Carta{

   int munition;
   boolean charged = false;

   public CartaDano2(int munition) {
      super("Arma", "Precisa carregar antes de atirar", 2);
      this.munition = munition;
   }
   // construtor da arma
    public void usar(Inimigo op, Heroi prota) {
        this.shoot(op, prota);
    }

   public void charge(Heroi prota) {

      if (prota.energy >= 2) {
         charged = true;
         prota.energy -= 2;
      }
   }
   // carregar

   public void shoot(Inimigo op, Heroi prota) {

      if (charged && munition > 0) {

         prota.energy -= 2;

         op.receive_damage(3);

         munition--;

         charged = false;

      } else if (munition <= 0) {

         System.out.println("Sem munição");

      } else {

         System.out.println("Não há nada na câmara");
      }
   }
   //atirar
}