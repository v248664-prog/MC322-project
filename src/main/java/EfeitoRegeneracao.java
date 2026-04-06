public class EfeitoRegeneracao extends Efeito {
    public EfeitoRegeneracao(Entidade dono, int acumulos) {
        super("Regeneracao", dono, acumulos);
    }

    public void serNotificado(String evento, Object contexto) {
        if (evento.equals(Publisher.EVENTO_FIM_TURNO)) {
            System.out.println("--- " + dono.name + " recuperou " + acumulos + " de vida por Regeneracao!");
            
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