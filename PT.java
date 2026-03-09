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
        health -= (int)(damage * ((100.0 - defence) /100.0));
        if (health < 0) {
            health = 0;
        }
    }

    public void recover_health() {
        health += 20;
    }

    public void recover_energy() {
        energy += 20;
    }

    public void show_health_pt() {
        System.out.println("health pt: " + this.health);
    }
}
