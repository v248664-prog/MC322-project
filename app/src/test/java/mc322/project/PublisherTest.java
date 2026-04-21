package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PublisherTest {

    @Test
    public void publisher_inscreve_subscriber() {
        Publisher jogo = new Publisher();
        Heroi h = new Heroi();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 2, 10);
        jogo.inscrever(veneno);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        assertEquals(90, h.health);
    }

    @Test
    public void publisher_nao_inscreve_duplicado() {
        Publisher jogo = new Publisher();
        Heroi h = new Heroi();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 3, 10);
        jogo.inscrever(veneno);
        jogo.inscrever(veneno);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        assertEquals(90, h.health);
    }

    @Test
    public void publisher_desinscreve_subscriber() {
        Publisher jogo = new Publisher();
        Heroi h = new Heroi();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 2, 10);
        jogo.inscrever(veneno);
        jogo.desinscrever(veneno);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        assertEquals(100, h.health);
    }

    @Test
    public void publisher_notifica_multiplos_subscribers() {
        Publisher jogo = new Publisher();
        Heroi h = new Heroi();
        h.health = 50;
        EfeitoVeneno veneno1 = new EfeitoVeneno(h, 2, 10);
        EfeitoVeneno veneno2 = new EfeitoVeneno(h, 2, 5);
        jogo.inscrever(veneno1);
        jogo.inscrever(veneno2);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        assertEquals(35, h.health);
    }
}