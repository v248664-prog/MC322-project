public class OP {
    String name = "Adult_Nuko";
    int defence = 10;
    int attack = 10;
    int health = 100;
    int energy = 100;

    public boolean health_status() {
        if (health > 0) {
            return true;
        }
        return false;
    }

    public void bite(PT pt) {
        pt.health -= this.attack;
    }

    public void receive_damage(int damage) {
        health -= (int)(damage * ((100.0 - defence) /100.0));
        if (health < 0) {
            health = 0;
        }
    }

    public void recover_health() {
        health += 30;
    }

    public void recover_energy() {
        energy += 30;
    }

    public void show_health_op() {
        System.out.println("health op: " + this.health);
    }
}
