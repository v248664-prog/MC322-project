package mc322.project;
/**
 * Efeito que causa dano ao longo do tempo.
 */
public class EfeitoVeneno extends Efeito {
    /**
     * Construtor do efeito.
     */
    public EfeitoVeneno(Entidade dono, int acumulos, int dano) {
        super("Veneno", dono, acumulos, dano);
    }

    /**
     * Método chamado quando um evento do jogo ocorre.
     * @param evento tipo de evento ocorrido.
     * @param contexto objeto associado ao evento (Publisher).
     */
    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " sofreu " + dano + " de dano por Veneno!");
            dono.health -= dano;
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
