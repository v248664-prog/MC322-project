public class PT {
   int defence = 0;
   int attack = 0;
   int health = 100;
   int energy = 30;
   int storage = 30;

   public PT() {
   }

   public boolean health_status() {
      return this.health > 0;
   }

   public void receive_damage(int var1) {
      this.health -= (int)((double)var1 * (((double)100.0F - (double)this.defence) / (double)100.0F));
      if (this.health < 0) {
         this.health = 0;
      }

   }

   public void recover_health() {
      this.health += 10;
      if (this.health > 100) {
         this.health = 100;
      }

   }

   public void receive_energy() {
      this.energy += 3;
      if (this.energy > 30) {
         this.energy = 30;
      }

   }

   public void show_health_pt() {
      System.out.println("your health: " + this.health);
   }
}