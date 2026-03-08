public class RUSTYGUN {
    int munition;
    boolean charged = false;

    public RUSTYGUN(int munition) {
        this.munition = munition;
    }

    public void charge() {
        this.charged = true;
    }

    public void shoot(OP op) {
        if (this.charged) {
            if (this.munition >= 1) {
                op.receive_damage(10);
                this.munition--;
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