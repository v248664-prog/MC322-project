package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void cartaDano2_causa_40_de_dano() {
        CartaDano2 carta = new CartaDano2();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        carta.shoot(op, h);
        assertEquals(120, op.health);
    }

    @Test
    public void cartaDano2_usar_chama_shoot() {
        CartaDano2 carta = new CartaDano2();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        Publisher jogo = new Publisher();
        carta.usar(op, h, jogo);
        assertEquals(120, op.health);
    }

    @Test
    public void cartaDano3_causa_dano() {
        CartaDano3 carta = new CartaDano3();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        carta.shoot(op, h);
        assertEquals(130, op.health);
    }

    @Test
    public void cartaDano3_usar_chama_shoot() {
        CartaDano3 carta = new CartaDano3();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        Publisher jogo = new Publisher();
        carta.usar(op, h, jogo);
        assertEquals(130, op.health);
    }

    @Test
    public void cartaDano4_causa_dano() {
        CartaDano4 carta = new CartaDano4();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        carta.shoot(op, h);
        assertEquals(60, op.health);
    }

    @Test
    public void cartaDano4_usar_chama_shoot() {
        CartaDano4 carta = new CartaDano4();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        Publisher jogo = new Publisher();
        carta.usar(op, h, jogo);
        assertEquals(60, op.health);
    }

    @Test
    public void cartaDano5_causa_dano() {
        CartaDano5 carta = new CartaDano5();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        carta.shoot(op, h);
        assertEquals(130, op.health);
    }

    @Test
    public void cartaDano5_usar_chama_shoot() {
        CartaDano5 carta = new CartaDano5();
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        Publisher jogo = new Publisher();
        carta.usar(op, h, jogo);
        assertEquals(130, op.health);
    }

    @Test
    public void escudo_remove_bonus_25_ao_final_do_turno() {
        CartaEscudo escudo = new CartaEscudo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        escudo.lucky_number = 2;
        h.defence = 25;
        escudo.ending_bonus(h);
        assertEquals(-25, h.defence);
    }

    @Test
    public void escudo_remove_bonus_50_ao_final_do_turno() {
        CartaEscudo escudo = new CartaEscudo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        escudo.lucky_number = 1;
        h.defence = 50;
        escudo.ending_bonus(h);
        assertEquals(-25, h.defence);
    }

    @Test
    public void escudo_remove_bonus_75_ao_final_do_turno() {
        CartaEscudo escudo = new CartaEscudo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        escudo.lucky_number = 0;
        h.defence = 75;
        escudo.ending_bonus(h);
        assertEquals(-25, h.defence);
    }

    @Test
    public void escudo_reseta_tried_apos_ending_bonus() {
        CartaEscudo escudo = new CartaEscudo();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi h = new Heroi(mao, bar);
        escudo.lucky_number = 2;
        escudo.tried = true;
        h.defence = 25;
        escudo.ending_bonus(h);
        assertFalse(escudo.tried);
    }
}