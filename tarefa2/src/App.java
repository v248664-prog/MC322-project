//bibliotecas
import java.util.Scanner;
import java.util.ArrayList;     
import java.util.Collections;

public class App {

   public static void main(String[] args) {

      System.out.println("");
      System.out.println("An Adult Nuko is blocking the passage");
      System.out.println("");
      // o cenário inicial se mantem

      Scanner scam = new Scanner(System.in);

      Inimigo op = new Inimigo();
      Heroi pt = new Heroi();

      ArrayList<Carta> pilhaCompra = new ArrayList<>();
      ArrayList<Carta> mao = new ArrayList<>();
      ArrayList<Carta> pilhaDescarte = new ArrayList<>();
      //criação dos arrays

      // Deck, sempre entre 40-60 lol
      for (int i = 0; i < 20; i++) {
         pilhaCompra.add(new CartaDano());
      }
      for (int i = 0; i < 20; i++) {
         pilhaCompra.add(new CartaDano2());
      }
      for (int i = 0; i < 20; i++) {
         pilhaCompra.add(new CartaEscudo());
      }

      Collections.shuffle(pilhaCompra);

      for (int i = 0; i < 4; i++) {
            if (!pilhaCompra.isEmpty()) {
               mao.add(pilhaCompra.remove(0));
            }
         }
      //compra inicial

      while (op.health_status_op() && pt.health_status()) {
        op.decisão();

         System.out.println("\n=== SEU TURNO ===");
         if (pilhaCompra.isEmpty()) {
            pilhaCompra.addAll(pilhaDescarte);
            pilhaDescarte.clear();
            Collections.shuffle(pilhaCompra);
         }
         //manejamento do deck

         int esc = 1;

         //turno do heroi
         while(pt.energy > 0 && !(esc == 0)) {
            if (!pilhaCompra.isEmpty()) {
               mao.add(pilhaCompra.remove(0));
               // compra para manter em 4 sempre
            }
            System.out.println("");
            pt.show();
            //info dos status
            System.out.println("");
            for (int i = 0; i < mao.size(); i++) {
               Carta c = mao.get(i);
               System.out.print((i + 1) + "." + c.nome + "(Custo: " + c.custo + ")  ");
            }
            //cartas
            System.out.print("0. Pular turno");
            //importante
            System.out.println("");

            int choice = scam.nextInt();
            esc = choice;
            // gambiarra
            System.out.println("");

            if (choice > 0 && choice <= mao.size()) {

               Carta cartaEscolhida = mao.remove(choice - 1);
               // sistema de cemiterio

               if (pt.energy >= cartaEscolhida.custo) {
                  cartaEscolhida.usar(op, pt);
                  // uso do escolhido
                  pt.energy -= cartaEscolhida.custo;
                  // gasto
                  System.out.println("\n>>> Voce usou: " + cartaEscolhida.nome);
               } else {
                  System.out.println("\n>>> Energia insuficiente!");
               }

               pilhaDescarte.add(cartaEscolhida);
               //recebimento da carta

            } else if (choice == 0) {
               System.out.println("\n>>> Turno encerrado.");
            } else {
               System.out.println("\n>>> Opcao invalida.");
            }
            System.out.println("");
            op.show();
            // como acoes repetem(noçao de dano e tals);
            System.out.println("");

         }

         pilhaDescarte.addAll(mao);
         mao.clear();

         for (int i = 0; i < 4; i++) {
            if (!pilhaCompra.isEmpty()) {
               mao.add(pilhaCompra.remove(0));
            }
         }

         if (op.health_status_op()) {
            System.out.println("\n=== TURNO DO INIMIGO ===");
            op.batalha(pt);
         }

         pt.show();
         System.out.println("");

         for (Carta c : pilhaDescarte) {
            if (c instanceof CartaEscudo) {
               CartaEscudo escudo = (CartaEscudo) c;
               if (escudo.tryed) {
                  escudo.ending_bonus(pt);
               }
            }
         }
         // garante que cada instancia de hide vai ser revertida, talvez
         // isso resulte na mudança dos valores de hide
         pt.receive_energy();
         op.receive_energy();
        System.out.println();
      }

      if (op.health_status_op()) {
         System.out.println("\nYou shouldn't have started a battle you couldn't win");
      } else {
         System.out.println("\nThe Nuko ran away");
      }

      scam.close();
   }
}