package src;

import java.util.Random;

public class CartaEscudo {

   int possible_hiding_spots;
   int lucky_number;

   public CartaEscudo(int possible_hiding_spots) {
      this.possible_hiding_spots = possible_hiding_spots;
   }

   public void find_shelter(Heroi prota) {

      possible_hiding_spots--;

      Random ram = new Random();
      int num = ram.nextInt(4);

      if (num == 3) {

         prota.defence += 0;
         lucky_number = 3;

      } else if (num == 2) {

         prota.defence += 10;
         lucky_number = 2;

      } else if (num == 1) {

         prota.defence += 25;
         lucky_number = 1;

      } else {

         prota.defence += 75;
         prota.health += 5;

         if (prota.health > 100) {
            prota.health = 100;
         }

         lucky_number = 0;
      }
   }

   public void ending_bonus(Heroi prota) {

      if (lucky_number == 2) {
         prota.defence -= 10;
      }
      else if (lucky_number == 1) {
         prota.defence -= 25;
      }
      else if (lucky_number == 0) {
         prota.defence -= 75;
      }
   }
}