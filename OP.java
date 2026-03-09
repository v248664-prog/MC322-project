public class OP {
   String name = "NUKO";
   int defence = 10;
   int attack = 20;
   int health = 120;

   public OP() {
   }

   public boolean health_status() {
      return this.health > 0;
   }

   public void bite(PT var1) {
      var1.health -= this.attack;
      if (var1.health < 0) {
         var1.health = 0;
      }

   }

   public void receive_damage(int var1) {
      this.health -= (int)((double)var1 * (((double)100.0F - (double)this.defence) / (double)100.0F));
      if (this.health < 0) {
         this.health = 0;
      }

   }

   public void recover_health() {
      this.health += 20;
      if (this.health > 100) {
         this.health = 100;
      }

   }

   public void show_health_op() {
      System.out.println("NUKO's health: " + this.health);
   }
}
