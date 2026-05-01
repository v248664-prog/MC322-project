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
        int h = ram.nextInt(6) + 2;
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

        No n = new No();
        DefaultMutableTreeNode no = new DefaultMutableTreeNode(n.gerarEvento(qnt++));

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
        return ((Eventos) no.getUserObject()).getId();
    }

    private boolean visitado(DefaultMutableTreeNode no) {
        return ((Eventos) no.getUserObject()).isVisitado();
    }

    public Eventos mover() {

        Eventos ev = (Eventos) atual.getUserObject();

        DefaultMutableTreeNode pri = raiz;

        System.out.println("---------Mapa---------");
        //efihifjiwf
        //fokorjgijrgj

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
        System.out.println("\nEscolha: 1 (esquerda) e 0 (direita)");

        int esc = scan.nextInt();
        if (esc == 0) esc = 1;
        if (esc == 1) esc = 0;
        atual = (DefaultMutableTreeNode) atual.getChildAt(esc);

        if (atual.getChildCount() == 0) {
            fim = true;
            return ev;
        }

        return (Eventos) atual.getUserObject();
    }

    public boolean acabou() {
        return fim;
    }
}