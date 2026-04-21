package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroiTest {

    @Test
    public void heroi_vivo_quando_vida_positiva() {
        Heroi h = new Heroi();
        assertTrue(h.health_status());
    }

    @Test
    public void heroi_morto_quando_vida_zero() {
        Heroi h = new Heroi();
        h.health = 0;
        assertFalse(h.health_status());
    }

    @Test
    public void heroi_recebe_dano_sem_defesa() {
        Heroi h = new Heroi();
        h.receive_damage(50);
        assertEquals(50, h.health);
    }

    @Test
    public void heroi_recebe_dano_com_defesa() {
        Heroi h = new Heroi();
        h.defence = 50;
        h.receive_damage(100);
        assertEquals(50, h.health);
    }

    @Test
    public void heroi_nao_fica_com_vida_negativa() {
        Heroi h = new Heroi();
        h.receive_damage(9999);
        assertEquals(0, h.health);
    }

    @Test
    public void heroi_restaura_energia_para_30() {
        Heroi h = new Heroi();
        h.energy = 5;
        h.receive_energy();
        assertEquals(30, h.energy);
    }

    @Test
    public void heroi_vida_inicial_correta() {
        Heroi h = new Heroi();
        assertEquals(100, h.health);
    }

    @Test
    public void heroi_energia_inicial_correta() {
        Heroi h = new Heroi();
        assertEquals(30, h.energy);
    }

    @Test
    public void heroi_defesa_inicial_correta() {
        Heroi h = new Heroi();
        assertEquals(0, h.defence);
    }
}