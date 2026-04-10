package mc322.project;
/**
 * cura periódica
 */
// dano foi usado para simplicar o código
public class EfeitoRegeneracao extends Efeito {
    /**
     * construtor do efeito
     */
    public EfeitoRegeneracao(Entidade dono, int acumulos, int dano) {
        super("Regeneracao", dono, acumulos, dano);
    }

    /**
     * notifica os subs quando o evento de fim de turno ocorre
     */
    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " recuperou " + dano + " de vida por Regeneracao!");
            
            dono.health += acumulos;
            if (dono.health > 100) {
                dono.health = 100; // Limite máximo de vida do Herói
            }
            
            this.acumulos--;

            /**
             * retira o efeito
             */
            if (this.acumulos <= 0) {
                dono.removerEfeito(this);
                if (contexto instanceof Publisher) {
                    ((Publisher) contexto).desinscrever(this);
                }
            }
        }
    }
}