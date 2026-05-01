package mc322.project;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    public static boolean compara_lista (Baralho bar, Carta c) {
        ArrayList<Carta> minhas_cartas = bar.minhas_cartas;
        for (int i = 0; i < minhas_cartas.size(); i++) {
            if(c.equals(bar.minhas_cartas.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<produtos> gerarObjetos(Baralho bar) {
        List<produtos> itens = new ArrayList<>();

        itens.add(new PocaoCura());
        itens.add(new PocaoEnergia());
        if (compara_lista(bar, new CartaRegeneracao())){
            itens.add(new CRegeneracao());
        }
        if (compara_lista(bar, new CartaQueimadura())){
            itens.add(new CQueimadura());
        }
        if (compara_lista(bar, new CartaEscudo())){
            itens.add(new CEscudo());
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
