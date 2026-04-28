package mc322.project;
import java.util.ArrayList;     
import java.util.Collections;

public class Baralho {
    
    private ArrayList<Carta> pilhaCompra;
    private ArrayList<Carta> pilhaDescarte;

    public Baralho() {
        pilhaCompra = new ArrayList<>();
        pilhaDescarte = new ArrayList<>();
         for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano());
        }
        for (int i = 0; i < 15; i++) {
            pilhaCompra.add(new CartaDano2()); // Lembre-se de colocar o Publisher no usar() desta tbm
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano3());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano4());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaDano5());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaEscudo());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaEscudo2());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaVeneno());
        }
        for (int i = 0; i < 10; i++) {
            pilhaCompra.add(new CartaRegeneracao());
        }
        for (int i = 0; i < 5; i++) {
            pilhaCompra.add(new CartaQueimadura());
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

    public Carta comprarCarta() {
        if (pilhaCompra.isEmpty()) {
            reciclarDescarte();
        }

        else if(!pilhaCompra.isEmpty()) {
            return pilhaCompra.remove(0);
        }

        return null;
    }
}
