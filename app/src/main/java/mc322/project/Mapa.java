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
        int h = ram.nextInt(8) + 8;
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

    /**
     * Verifica se o evento de um nó já foi visitado.
     * @param no
     * @return
     *
    private boolean visitado(DefaultMutableTreeNode no) {
        return ((Eventos) no.getUserObject()).ehVisit();
    }

    /**
     * Exibe o caminho percorrido no mapa.
     * @return
     */
    public Eventos mover() {

        if (atual.getChildCount() == 0) {
            fim = true;
            return (Eventos) atual.getUserObject();
        }

        DefaultMutableTreeNode pri = raiz;

        System.out.println("---------Mapa---------");
        //efihifjiwf
        //fokorjgijrgj

        while(pri != atual) {
            System.out.println(getId(pri));
            System.out.println("|");
            System.out.println("|");
            if (pri.getChildCount() < 2) break;
            DefaultMutableTreeNode esq = (DefaultMutableTreeNode) pri.getChildAt(0);
            DefaultMutableTreeNode dir = (DefaultMutableTreeNode) pri.getChildAt(1);

            if(((Eventos) esq.getUserObject()).ehVisit()) {
                pri = esq;
            }
            else {
                pri = dir;
            }
        }

        System.out.println(getId(atual));
        System.out.println("|--------|");
        System.out.println("|        |");

        if (atual.getChildCount() < 2) {
            fim = true;
            return (Eventos) atual.getUserObject();
        }

        DefaultMutableTreeNode esq = (DefaultMutableTreeNode) atual.getChildAt(0);
        DefaultMutableTreeNode dir = (DefaultMutableTreeNode) atual.getChildAt(1);

        System.out.println(getId(esq) + "        " + getId(dir));
        System.out.println("\nEscolha: 1 (esquerda) e 0 (direita)");

        int esc = scan.nextInt();

        if (esc == 1) {
            atual = esq;
        }
        else {
            atual = dir;
        }
        ((Eventos) atual.getUserObject()).setVisit(true);

        if (atual.getChildCount() == 0) {
            fim = true;
        }

        return (Eventos) atual.getUserObject();
    }

    /**
     * Informa se o herói chegou ao fim do mapa.
     * @return
     */
    public boolean acabou() {
        return fim;
    }
}