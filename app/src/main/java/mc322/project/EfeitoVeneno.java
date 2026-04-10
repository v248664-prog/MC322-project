package mc322.project;
/**
 * dano periódico
 */
public class EfeitoVeneno extends Efeito {
    /**
     * construtor do efeito
     */
    public EfeitoVeneno(Entidade dono, int acumulos, int dano) {
        super("Veneno", dono, acumulos, dano);
    }

    /**
     * notifica os subs quando o evento de fim de turno ocorre
     */
    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " sofreu " + dano + " de dano por Veneno!");
            dono.health -= dano;
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
