package mc322.project;

public abstract class Eventos {
    
    public boolean iniciar(Heroi pt) {
        return pt.health > 0;
    }
}
