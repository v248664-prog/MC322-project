import java.util.Random;

public class Inimigo extends Entidade{

   String name = "NUKO";
   int attack = 20;
   int defence = 10;
   int energy = 30;
   int health = 120;
   int escolha;
   //atributos do inimigo

   public boolean health_status_op() {
      return this.health > 0;
   }
   //checagem de vida

   public void bite(Heroi prota) {
      this.energy -= 5;
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

   public void recover_health() {
      this.energy-= 10;

      this.health += 10;

      if (this.health > 100) {
         this.health = 100;
      }
   }

   public void recover_energy() {

      this.energy += 30;

      if (this.energy > 30) {
         this.energy = 30;
      }
   }

   public void show() {
      System.out.println("NUKO's health: " + this.health);
   }
   //print da vida

   public void decisão() {
      Random ram = new Random();
      this.escolha = ram.nextInt(9);
      if (escolha == 0) {
         System.out.println("O inimigo se curou");
      }
      if (escolha == 1) {
         System.out.println("O inimigo atacou");
      }
   }

   public void batalha(Heroi prota) {
      if (this.health_status_op()) {
         if (this.energy > 0) {
            if (this.escolha == 0) {
               bite(prota);
            }
            else if(this.escolha == 1) {
               recover_health();
            }
         }
      }
   }
}