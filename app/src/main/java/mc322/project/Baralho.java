package mc322.project;
import java.util.ArrayList;     
import java.util.Collections;
import java.util.Scanner;

public class Baralho {
    
    private ArrayList<Carta> pilhaCompra;
    private ArrayList<Carta> pilhaDescarte;
    private ArrayList<Carta> todas_as_cartas;
    public ArrayList<Carta> minhas_cartas;

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
        minhas_cartas.add(new CartaEscudo2());
        minhas_cartas.add(new CartaDano5());
        minhas_cartas.add(new CartaDano3());

        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano3());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano5());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaEscudo2());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaVeneno());
        }
        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(pilhaCompra);
    }

    public void descartar(Carta c) {
        pilhaDescarte.add(c);
    }

    public void reciclarDescarte() {
        pilhaCompra.addAll(pilhaDescarte);
        pilhaDescarte.clear();
        embaralhar();
    }

    public void adicionar_a_colecao(Carta carta) {
        minhas_cartas.add(carta);
    }

    public void DescarteTotal() {
        pilhaCompra.clear();
        pilhaDescarte.clear();
    }

    public void MostraTodasCartas(ArrayList<Carta> todas) {

        System.out.println("-------Seu Baralho-------");

        for (int i = 0; i < todas.size(); i++) {
            System.out.println(i + " - " + todas.get(i).getNome());
        }
    }

    public Carta comprarCarta() {
        if (pilhaCompra.isEmpty()) {
            reciclarDescarte();
        }

        else if(!pilhaCompra.isEmpty()) {
            return pilhaCompra.remove(0);
        }

        return null;
    }

    public void Escolhe_carta(Scanner scan) {
        int soma = 0;
        for (int i = 0; i < minhas_cartas.size(); i++) {
            System.err.println("\nQuantas cartas" + minhas_cartas.get(i).getNome() + "Você deseja adicionar?");
            int num = scan.nextInt();
            soma += num;
            for (int j = 0; j < num; j++) {
                pilhaCompra.add(minhas_cartas.get(i));
            }
            System.err.println("Você está usando " + soma + " Cartas");
            if (soma > 60) {
                System.out.println("Você ultrapassou o limite");
                return;
            }
        }
    }

    public void Montar_Baralho(Scanner scan) {

        DescarteTotal();

        System.out.println("o limite de cartas é 60");
        while (pilhaCompra.size() <= 60) {
            Escolhe_carta(scan);
        }
    }

}
