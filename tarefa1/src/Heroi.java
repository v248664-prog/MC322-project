public class Heroi {

   int defence = 0;
   int attack = 0;
   int health = 100;
   int energy = 30;
   //atributos do heroi

   public boolean health_status() {
      return this.health > 0;
   }
   // checagem de vida

   public void receive_damage(int dmg) {

      this.health -= (int)(dmg * ((100.0 - this.defence) / 100.0));

      if (this.health < 0) {
         this.health = 0;
      }
   }
   // recebe dano

   public void recover_health() {

      this.health += 10;

      if (this.health > 100) {
         this.health = 100;
      }
   }
   // cura

   public void receive_energy() {

      this.energy += 3;

      if (this.energy > 30) {
         this.energy = 30;
      }
   }
   // regen da energia

   public void show_pt() {
      System.out.println("Your health: " + this.health);
      System.out.println("Energy: " + this.energy);
   }
   //print da vida
}