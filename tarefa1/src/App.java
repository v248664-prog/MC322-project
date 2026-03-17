import java.util.Scanner;

public class App {

   public static void main(String[] args) {
      //tentando chegar ao topo da cidade, voce se encontra com um nuko

      System.out.println("");
      System.out.println("An Adult Nuko is blocking the passage");
      System.out.println("");

      Scanner scam = new Scanner(System.in);
      // para a escolha

      Inimigo op = new Inimigo();
      Heroi pt = new Heroi();
      // atores

      CartaDano bomb = new CartaDano(10);
      CartaDano2 gun = new CartaDano2(20);
      CartaEscudo hide = new CartaEscudo(10);
      // objetos

      while (op.health_status_op() && pt.health_status()) {

         System.out.println("1. Use the gun");
         System.out.println("2. Throw the bomb");
         System.out.println("3. Hide");
         System.out.println("4. Recover");
         System.out.println("");
         //opcoes

         int choice = scam.nextInt();

         if (choice == 1 && pt.energy >= 2) {

            if (gun.charged) {
               gun.shoot(op, pt);
            } else {
               gun.charge(pt);
            }

         }
         else if (choice == 2) {

            bomb.usar(op, pt);

         }
         else if (choice == 3) {

            hide.find_shelter(pt);

         }
         else if (choice == 4) {

            System.out.println("");
            System.out.println("1. restore health");
            System.out.println("2. recover energy");
            System.out.println("");

            int rec = scam.nextInt();

            if (rec == 1) {
               pt.recover_health();
            } else {
               pt.recover_energy();
            }
         }

         if (op.health_status_op()) {
            op.bite(pt);
         }
         // turno do nuko

         System.out.println("");
         op.show();
         System.out.println("");
         pt.show();
         System.out.println("");
         // status da batalha

         if (hide.tryed == true) {
            hide.ending_bonus(pt);
         }
         //fim do bonus
      }

      if (op.health_status_op()) {

         System.out.println("");
         System.out.println("You shouldn't have started a battle you couldn't win");

      } else {

         System.out.println("");
         System.out.println("The Nuko isn't moving anymore");
      }
      // vencedor

      scam.close();
   }
}