package mc322.project;

import java.util.Scanner;

public class Reedesenhar implements Opcoes{
    
    protected String nome = "Reorganizar o Deck";
    
    /**
     * Inicia a montagem personalizada do baralho do herói.
     *
     * @param pt
     * @param scan
     */
    public void exe(Heroi pt, Scanner scan) {
        Baralho bar = pt.getBaralho();
        bar.Montar_Baralho(scan);
    }

    /**
     * Retorna o nome de exibição da opção.
     * @return
     */
    public String getNome() {
        return this.nome;
    }
}
