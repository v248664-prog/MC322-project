package mc322.project;

import java.util.Scanner;

public class Reedesenhar implements Opcoes{
    
    protected String nome = "Reorganizar o Deck";
    
    public void exe(Heroi pt, Scanner scan) {
        Baralho bar = pt.getBaralho();
        bar.Montar_Baralho(scan);
    }

    public String getNome() {
        return this.nome;
    }
}
