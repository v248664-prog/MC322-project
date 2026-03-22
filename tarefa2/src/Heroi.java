import java.util.Scanner;

public class Heroi extends Entidade{

   String name;
   int attack = 0;
   int defence = 0;
   int energy = 30;
   int health = 100;
   Carta[] mao = new Carta[7];
   
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

   public void recover_energy() {

      this.energy += 30;

      if (this.energy > 30) {
         this.energy = 30;
      }
   }
   // regen da energia

   public void show() {
      System.out.println("Your health: " + this.health);
      System.out.println("Energy: " + this.energy);
   }

   public void batalha(Inimigo op, CartaDano bomb, CartaDano2 gun, CartaEscudo hide) {
      Scanner scam = new Scanner(System.in);
      if(this.energy > 0) {

         System.out.println("1. Use the gun");
         System.out.println("2. Throw the bomb");
         System.out.println("3. Hide");
         System.out.println("4. Recover");
         System.out.println("");
         //opcoes

         int choice = scam.nextInt();

         if (choice == 1 && this.energy >= 2) {

            if (gun.charged) {
               gun.shoot(op, this);
            } else {
               gun.charge(this);
            }

         }
         else if (choice == 2) {

            bomb.usar(op, this);

         }
         else if (choice == 3) {

            hide.find_shelter(this);

         }
         else if (choice == 4) {

            System.out.println("");
            System.out.println("1. restore health");
            System.out.println("2. recover energy");
            System.out.println("");

            int rec = scam.nextInt();

            if (rec == 1) {
               this.recover_health();
            } else {
               this.recover_energy();
            }
         }
      }
   scam.close();
   }
}