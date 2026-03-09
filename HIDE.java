import java.util.Random;

public class HIDE {
   int lucky_number;

   public HIDE(int var1) {
      this.lucky_number = var1;
   }

   public void find_shelter(PT var1) {
      Random var2 = new Random();
      int var3 = var2.nextInt(5);
      if (var3 == 4) {
         var1.defence += 0;
         this.lucky_number = 4;
      } else if (var3 == 3) {
         var1.defence += 10;
         this.lucky_number = 3;
      } else if (var3 == 2) {
         var1.defence += 20;
         this.lucky_number = 2;
      } else if (var3 == 1) {
         var1.defence += 50;
         var1.health += 5;
         if (var1.health > 100) {
            var1.health = 100;
         }

         this.lucky_number = 1;
      }

   }

   public void ending_bonus(PT var1) {
      if (this.lucky_number == 3) {
         var1.defence -= 10;
      } else if (this.lucky_number == 2) {
         var1.defence -= 20;
      } else if (this.lucky_number == 1) {
         var1.defence -= 50;
      }

   }
}
