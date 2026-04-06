import java.util.Random;

public class Inimigo extends Entidade {

    int escolha;

    // Construtor: Inicializa as variáveis da classe mãe (Entidade)
    // Isso resolve o problema de encapsulamento e sombreamento!
    public Inimigo() {
        this.name = "NUKO";
        this.attack = 10;
        this.defence = 10;
        this.energy = 30;
        this.health = 120;
    }

    public boolean health_status_op() {
        return this.health > 0;
    }

    public void bite(Heroi prota) {
        this.energy -= 5;
        prota.receive_damage(this.attack);

        if (prota.health < 0) {
            prota.health = 0;
        }
    }

    // --- NOVO: Método para integrar o Padrão Observer (Veneno) ---
    public void aplicarVenenoNoHeroi(Heroi prota, Publisher jogo) {
        this.energy -= 10; // Custa 10 de energia para o inimigo
        EfeitoVeneno veneno = new EfeitoVeneno(prota, 2); // Aplica 2 acúmulos
        prota.aplicarEfeito(veneno, jogo);
    }

    public void receive_damage(int dmg) {
        this.health -= (int) (dmg * ((100.0 - this.defence) / 100.0));

        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void recover_health() {
        this.energy -= 10;
        this.health += 10;

        if (this.health > 120) { // NUKO tem 120 de cap de vida
            this.health = 120;
        }
    }

    public void recover_energy() {
        this.energy = 30;
    }

    public void show() {
        System.out.println("NUKO's health: " + this.health);
        this.mostrarEfeitos(); // Mostra os efeitos (se vc jogar veneno nele, aparece aqui)
    }

    public void receive_energy() {
        this.energy += 3;

        if (this.energy > 30) {
            this.energy = 30;
        }
    }

    public void decisão() {
        Random ram = new Random();
        int chance = ram.nextInt(10);

        if (this.energy > 10) {
            if (chance < 5) {
                this.escolha = 0;
                System.out.println("O inimigo decidiu atacar");
            } else if (chance < 8) {
                this.escolha = 3; // --- NOVO: Opção 3 adicionada (Ação de Efeito) ---
                System.out.println("O inimigo decidiu preparar um ataque toxico");
            } else {
                this.escolha = 1;
                System.out.println("O inimigo decidiu se curar");
            }
        } else {
            this.escolha = 2;
            System.out.println("O inimigo decidiu recuperar energia");
        }
    }

    public void batalha(Heroi prota, Publisher jogo) {
        if (this.health_status_op()) {
            if (this.escolha == 0) {
                bite(prota);
                System.out.println("\nO inimigo atacou");
            } else if (this.escolha == 1) {
                recover_health();
                System.out.println("\nO inimigo se curou");
            } else if (this.escolha == 2) {
                receive_energy();
                System.out.println("\nO inimigo recuperou a sua energia");
            } else if (this.escolha == 3) {
                // --- NOVO: Inimigo executa o veneno no Herói ---
                aplicarVenenoNoHeroi(prota, jogo);
                System.out.println("\nO inimigo te envenenou!");
            }
        }
    }
}