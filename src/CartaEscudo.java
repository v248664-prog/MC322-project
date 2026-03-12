import java.util.Random;

public class CartaEscudo {

   int possible_hiding_spots;
   int lucky_number = 5;
   boolean tryed = false;

   public CartaEscudo(int possible_hiding_spots) {
      this.possible_hiding_spots = possible_hiding_spots;
   }
   // construtor da carta

   public void find_shelter(Heroi prota) {

      this.tryed = true;

      if (this.possible_hiding_spots > 0) {

         possible_hiding_spots--;

         Random ram = new Random();
         int num = ram.nextInt(4);

         if (num == 3) {

            prota.defence += 0;
            lucky_number = 3;

         } else if (num == 2) {

            prota.defence += 25;
            lucky_number = 2;

         } else if (num == 1) {

            prota.defence += 50;
            lucky_number = 1;

         } else if (num == 0) {

            prota.defence += 75;
            prota.health += 5;

            if (prota.health > 100) {
               prota.health = 100;
            }

            lucky_number = 0;
         }
      }
   }
   // sistema de sorte para encontrar um abrigo

   public void ending_bonus(Heroi prota) {

      if (lucky_number == 2) {
         prota.defence -= 25;
      }
      else if (lucky_number == 1) {
         prota.defence -= 50;
      }
      else if (lucky_number == 0) {
         prota.defence -= 75;
      }
      this.tryed = false;
   }
   // fim do bonus
}