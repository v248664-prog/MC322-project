package mc322.project;

import java.util.ArrayList;

public class Mao {
    private ArrayList<Carta> cartas;
    private int lim = 4;
   
    /**
     * Construtor da mão
     */
    public Mao() {
        cartas = new ArrayList<>();
    }

    /**
     * Adiciona uma carta à mão.
     * @param c
     */
    public void adicionar(Carta c) {
        if (cartas.size() < lim) {
            cartas.add(c);
        }
    }

    /**
     * Remove e retorna a carta no índice especificado.
     * @param i
     * @return
     */
    public Carta remover(int i) {
        if (i >= 0 && i < cartas.size()) {
            return cartas.remove(i);
        }
        return null;
    }

    /**
     * Retorna o número atual de cartas na mão.
     * @return
     */
    public int tamanho() {
        return cartas.size();
    }

    /**
     * Exibe todas as cartas da mão.
     */
    public void mostrar() {
        for (int i = 0; i < cartas.size(); i++) {
                    Carta c = cartas.get(i);
                    System.out.print((i + 1) + "." + c.nome + "(Custo: " + c.custo + ")  ");
                }
                System.out.print("0. Pular turno\n");
    }

}
