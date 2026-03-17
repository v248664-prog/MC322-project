import java.util.Random;

public class CartaDano extends Carta {

   int qnt;

   public CartaDano(int qnt) {
      super("Bomba", "Causa dano aleatório", 3);
      this.qnt = qnt;
   }
   // construtor da bomba

   public void usar(Inimigo op, Heroi prota) {

      if (qnt >= 1 && prota.energy >= 3) {

         prota.energy -= 3;

         Random ram = new Random();
         int dano = ram.nextInt(100);

         op.receive_damage(dano);

         qnt--;
      }
   }
   // dano da bomba
}