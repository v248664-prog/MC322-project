package mc322.project;

import java.util.Scanner;

public abstract class Eventos {
    protected int id;
    protected boolean visit = false;

     /**
     * Constrói um evento com o identificador fornecido.
     * @param id
     */
    public Eventos(int id) {
        this.id = id;
    }

    /**
     * Retorna o identificador do evento.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Informa se o evento já foi visitado.
     * @return
     */
    public boolean ehVisit() {
        return visit;
    }

    /**
     * Define o estado de visita do evento.
     * @param v
     */
    public void setVisit(boolean v) {
        this.visit = v;
    }

    /**
     * Inicia um evento
     */
    abstract void iniciar(Heroi pt, Scanner scan);

}