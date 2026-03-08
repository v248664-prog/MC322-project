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
        health =- damage * (defence/100);
    }

    public void recover_health() {
        health += 30;
    }

    public void recover_energy() {
        energy += 30;
    }
}
