package mc322.project;

import java.util.List;
import java.util.Scanner;

public class Loja extends Eventos{
    int num;

    /**
     * Construtor do evento de loja.
     * @param num
     */
    public Loja(int num) {
        super(num);
    }
    
    /**
     * Inicia o evento de loja.
     * @param pt
     * @param scan
     */
    public void iniciar(Heroi pt, Scanner scan){
        Baralho bar = pt.getBaralho();
        System.out.println("""
          /  /   /   /   /   /   /  /
        /  /   /   /   /   /   /   / /
            |                    |
            |                    |
            |____________________|
            |                    |
            |       LOJA         |
            |____________________|
        O vendedor não está aqui. Mas, isso
                não te permite roubar
        """);

        List<Produtos> itens = Factory.gerarObjetos(bar);

        for (int i = 0; i < itens.size(); i++) {
            Produtos item = itens.get(i);
            System.out.println(i + ": " + item.getNome() + " / Preço: " + item.getPreco());
        }
        System.out.println(itens.size() + ": Sair sem comprar nada");
        System.out.println("\nVocê tem: " + pt.ouro + " de ouro");

        int esc = scan.nextInt();
        
        if (esc == itens.size()) {
            System.out.println(">>> Você decidiu não comprar nada.");
        }
        else if (esc >= 0 && esc < itens.size()) {
            Produtos item = itens.get(esc);
            if (pt.ouro >= item.getPreco()) {
                pt.ouro -= item.getPreco();
                item.comprar(pt);
            }
        }
        else {
            System.out.println("Você não tem ouro suficiente");
        }
        System.out.println("Você deseja modificar o seu deck?");
        System.out.println("\nEscolha: 1 (sim) e 0 (nao)");
        esc = scan.nextInt();
        if(esc == 1) {
            bar.Montar_Baralho(scan);
        }
        this.visit = true;
    }

}
