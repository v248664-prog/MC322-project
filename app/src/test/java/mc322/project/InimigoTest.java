package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InimigoTest {

    // ===== TESTES: health_status_op() =====

    @Test
    public void inimigo_vivo_quando_vida_positiva() {
        Inimigo op = new Inimigo();
        assertTrue(op.health_status_op());
    }

    @Test
    public void inimigo_morto_quando_vida_zero() {
        Inimigo op = new Inimigo();
        op.health = 0;
        assertFalse(op.health_status_op());
    }

    // ===== TESTES: receive_damage() =====

    @Test
    public void inimigo_recebe_dano_considerando_defesa() {
        Inimigo op = new Inimigo();
        // defence = 10, health = 360
        // dano real = 100 * (100 - 10) / 100 = 90
        op.receive_damage(100);
        assertEquals(270, op.health);
    }

    @Test
    public void inimigo_nao_fica_com_vida_negativa() {
        Inimigo op = new Inimigo();
        op.receive_damage(99999);
        assertEquals(0, op.health);
    }

    // ===== TESTES: recover_health() =====

    @Test
    public void inimigo_recupera_vida() {
        Inimigo op = new Inimigo();
        op.health = 200;
        op.recover_health();
        assertEquals(260, op.health);
    }

    @Test
    public void inimigo_vida_nao_passa_do_maximo() {
        Inimigo op = new Inimigo();
        op.health = 360; // ja no maximo
        op.recover_health();
        assertEquals(360, op.health);
    }

    @Test
    public void recover_health_gasta_energia() {
        Inimigo op = new Inimigo();
        op.energy = 30;
        op.recover_health();
        assertEquals(25, op.energy);
    }

    // ===== TESTES: receive_energy() =====

    @Test
    public void inimigo_restaura_energia_para_30() {
        Inimigo op = new Inimigo();
        op.energy = 0;
        op.receive_energy();
        assertEquals(30, op.energy);
    }

    // ===== TESTES: bite() =====

    @Test
    public void bite_causa_dano_no_heroi() {
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        // attack = 30, heroi defence = 0
        // dano real = 30
        op.bite(h);
        assertEquals(70, h.health);
    }

    @Test
    public void bite_gasta_energia_do_inimigo() {
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        op.energy = 30;
        op.bite(h);
        assertEquals(25, op.energy);
    }

    @Test
    public void bite_nao_deixa_heroi_com_vida_negativa() {
        Inimigo op = new Inimigo();
        Mao mao = new Mao();
        Heroi h = new Heroi(mao);
        h.health = 1;
        op.bite(h); // ataque de 30 > 1 de vida
        assertEquals(0, h.health);
    }
}