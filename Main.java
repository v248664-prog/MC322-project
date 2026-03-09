import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("");
        System.out.println("An Adult Nuko is blocking the passage");

        Scanner sc = new Scanner(System.in);

        OP op = new OP();
        PT pt = new PT();

        OLD_BOMB ob = new OLD_BOMB(10);
        RUSTYGUN rg = new RUSTYGUN(20);

        while (op.health_status() && pt.health_status()) {
            System.out.println("");
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
                    pt.recover_energy();
                }
                else {
                    pt.recover_health();
                }
            }

            System.out.println("");
            op.show_health_op();
            System.out.println("");
            pt.show_health_pt();
            System.out.println("");

            if (op.health_status()) {
                op.bite(pt);
            }
        }

        if (op.health_status()) {
            System.out.println("health pt: 0");
            System.out.println("You shouldnt have started a battle you couldnt win");
        }
        else {
            pt.show_health_pt();
            System.out.println("The Nuko isn't moving anymore");
        }
    sc.close();
    }
}