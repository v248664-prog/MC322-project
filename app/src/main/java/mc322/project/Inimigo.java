package mc322.project;
import java.util.Random;

public class Inimigo extends Entidade {

    int escolha;

    /**
     * atributos básicos estabelecidos pela classe abstrata
     * Entidade
     */
    public Inimigo() {
        this.name = "NUKO";
        this.attack = 30;
        this.defence = 10;
        this.energy = 30;
        this.health = 360;
    }

    /**
     * ele funciona como um sistema simples para
     * organizar o combate, se estiver vivo continua,
     * se não, ele encerrar
     */
    public boolean health_status_op() {
        return this.health > 0;
    }

    /**
     * ataque básico do oponente
     */
    public void bite(Heroi prota) {
        this.energy -= 5;
        prota.receive_damage(this.attack);

        if (prota.health < 0) {
            prota.health = 0;
        }
    }

    /**
     * surpriendentemente, esse ataque até que faz muito sentido
     * lol, dado que é meio que um ser parecido com um cogumelo
     */
    public void aplicarVenenoNoHeroi(Heroi prota, Publisher jogo) {
        this.energy -= 10; // Custa 10 de energia para o inimigo
        EfeitoVeneno veneno = new EfeitoVeneno(prota, 2, 10); // Aplica 2 acúmulos
        prota.aplicarEfeito(veneno, jogo);
    }

    /**
     * Sistema de dano básico
     */
    public void receive_damage(int dmg) {
        this.health -= (int) (dmg * ((100.0 - this.defence) / 100.0));

        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * uma das primeiras funções criadas
     * inclusive, acho que a primeira ação
     * cura do oponente
     */
    public void recover_health() {
        this.energy -= 5;
        this.health += 60;

        if (this.health > 360) {
            this.health = 360;
        }
    }

    /**
     * recarrega a energia do oponente
     */
    public void recover_energy() {
        this.energy = 30;
    }

    /**
     * mostra a vida dele, por questões de jogabilidade
     * mas, pessoalmente, eu acho interessante a ideia de não saber
     * mesmo que isso não seja implementado
     */
    public void show() {
        System.out.println("                                               NUKO's health: " + this.health);
        this.mostrarEfeitos();
    }

    /**
     * recarrega a energia do oponente
     */
    public void receive_energy() {
        this.energy = 30;
    }

    /**
     * sistema de decisão do ponto extra
     * o sistema de decisão foi construido com random
     * por ser simplesmente mais prático, eu posso aplicar
     * 'ponderadas' de forma a dar mais chance ou menos chance
     * sem perder muito temp tentando desenvolver estratégias
     * para cada inimigo
     * 
     * aqui, ele pode se curar, atacar ou envenenar o heroi
     */
    public void decisão() {
        Random ram = new Random();
        int chance = ram.nextInt(10);

        if (this.energy > 10) {
            if (chance == 7 || chance == 8) {
                this.escolha = 0;
                System.out.println("                                      O inimigo decidiu atacar");
            } else if (chance < 6) {
                this.escolha = 2; // --- NOVO: Opção 3 adicionada (Ação de Efeito) ---
                System.out.println("                                      O inimigo decidiu preparar um ataque toxico");
            } else {
                this.escolha = 1;
                System.out.println("                                      O inimigo decidiu se curar");
            }
        } 
    }

    /**
     * a concretização do sistema de decisão
     * a decisão é declarada primero para, no
     * final do turno do heroi ser executada
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
     * desenho do inimigo
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