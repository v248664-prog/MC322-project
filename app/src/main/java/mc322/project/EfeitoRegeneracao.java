package mc322.project;
/**
 * Efeito que causa cura ao longo do tempo.
 */
// dano foi usado para simplicar o código
public class EfeitoRegeneracao extends Efeito {
    /**
     * Construtor do efeito.
     */
    public EfeitoRegeneracao(Entidade dono, int acumulos, int dano) {
        super("Regeneracao", dono, acumulos, dano);
    }

    /**
     * Método chamado quando um evento do jogo ocorre.
     * @param evento tipo de evento ocorrido.
     * @param contexto objeto associado ao evento (Publisher).
     */
    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " recuperou " + dano + " de vida por Regeneracao!");
            
            dono.health += acumulos;
            if (dono.health > 100) {
                dono.health = 100; // Limite máximo de vida do Herói
            }
            
            this.acumulos--;

            if (this.acumulos <= 0) {
                dono.removerEfeito(this);
                if (contexto instanceof Publisher) {
                    ((Publisher) contexto).desinscrever(this);
                }
            }
        }
    }
}