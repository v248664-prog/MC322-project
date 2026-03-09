import java.util.Random;

public class OLD_BOMB {
   int qnt;

   public OLD_BOMB(int var1) {
      this.qnt = var1;
   }

   public void activate(OP var1, PT var2) {
      if (this.qnt >= 1) {
         var2.energy -= 3;
         Random var3 = new Random();
         int var4 = var3.nextInt(100);
         var1.receive_damage(var4);
         --this.qnt;
      }

   }
}
