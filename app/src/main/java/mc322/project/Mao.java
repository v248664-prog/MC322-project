package mc322.project;

import java.util.ArrayList;

public class Mao {
    private ArrayList<Carta> cartas;
    private int lim = 4;
    
    public Mao() {
        cartas = new ArrayList<>();
    }

    public void adicionar(Carta c) {
        if (cartas.size() < lim) {
            cartas.add(c);
        }
    }

    public Carta remover(int i) {
        if (i >= 0 && i < cartas.size()) {
            return cartas.remove(i);
        }
        return null;
    }

    public int tamanho() {
        return cartas.size();
    }

    public void mostrar() {
        for (int i = 0; i < cartas.size(); i++) {
                    Carta c = cartas.get(i);
                    System.out.print((i + 1) + "." + c.nome + "(Custo: " + c.custo + ")  ");
                }
                System.out.print("0. Pular turno\n");
    }

}
