public class EfeitoVeneno extends Efeito {
    public EfeitoVeneno(Entidade dono, int acumulos) {
        super("Veneno", dono, acumulos);
    }

    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " sofreu " + acumulos + " de dano por Veneno!");
            dono.receive_damage(acumulos);
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
