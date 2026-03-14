abstract class Entidade {

    String name;
    int attack;
    int defence;
    int energy;
    int health;

    abstract void receive_damage(int dmg);

   abstract void show();

   abstract void recover_health();

   abstract void receive_energy();
}