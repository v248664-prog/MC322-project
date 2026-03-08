import java.util.Random;

public class OLD_BOMB {
    int qnt;

    public OLD_BOMB(int qnt) {
        this.qnt = qnt;
    }

    public void activate(OP op) {
        if (this.qnt >= 1) {
            Random random = new Random();
            int explosion = random.nextInt(100);
            op.receive_damage(explosion);
            this.qnt -= 1;
        }
    }
}