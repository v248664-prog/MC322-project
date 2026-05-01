package mc322.project;

import java.util.Scanner;

public abstract class Eventos {
    protected int id;
    protected boolean visitado = false;

    public Eventos(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean v) {
        this.visitado = v;
    }

    abstract void iniciar(Heroi pt, Scanner scan, Baralho bar);

}