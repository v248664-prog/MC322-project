public class PT {
    int defence = 0;
    int health = 100;
    int energy = 100;
    int storage = 30;

    public boolean health_status() {
        if (health > 0) {
            return true;
        }
        return false;
    }

    public void receive_damage(int damage) {
        health =- damage * (defence/100);
    }

    public void recover_health() {
        health += 20;
    }

    public void recover_energy() {
        energy += 20;
    }
}
