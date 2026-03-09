import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
      System.out.println("");
      System.out.println("An Adult Nuko is blocking the passage");
      System.out.println("");
      Scanner var1 = new Scanner(System.in);
      OP var2 = new OP();
      PT var3 = new PT();
      OLD_BOMB var4 = new OLD_BOMB(10);
      RUSTYGUN var5 = new RUSTYGUN(20);
      HIDE var6 = new HIDE(0);

      while(var2.health_status() && var3.health_status()) {
         System.out.println("1. Use the gun");
         System.out.println("2. Throw the bomb");
         System.out.println("3. Hide");
         System.out.println("4. Recover");
         System.out.println("");
         int var7 = var1.nextInt();
         if (var7 == 1 && var3.energy >= 1) {
            if (var5.charged) {
               var5.shoot(var2, var3);
            } else {
               var5.charge(var3);
            }
         } else if (var7 == 2 && var3.energy >= 1) {
            var4.activate(var2, var3);
         } else if (var7 == 3 && var3.energy >= 1) {
            var6.find_shelter(var3);
         } else if (var7 == 4) {
            System.out.println("");
            System.out.println("1. restore health");
            System.out.println("2. recover energy");
            System.out.println("");
            var7 = var1.nextInt();
            if (var7 == 1) {
               var3.receive_energy();
            } else {
               var3.recover_health();
            }
         }

         if (var2.health_status()) {
            var2.bite(var3);
         }

         System.out.println("");
         var2.show_health_op();
         System.out.println("");
         var3.show_health_pt();
         System.out.println("");
         var6.ending_bonus(var3);
      }

      if (var2.health_status()) {
         System.out.println("health pt: 0");
         System.out.println("You shouldnt have started a battle you couldnt win");
      } else {
         var3.show_health_pt();
         System.out.println("");
         System.out.println("The Nuko isn't moving anymore");
      }

      var1.close();
   }
}