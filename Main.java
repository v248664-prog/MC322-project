import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("An Adult Nuko is blocking the passage");

        Scanner sc = new Scanner(System.in);

        OP op = new OP();
        PT pt = new PT();

        OLD_BOMB ob = new OLD_BOMB(10);
        RUSTYGUN rg = new RUSTYGUN(20);

        while (op.health_status() && pt.health_status()) {
            System.out.println("1. Use the gun");
            System.out.println("2. Throw the bomb");
            System.out.println("3. Recover");

            int action = sc.nextInt();

            if (action == 1 && pt.energy >= 1) {
                if (rg.charged) {
                    rg.shoot(op);
                }
                else {
                    rg.charge();
                }
                pt.energy -= 1;
            }

            else if (action == 2 && pt.energy >= 1) {
                ob.activate(op);
                pt.energy -= 1;
            }

            else if (action == 3) {
                System.out.println("1. restore health");
                System.out.println("2. recover energy");
                action = sc.nextInt();
                if (action == 1) {
                    op.recover_energy();
                }
                else {
                    op.recover_health();
                }
            }

            else if (op.health_status()) {
                op.bite(pt);
            }
        }

        if (pt.health_status()) {
            System.out.println("The Nuko inst moving anymore");
        }
        else {
            System.out.println("Now, you can pass safely");
        }
    sc.close();
    }
}