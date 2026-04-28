package mc322.project;
//bibliotecas
import java.util.Scanner;
/**
 * Responsável por iniciar o sistema de combate, gerenciar o loop principal
 * do jogo e controlar as interações entre herói, inimigo e cartas.
 */
public class Batalha extends Eventos{
    int num;
    boolean visit;

    public Batalha(int num) {
        this.num = num;
    }
/**
 * Método que inicia o jogo.
 * @param args
 */    public void luta(Heroi pt, Scanner scan) {

        System.out.println("                                         Um Nuko está bloqueando a passagem");


        Inimigo op = new Inimigo();
        Publisher jogo = new Publisher();
        Baralho bar = new Baralho();
        Mao mao = pt.getMao();

        for (int i = 0; i < 4; i++) {
            mao.adicionar(bar.comprarCarta());
        }

        //compra inicial

        while (op.health_status_op() && iniciar(pt)) {
            op.decisão();

            int esc = 1;

            //turno do heroi
            while(pt.energy > 0 && !(esc == 0) && (op.health_status_op() && iniciar(pt))) {
                
                op.ASCII();
                op.show();
                
                pt.ASCII();
                pt.show(); 
                
                mao.mostrar();

                int choice = scan.nextInt();
                esc = choice;

                if (choice > 0 && choice <= mao.tamanho()) {

                    Carta carta = mao.remover(choice - 1);
                    mao.adicionar(bar.comprarCarta());

                    if (pt.energy >= carta.custo) {
                        carta.usar(op, pt, jogo);
                        pt.energy -= carta.custo;
                        System.out.println("\n>>> Voce usou: " + carta.nome);
                        bar.descartar(carta);
                    } else {
                        System.out.println("\n>>> Energia insuficiente!");
                        mao.adicionar(carta); // Devolve a carta pra mao se falhar
                    }

                } else if (choice == 0) {
                    System.out.println("\n>>> Turno encerrado.");
                } else {
                    System.out.println("\n>>> Opcao invalida.");
                }
            }
            if (!op.health_status_op() || !iniciar(pt)) {
                break;
            }

            System.out.println("\n--- PROCESSANDO EFEITOS DE FIM DE TURNO ---");
            jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

            if (op.health_status_op()) {
                System.out.println("\n=== TURNO DO INIMIGO ===");
                // 3. INJEÇÃO DE DEPENDÊNCIA: Inimigo também precisa do jogo para aplicar veneno
                op.batalha(pt, jogo);
            }
            jogo.fim_de_jogo();
            
            pt.receive_energy();
            op.receive_energy();
        }

        if (op.health_status_op()) {
            System.out.println("\nVOcẽ não deveria ter começado essa batalha");
        } else {
            System.out.println("\nO Nuko desapareceu");
        }

        this.visit = true;

    }
}