 // basicamente uma carta de dano

public class RUSTYGUN {
    int munition;
    boolean charged = false;

    public RUSTYGUN(int munition) {
        this.munition = munition;
    }

    public void charge(PT pt) {
        charged = true;
        pt.energy -= 2;
    }

    public void shoot(OP op, PT pt) {
        pt.energy -= 2;
        if (this.charged) {
            if (munition >= 1) {
                op.receive_damage(20);
                munition--;
            }
            else {
                System.out.println("sem munição");
            }
        } 
        else {
            System.out.println("Não há nada na câmara");
        }
    }
}