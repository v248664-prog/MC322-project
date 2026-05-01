package mc322.project;

import java.util.Scanner;

/**
 * Interface que define uma opção interativa disponível ao herói.
 */
public interface Opcoes {
    /**
     * Executa o efeito da opção sobre o herói.
     * @param pt
     * @param scan
     */
    public void exe(Heroi pt, Scanner scan);
    /**
     * Retorna o nome de exibição da opção.
     * @return
     */
    public String getNome();
}
