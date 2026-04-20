package mc322.project;
//bibliotecas
import java.util.Scanner;
import java.util.ArrayList;     
import java.util.Collections;
/**
 * Responsável por iniciar o sistema de combate, gerenciar o loop principal
 * do jogo e controlar as interações entre herói, inimigo e cartas.
 */
public class Batalha {
    int num;

    public Batalha(int num) {
        this.num = num;
    }
/**
 * Método que inicia o jogo.
 * @param args
 */    public void luta(Heroi pt, Scanner scan) {

        System.out.println("                                         Um Nuko está bloqueando a passagem");
        // o cenário inicial se mantem


        Inimigo op = new Inimigo();

        // 1. AQUI ENTRA O OBSERVER: Criando o publicador de eventos do jogo
        Publisher jogo = new Publisher();

        ArrayList<Carta> pilhaCompra = new ArrayList<>();
        ArrayList<Carta> mao = new ArrayList<>();
        ArrayList<Carta> pilhaDescarte = new ArrayList<>();
        //criação dos arrays

        // Deck, sempre entre 40-60 lol, lembre de fazer a classe do deck
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano2()); // Lembre-se de colocar o Publisher no usar() desta tbm
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano3());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano4());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano5());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaEscudo());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaEscudo2());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaVeneno());
        }
        for (int i = 0; i < 10; i++) {
            pilhaCompra.add(new CartaRegeneracao());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaQueimadura());
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
                
                op.ASCII();
                op.show();
                
                pt.ASCII();
                pt.show(); 
                
                for (int i = 0; i < mao.size(); i++) {
                    Carta c = mao.get(i);
                    System.out.print((i + 1) + "." + c.nome + "(Custo: " + c.custo + ")  ");
                }
                System.out.print("0. Pular turno\n");

                int choice = scan.nextInt();
                esc = choice;

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
                    if (escudo.tried) {
                        escudo.ending_bonus(pt);
                    }
                }
            }
            
            pt.receive_energy();
            op.receive_energy();
        }

        if (op.health_status_op()) {
            System.out.println("\nVOcẽ não deveria ter começado essa batalha");
        } else {
            System.out.println("\nO Nuko desapareceu");
        }

    }
}