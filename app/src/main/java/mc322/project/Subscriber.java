package mc322.project;
/**
 * Classes que implementam esta interface podem se inscrever
 */
public interface Subscriber {
    /**
     * Método chamado quando um evento ocorre.
     * 
     * @param evento tipo de evento ocorrido
     * @param contexto objeto associado ao evento
     */
    void serNotificado(String evento, Object contexto);
    
    //gugugu
}