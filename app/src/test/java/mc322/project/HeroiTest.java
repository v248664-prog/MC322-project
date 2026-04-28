package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroiTest {

    @Test
    public void heroi_vivo_quando_vida_positiva() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        assertTrue(h.health_status());
    }

    @Test
    public void heroi_morto_quando_vida_zero() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.health = 0;
        assertFalse(h.health_status());
    }

    @Test
    public void heroi_recebe_dano_sem_defesa() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.receive_damage(50);
        assertEquals(50, h.health);
    }

    @Test
    public void heroi_recebe_dano_com_defesa() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.defence = 50;
        h.receive_damage(100);
        assertEquals(50, h.health);
    }

    @Test
    public void heroi_nao_fica_com_vida_negativa() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.receive_damage(9999);
        assertEquals(0, h.health);
    }

    @Test
    public void heroi_restaura_energia_para_30() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.energy = 5;
        h.receive_energy();
        assertEquals(30, h.energy);
    }

    @Test
    public void heroi_vida_inicial_correta() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        assertEquals(100, h.health);
    }

    @Test
    public void heroi_energia_inicial_correta() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        assertEquals(30, h.energy);
    }

    @Test
    public void heroi_defesa_inicial_correta() {
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        assertEquals(0, h.defence);
    }
}