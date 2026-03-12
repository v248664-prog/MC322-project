import java.util.Random;

public class CartaDano {

   int qnt;

   public CartaDano(int qnt) {
      this.qnt = qnt;
   }
   // construtor da bomba

   public void activate(Inimigo op, Heroi prota) {

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