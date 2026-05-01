package mc322.project;

import java.util.List;
import java.util.Scanner;

public class Loja extends Eventos{
    int num;

    public Loja(int num) {
        super(num);
    }
    
    public void iniciar(Heroi pt, Scanner scan, Baralho bar){
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

        List<produtos> itens = Factory.gerarObjetos(bar);

        for (int i = 0; i < itens.size(); i++) {
            produtos item = itens.get(i);
            System.out.println(i + ": " + item.getNome() + "" + item.getPreco());
        }

        System.out.println("Vocẽ tem: " + pt.ouro + " de ouro");

        int esc = scan.nextInt();
        
        produtos item = itens.get(esc);
        if (pt.ouro > item.getPreco()) {
            pt.ouro -= item.getPreco();
            item.comprar(pt);
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
        this.visitado = true;
    }

}
