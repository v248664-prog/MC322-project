package mc322.project;
import java.util.ArrayList;     
import java.util.Collections;
import java.util.Scanner;

/**
 * Representa o baralho do herói, gerenciando as pilhas de compra e descarte,
 * a coleção de cartas disponíveis.
 */
public class Baralho {
    
    private ArrayList<Carta> pilhaCompra;
    private ArrayList<Carta> pilhaDescarte;
    private ArrayList<Carta> todas_as_cartas;
    public ArrayList<Carta> minhas_cartas;

    /**
     * Inicializando as pilhas de compra e descarte,
     * a lista de todas as cartas do jogo e a coleção inicial do jogador.
     */
    public Baralho() {
        pilhaCompra = new ArrayList<>();
        pilhaDescarte = new ArrayList<>();
        todas_as_cartas = new ArrayList<>();
        minhas_cartas = new ArrayList<>();

        todas_as_cartas.add(new CartaDano());
        todas_as_cartas.add(new CartaDano2());
        todas_as_cartas.add(new CartaDano3());
        todas_as_cartas.add(new CartaDano4());
        todas_as_cartas.add(new CartaDano5());
        todas_as_cartas.add(new CartaEscudo());
        todas_as_cartas.add(new CartaEscudo2());
        todas_as_cartas.add(new CartaVeneno());
        todas_as_cartas.add(new CartaRegeneracao());
        todas_as_cartas.add(new CartaQueimadura());

        minhas_cartas.add(new CartaVeneno());
        minhas_cartas.add(new CartaEscudo());
        minhas_cartas.add(new CartaDano5());
        minhas_cartas.add(new CartaDano3());

        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano3());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano5());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaEscudo());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaVeneno());
        }
        embaralhar();
    }

    /**
     * Embaralha aleatoriamente a pilha de compra.
     */
    public void embaralhar() {
        Collections.shuffle(pilhaCompra);
    }

    /**
     * Move uma carta para a pilha de descarte.
     *
     * @param c
     */
    public void descartar(Carta c) {
        pilhaDescarte.add(c);
    }

    /**
     * Recicla todas as cartas da pilha de descarte.
     */
    public void reciclarDescarte() {
        pilhaCompra.addAll(pilhaDescarte);
        pilhaDescarte.clear();
        embaralhar();
    }

    /**
     * Adiciona uma carta à coleção pessoal do jogador.
     * @param carta
     */
    public void adicionar_a_colecao(Carta carta) {
        minhas_cartas.add(carta);
    }

    /**
     * Limpa completamente as pilhas de compra e descarte.
     */
    public void DescarteTotal() {
        pilhaCompra.clear();
        pilhaDescarte.clear();
    }

    /**
     * Exibe no console todas as cartas de uma lista fornecida,
     * numeradas por índice.
     * @param todas
     */
    public void MostraTodasCartas(ArrayList<Carta> todas) {

        System.out.println("-------Seu Baralho-------");

        for (int i = 0; i < todas.size(); i++) {
            System.out.println(i + " - " + todas.get(i).getNome());
        }
    }

    /**
     * Compra da pilhaCompra e reinicia o deck quando ele acaba.
     * @return
     */
    public Carta comprarCarta() {
        if (pilhaCompra.isEmpty()) {
            if (pilhaDescarte.isEmpty()) {
                return null;
            }
            reciclarDescarte();
        }
        return pilhaCompra.remove(0);
    }

    /**
     * Permite ao jogador escolher quantas cópias de cada carta de sua coleção
     * deseja adicionar à pilha de compra, respeitando o limite de 60 cartas.
     * @param scan
     */
    public void Escolhe_carta(Scanner scan) {
        int soma = pilhaCompra.size();
        for (int i = 0; i < minhas_cartas.size(); i++) {
            System.out.println("\nQuantas cartas " + minhas_cartas.get(i).getNome() + " você deseja adicionar?");
            int num = scan.nextInt();
            soma += num;
            if (soma > 60) {
                System.out.println("Você ultrapassou o limite de 60 cartas!");
                return;
            }
            for (int j = 0; j < num; j++) {
                pilhaCompra.add(minhas_cartas.get(i));
            }
            System.out.println("Você está usando " + soma + " cartas");
        }
    }

    /**
     * Inicia o processo de montagem de baralho personalizado.
     * @param scan
     */
    public void Montar_Baralho(Scanner scan) {
        DescarteTotal();
        System.out.println("O limite de cartas é 60. Digite 0 para cada carta que não deseja adicionar.");
        Escolhe_carta(scan);
        embaralhar();
    }

}
