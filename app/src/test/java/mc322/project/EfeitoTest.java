package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EfeitoTest {

    // ===== TESTES: EfeitoVeneno =====

    @Test
    public void veneno_causa_dano_no_fim_do_turno() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 2, 10);
        jogo.inscrever(veneno);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(90, h.health);
    }

    @Test
    public void veneno_decrementa_acumulos() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 2, 10);
        jogo.inscrever(veneno);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(1, veneno.acumulos);
    }

    @Test
    public void veneno_remove_efeito_quando_acumulos_zerados() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 1, 10);
        jogo.inscrever(veneno);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(0, veneno.acumulos);
    }

    @Test
    public void veneno_causa_dano_multiplos_turnos() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        EfeitoVeneno veneno = new EfeitoVeneno(h, 2, 10);
        jogo.inscrever(veneno);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(80, h.health);
    }

    // ===== TESTES: EfeitoRegeneracao =====

    @Test
    public void regeneracao_cura_no_fim_do_turno() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.health = 80;
        Publisher jogo = new Publisher();
        EfeitoRegeneracao regen = new EfeitoRegeneracao(h, 2, 15);
        jogo.inscrever(regen);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(82, h.health);
    }

    @Test
    public void regeneracao_nao_passa_de_100() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.health = 99;
        Publisher jogo = new Publisher();
        EfeitoRegeneracao regen = new EfeitoRegeneracao(h, 2, 15);
        jogo.inscrever(regen);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(100, h.health);
    }

    @Test
    public void regeneracao_decrementa_acumulos() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        EfeitoRegeneracao regen = new EfeitoRegeneracao(h, 2, 15);
        jogo.inscrever(regen);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(1, regen.acumulos);
    }
    // ===== TESTES: EfeitoQueimadura =====

    @Test
    public void queimadura_causa_dano_no_fim_do_turno() {
        Inimigo op = new Inimigo();
        Publisher jogo = new Publisher();
        EfeitoQueimadura queimadura = new EfeitoQueimadura(op, 3, 30);
        jogo.inscrever(queimadura);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(330, op.health);
    }

    @Test
    public void queimadura_decrementa_acumulos() {
        Inimigo op = new Inimigo();
        Publisher jogo = new Publisher();
        EfeitoQueimadura queimadura = new EfeitoQueimadura(op, 3, 30);
        jogo.inscrever(queimadura);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(2, queimadura.acumulos);
    }

    @Test
    public void queimadura_causa_dano_multiplos_turnos() {
        Inimigo op = new Inimigo();
        Publisher jogo = new Publisher();
        EfeitoQueimadura queimadura = new EfeitoQueimadura(op, 3, 30);
        jogo.inscrever(queimadura);

        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(300, op.health);
    }

    // ===== TESTES: CartaQueimadura =====

    @Test
    public void cartaQueimadura_aplica_efeito_no_inimigo() {
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        Publisher jogo = new Publisher();
        CartaQueimadura carta = new CartaQueimadura();
        h.energy = 30;

        carta.usar(op, h, jogo);
        jogo.notificar(Publisher.EVENTO_FIM_TURNO, jogo);

        assertEquals(330, op.health);
    }
}
