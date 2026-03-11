package src;

public class Inimigo {

   String name = "NUKO";
   int defence = 10;
   int attack = 20;
   int health = 120;

   public boolean health_status_op() {
      return this.health > 0;
   }

   public void bite(Heroi prota) {
      prota.health -= this.attack;

      if (prota.health < 0) {
         prota.health = 0;
      }
   }

   public void receive_damage(int dmg) {

      this.health -= (int)(dmg * ((100.0 - this.defence) / 100.0));

      if (this.health < 0) {
         this.health = 0;
      }
   }

   public void show_health_op() {
      System.out.println("NUKO's health: " + this.health);
   }
}