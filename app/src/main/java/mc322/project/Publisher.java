package mc322.project;
import java.util.ArrayList;
import java.util.List;
/**
 * lista dos subscribers
 * nessa classe, há os métodos basicos para o funcionamento
 * esperado do sistema de efeito, como inscrição, desiscrição
 * e a notificação para que eles ocorram
 */
public class Publisher {
    public static final String EVENTO_FIM_TURNO = "FIM_TURNO";

    private List<Subscriber> subscribers = new ArrayList<>();

    public void inscrever(Subscriber s) {
        if (!subscribers.contains(s)) {
            subscribers.add(s);
        }
    }

    public void desinscrever(Subscriber s) {
        subscribers.remove(s);
    }

    public void notificar(String evento, Object contexto) {
        for (Subscriber s : new ArrayList<>(subscribers)) {
            s.serNotificado(evento, contexto);
        }
    }
}
