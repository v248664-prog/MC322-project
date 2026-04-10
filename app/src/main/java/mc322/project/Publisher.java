package mc322.project;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável por gerenciar eventos do jogo.
 */
public class Publisher {
    public static final String EVENTO_FIM_TURNO = "FIM_TURNO";

    private List<Subscriber> subscribers = new ArrayList<>();

    /**
     * Inscreve um novo subscriber para receber eventos.
     * 
     * @param s objeto que deseja ser notificado
    */
    public void inscrever(Subscriber s) {
        if (!subscribers.contains(s)) {
            subscribers.add(s);
        }
    }

    /**
     * Remove um subscriber da lista de notificações.
     * 
     * @param s objeto a ser removido
     */
    public void desinscrever(Subscriber s) {
        subscribers.remove(s);
    }

    /**
     * Notifica todos os subscribers sobre um evento ocorrido.
     * 
     * @param evento tipo de evento
     * @param contexto objeto associado ao evento
     */
    public void notificar(String evento, Object contexto) {
        for (Subscriber s : new ArrayList<>(subscribers)) {
            s.serNotificado(evento, contexto);
        }
    }
}
