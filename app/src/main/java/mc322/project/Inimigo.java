package mc322.project;
import java.util.Random;

/**
 * Classe que representa o inimigo do jogo.
 */
public class Inimigo extends Entidade {

    int escolha;

    /**
    * Construtor do inimigo.
    * Inicializa os atributos base como vida, energia e defesa.
    */
    public Inimigo() {
        this.name = "NUKO";
        this.attack = 20;
        this.defence = 0;
        this.energy = 30;
        this.health = 160;
    }

    public Inimigo(int H, int A, int defence) {
        this.name = "NUKO SUPREMO";
        this.attack = A;
        this.defence = defence;
        this.energy = 30;
        this.health = H;
    }

    /**
    * Verifica se o inimigo ainda está vivo.
    * 
    * @return true se a vida for maior que zero, false caso contrário.
    */
    public boolean health_status_op() {
        return this.health > 0;
    }

    /**
    * Realiza um ataque direto ao herói.
     * 
    * @param prota herói que receberá o dano.
    */
    public void bite(Heroi prota) {
        this.energy -= 5;
        prota.receive_damage(this.attack);

        if (prota.health < 0) {
            prota.health = 0;
        }
    }

    /**
    * Aplica o efeito de veneno no herói.
    * 
    * @param prota herói afetado.
    * @param jogo sistema de eventos.
    */
    public void aplicarVenenoNoHeroi(Heroi prota, Publisher jogo) {
        this.energy -= 10; // Custa 10 de energia para o inimigo
        EfeitoVeneno veneno = new EfeitoVeneno(prota, 2, 10); // Aplica 2 acúmulos
        prota.aplicarEfeito(veneno, jogo);
    }

    /**
    * Aplica dano ao inimigo considerando sua defesa.
    * 
    * @param dmg dano recebido.
    */
    public void receive_damage(int dmg) {
        this.health -= (int) (dmg * ((100.0 - this.defence) / 100.0));

        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
    * Recupera uma quantidade fixa de vida do inimigo.
    */
    public void recover_health() {
        this.energy -= 5;
        this.health += 60;

        if (this.health > 360) {
            this.health = 360;
        }
    }

    /**
    * Exibe o estado atual do inimigo no terminal.
    */
    public void show() {
        System.out.println("                                               NUKO's health: " + this.health);
        this.mostrarEfeitos();
    }

    /**
    * Restaura a energia do inimigo ao início de um novo turno.
    */
    public void receive_energy() {
        this.energy = 30;
    }

    /**
    * Define a ação que o inimigo irá executar no turno.
    * 
    * A decisão é baseada em um valor aleatório, podendo resultar em:
    * - Ataque direto;
    * - Aplicação de veneno;
    * - Recuperação de vida.
    */
    public void decisão() {
        Random ram = new Random();
        int chance = ram.nextInt(10);

        if (this.energy > 10) {
            if (chance < 4) {
                this.escolha = 0;
                System.out.println("                                      O inimigo decidiu atacar");
            } else if (chance < 8) {
                this.escolha = 2; // --- NOVO: Opção 3 adicionada (Ação de Efeito) ---
                System.out.println("                                      O inimigo decidiu preparar um ataque toxico");
            } else {
                this.escolha = 1;
                System.out.println("                                      O inimigo decidiu se curar");
            }
        } 
    }

    /**
    * Executa a ação previamente escolhida pelo inimigo.
    * 
    * @param prota herói alvo das ações
    * @param jogo sistema de eventos para aplicação de efeitos
    */
    public void batalha(Heroi prota, Publisher jogo) {
        if (this.health_status_op()) {
            if (this.escolha == 0) {
                bite(prota);
                System.out.println("\nO inimigo atacou");
            } else if (this.escolha == 1) {
                recover_health();
                System.out.println("\n O inimigo se curou");
            } else if (this.escolha == 2) {
                // --- NOVO: Inimigo executa o veneno no Herói ---
                aplicarVenenoNoHeroi(prota, jogo);
                System.out.println("\nO inimigo te envenenou!");
            }
        }
    }

   /**
    * Exibe a representação ASCII do inimigo.
    */
    public void ASCII() {
      System.out.println("                                      _____       ___________");
        System.out.println("                                ____/    /    /    \\     \\  \\_____");
        System.out.println("                                       \\_____/ ____\\____\\__\\/___\\");
        System.out.println("                                                     /O  O\\");
        System.out.println("                                                     \\_  _/");
        System.out.println("                                                      _\\/_");
        System.out.println("                                                    /      \\");
        System.out.println("                                                   |        |");
        System.out.println("                                                   |        |");
        System.out.println("                                                 _/          \\_");
        System.out.println("                                              /         \\     / \\");
        System.out.println("                                             | __________ \\");
   }
   //print do inimigo
}