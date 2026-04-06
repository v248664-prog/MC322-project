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

        // 1. AQUI ENTRA O OBSERVER: Criando o publicador de eventos do jogo
        Publisher jogo = new Publisher();

        ArrayList<Carta> pilhaCompra = new ArrayList<>();
        ArrayList<Carta> mao = new ArrayList<>();
        ArrayList<Carta> pilhaDescarte = new ArrayList<>();
        //criação dos arrays

        // Deck, sempre entre 40-60 lol
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano2()); // Lembre-se de colocar o Publisher no usar() desta tbm
        }
        for (int i = 0; i < 10; i++) {
            pilhaCompra.add(new CartaEscudo());
        }
        for (int i = 0; i < 10; i++) {
            pilhaCompra.add(new CartaVeneno());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaRegeneracao());
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
                if (!pilhaCompra.isEmpty() && mao.size() < 4) { // Pequena trava p/ mao n crescer infinito
                    mao.add(pilhaCompra.remove(0));
                }
                System.out.println("");
                pt.show();
                op.show(); 
                System.out.println("");
                
                for (int i = 0; i < mao.size(); i++) {
                    Carta c = mao.get(i);
                    System.out.print((i + 1) + "." + c.nome + "(Custo: " + c.custo + ")  ");
                }
                System.out.print("\n0. Pular turno\n");

                int choice = scam.nextInt();
                esc = choice;
                System.out.println("");

                if (choice > 0 && choice <= mao.size()) {

                    Carta cartaEscolhida = mao.remove(choice - 1);

                    if (pt.energy >= cartaEscolhida.custo) {
                        cartaEscolhida.usar(op, pt, jogo);
                        pt.energy -= cartaEscolhida.custo;
                        System.out.println("\n>>> Voce usou: " + cartaEscolhida.nome);
                    } else {
                        System.out.println("\n>>> Energia insuficiente!");
                        mao.add(cartaEscolhida); // Devolve a carta pra mao se falhar
                        continue; 
                    }

                    pilhaDescarte.add(cartaEscolhida);

                } else if (choice == 0) {
                    System.out.println("\n>>> Turno encerrado.");
                } else {
                    System.out.println("\n>>> Opcao invalida.");
                }
            }

            System.out.println("\n--- PROCESSANDO EFEITOS DE FIM DE TURNO ---");
            jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

            pilhaDescarte.addAll(mao);
            mao.clear();

            for (int i = 0; i < 4; i++) {
                if (!pilhaCompra.isEmpty()) {
                    mao.add(pilhaCompra.remove(0));
                }
            }

            if (op.health_status_op()) {
                System.out.println("\n=== TURNO DO INIMIGO ===");
                // 3. INJEÇÃO DE DEPENDÊNCIA: Inimigo também precisa do jogo para aplicar veneno
                op.batalha(pt, jogo);
            }

            for (Carta c : pilhaDescarte) {
                if (c instanceof CartaEscudo) {
                    CartaEscudo escudo = (CartaEscudo) c;
                    if (escudo.tryed) {
                        escudo.ending_bonus(pt);
                    }
                }
            }
            
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