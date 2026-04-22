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

    private int getId(DefaultMutableTreeNode no) {
        return ((Batalha) no.getUserObject()).num;
    }

    private boolean visitado(DefaultMutableTreeNode no) {
        return ((Batalha) no.getUserObject()).visit;
    }

    public Batalha mover() {

        Batalha batalha = (Batalha) atual.getUserObject();

        DefaultMutableTreeNode pri = raiz;

        System.out.println("---------Mapa---------");

        while(pri != atual) {
            System.out.println(getId(pri));
            System.out.println("|");
            System.out.println("|");
            DefaultMutableTreeNode esq = (DefaultMutableTreeNode) pri.getChildAt(0);
            DefaultMutableTreeNode dir = (DefaultMutableTreeNode) pri.getChildAt(1);

            if(visitado(esq)) {
                pri = esq;
            }
            else {
                pri = dir;
            }
        }

        System.out.println(getId(atual));
        System.out.println("|--------|");
        System.out.println("|        |");

        DefaultMutableTreeNode esq = (DefaultMutableTreeNode) atual.getChildAt(0);
        DefaultMutableTreeNode dir = (DefaultMutableTreeNode) atual.getChildAt(1);

        System.out.println(getId(esq) + "        " + getId(dir));
        System.out.println("\nEscolha: 0 (esquerda) e 1 (direita)");
        
        int esc = scan.nextInt();
        atual = (DefaultMutableTreeNode) atual.getChildAt(esc);

        if (atual.getChildCount() == 0) {
            System.out.println("\nUltima batalha");
            fim = true;
            return batalha;
        }

        return (Batalha) atual.getUserObject();
    }

    public boolean acabou() {
        return fim;
    }
}