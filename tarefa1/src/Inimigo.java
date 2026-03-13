public class Inimigo {

   String name = "NUKO";
   int defence = 10;
   int attack = 20;
   int health = 120;
   //atributos do inimigo

   public boolean health_status_op() {
      return this.health > 0;
   }
   //checagem de vida

   public void bite(Heroi prota) {
      prota.receive_damage(this.attack);

      if (prota.health < 0) {
         prota.health = 0;
      }
   }
   // ataque basico

   public void receive_damage(int dmg) {

      this.health -= (int)(dmg * ((100.0 - this.defence) / 100.0));

      if (this.health < 0) {
         this.health = 0;
      }
   }
   // dano

   public void show_health_op() {
      System.out.println("NUKO's health: " + this.health);
   }
   //print da vida
}