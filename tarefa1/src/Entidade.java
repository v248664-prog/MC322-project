abstract class Entidade {

    String name;
    int attack;
    int defence;
    int energy;
    int health;
    int escolha;

    abstract void receive_damage(int dmg);

   abstract void show();

   abstract void recover_health();

   abstract void recover_energy();

}