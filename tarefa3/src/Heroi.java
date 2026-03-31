public class Heroi extends Entidade{
   Carta[] mao = new Carta[7];
public Heroi() {
        this.name = "Heroi"; 
        this.attack = 0;     
        this.defence = 0;    
        this.energy = 30;    
        this.health = 100;   
}
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
      this.energy = 30;
   }
   // regen da energia

   public void show() {
      System.out.println("Your health: " + this.health);
      System.out.println("Your energy: " + this.energy);
   }
   // mostra os dados mais importantes
}