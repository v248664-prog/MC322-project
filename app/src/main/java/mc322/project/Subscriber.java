package mc322.project;
/**
 * define um padrão para a construção de contratos
 */
public interface Subscriber {
    void serNotificado(String evento, Object contexto);
}