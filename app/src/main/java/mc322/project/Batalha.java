package mc322.project;
//bibliotecas
import java.util.Scanner;

/**
 * Responsável por iniciar o sistema de combate, gerenciar o loop principal
 * do jogo e controlar as interações entre herói, inimigo e cartas.
 */
public class Batalha extends Eventos{
    public int num;
    boolean Final;

    public Batalha(int num,boolean Final) {
        super(num);
        this.num = num;
        this.Final = Final;
    }


    /**
    * Método que inicia o jogo.
    * @param args
    */    
    public void iniciar(Heroi pt, Scanner scan) {

    Inimigo op;
    if (Final) {
        op = new Inimigo(430, 40, 20);
    } else {
        System.out.println("                                    A passagem está bloqueada");
        op = new Inimigo();
    }
    Baralho bar = pt.getBaralho();
    Publisher jogo = new Publisher();
    pt.energy = pt.energy_total;
    Mao mao = pt.getMao();

    for (int i = 0; i < 4; i++) {
        mao.adicionar(bar.comprarCarta());
    }

    //compra inicial

    while (op.health_status_op() && pt.health_status()) {
        op.decisão();

        int esc = 1;

        //turno do heroi
        while(pt.energy > 0 && !(esc == 0) && (op.health_status_op() && pt.health_status())) {
                
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
            if (!op.health_status_op() || !pt.health_status()) {
                break;
            }

            System.out.println("\n--- PROCESSANDO EFEITOS DE FIM DE TURNO ---");
            jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

            if (op.health_status_op()) {
                System.out.println("\n=== TURNO DO INIMIGO ===");
                // 3. INJEÇÃO DE DEPENDÊNCIA: Inimigo também precisa do jogo para aplicar veneno
                op.batalha(pt, jogo);
            }
            
            CartaEscudo escudo = new CartaEscudo();
            escudo.ending_bonus(pt);
            pt.receive_energy();
            op.receive_energy();
        }
        jogo.fim_de_jogo();

        if (op.health_status_op()) {
            System.out.println("\nVocê não deveria ter começado essa batalha");
        } else {
            System.out.println("\nO inimigo desapareceu");
            System.out.println("\nVocê obteu 30 de ouro aṕos vencer a batalha");
            pt.ouro += 30;
            if (pt.energy_total > 30) {
                pt.energy = pt.energy_total = 30;
            }
        }

        this.visit = true;

    }
}