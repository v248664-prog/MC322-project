import java.util.Random;

public class CartaDano extends Carta {

   public CartaDano() {
      super("Bomba", "Causa dano aleatório", 30);
   }
   // construtor da bomba

   public void usar(Inimigo op, Heroi prota) {

      if (prota.energy >= 3) {

         Random ram = new Random();
         int dano = ram.nextInt(100);

         op.receive_damage(dano);

      }
   }
   // dano da bomba
}