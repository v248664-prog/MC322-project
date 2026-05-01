package mc322.project;

import java.util.Scanner;

/**
 * Restaura 30 pontos de vida, respeitando o limite máximo de 100.
 */
public class Descansar implements Opcoes {

    protected String nome = "Descansar";
    
    public void exe(Heroi pt, Scanner scan) {
        pt.health += 30;
        System.out.println("+30 de vida. Você se sente em paz");
        if (pt.health > 100) {
                pt.health = 100; // Limite máximo de vida do Herói
        }
    }

    /**
     * Retorna o nome de exibição da opção.
     * @return
     */
    public String getNome() {
        return this.nome;
    }
}
