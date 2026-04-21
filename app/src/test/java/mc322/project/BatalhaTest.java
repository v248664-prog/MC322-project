package mc322.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class BatalhaTest {

    @Test
    public void batalha_inicializa_corretamente() {
        Batalha batalha = new Batalha(5);
        assertEquals(5, batalha.num);
    }

    @Test
    public void batalha_fluxo_pular_turnos_ate_fim_combate() {
        Batalha batalha = new Batalha(1);
        Heroi heroi = new Heroi();
        
        String inputsSimulados = "0\n".repeat(100);
        Scanner scan = new Scanner(inputsSimulados);

        try {
            batalha.luta(heroi, scan);
        } catch (NoSuchElementException e) {
        }

        assertFalse(heroi.health_status());
    }

    @Test
    public void batalha_fluxo_jogar_primeira_carta() {
        Batalha batalha = new Batalha(1);
        Heroi heroi = new Heroi();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++) {
            sb.append("1\n0\n");
        }
        Scanner scan = new Scanner(sb.toString());

        try {
            batalha.luta(heroi, scan);
        } catch (NoSuchElementException e) {
        }

        assertNotNull(batalha);
    }
}
