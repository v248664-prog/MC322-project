package mc322.project;
import javax.swing.tree.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe responsável por organizar o mapa do Jogo
 */
public class Mapa {

    /**
     *Atributos da Classe
     */
    int qnt = 0;
    private DefaultMutableTreeNode raiz;
    private DefaultMutableTreeNode atual;
    private Scanner scan = new Scanner(System.in);
    private boolean fim = false;

    /**
     * Construtor
     * @param scan Scanner do programa
     */
    public Mapa(Scanner scan) {
        this.scan = scan;
    }

    /**
     *Gera mapa com altura aleatória
     */
    public void gerar_mapa() {
        Random ram = new Random();
        int h = ram.nextInt(2) + 2;
        raiz = criar_arvore(h);
        atual = raiz;
        }

    /**
     * Cria árvore de batalhas
     * @param h
     * @return
     */
    public DefaultMutableTreeNode criar_arvore(int h) {

        if (h == 0) {
            return null;
        }

        DefaultMutableTreeNode no = new DefaultMutableTreeNode(new Batalha(qnt++));

        DefaultMutableTreeNode esq = criar_arvore(h-1);
        DefaultMutableTreeNode dir = criar_arvore(h-1);

        if (esq != null) {
            no.add(esq);
        }

        if (dir != null) {
            no.add(dir);
        }

        return no;
    }

    /**
     * Move o jogador no mapa
     * @return
     */
    public Batalha mover() {
        
        Batalha batalha = (Batalha) atual.getUserObject();

        if (atual.getChildCount() == 0) {
            System.out.println("Ultima batalha");
            fim = true;
            return batalha;
        }

        System.out.println("---------Escolha um caminho---------");

        for (int i = 0; i < atual.getChildCount(); i++) {
            System.out.println("OPÇÃO : " + i);
    }
    
    int esc = scan.nextInt();
    atual = (DefaultMutableTreeNode) atual.getChildAt(esc);
    return batalha;
    }

    public boolean acabou() {
    return fim;
    }
}