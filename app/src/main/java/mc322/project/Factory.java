package mc322.project;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    /**
     * Verifica se uma carta ainda não está na coleção do baralho.
     * @param bar
     * @param c
     * @return
     */
    public static boolean compara_lista (Baralho bar, Carta c) {
        ArrayList<Carta> minhas_cartas = bar.minhas_cartas;
        for (int i = 0; i < minhas_cartas.size(); i++) {
            if(c.igual(bar.minhas_cartas.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gera a lista de produtos disponíveis na loja.
     * @param bar
     * @return
     */
    public static List<Produtos> gerarObjetos(Baralho bar) {
        List<Produtos> itens = new ArrayList<>();

        itens.add(new PocaoCura());
        itens.add(new PocaoEnergia());
        if (compara_lista(bar, new CartaRegeneracao())){
            itens.add(new CRegeneracao());
        }
        if (compara_lista(bar, new CartaQueimadura())){
            itens.add(new CQueimadura());
        }
        if (compara_lista(bar, new CartaEscudo2())){
            itens.add(new CEscudo2());
        }
        if (compara_lista(bar, new CartaDano4())){
            itens.add(new CDano4());
        }
        if (compara_lista(bar, new CartaDano2())){
            itens.add(new CDano2());
        }
        if (compara_lista(bar, new CartaDano())){
            itens.add(new CDano1());
        }

        return itens;
    }

    
}
