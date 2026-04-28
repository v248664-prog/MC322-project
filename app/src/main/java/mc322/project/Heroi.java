package mc322.project;
/**
* Classe que representa o herói controlado pelo jogador.
*/
public class Heroi extends Entidade{
   
   private Mao mao;

   /**
    * Construtor do herói.
    * Inicializa os atributos base como vida, energia e defesa.
    */
   public Heroi(Mao mao) {
        this.name = "Heroi"; 
        this.attack = 0;     
        this.defence = 0;    
        this.energy = 30;    
        this.health = 100;
        this.mao = new Mao();   
   }

   public Mao getMao() {
        return mao;
    }

   /**
    * Verifica se o herói ainda está vivo.
    * 
    * @return true se a vida for maior que zero, false caso contrário.
    */
   public boolean health_status() {
      return this.health > 0;
   }

    /**
    * Aplica dano ao herói considerando sua defesa.
    * 
    * @param dmg dano recebido.
    */
   public void receive_damage(int dmg) {

      this.health -= (int)(dmg * ((100.0 - this.defence) / 100.0));

      if (this.health < 0) {
         this.health = 0;
      }
   }

   /**
    * Restaura a energia do herói ao início de um novo turno.
    */
   public void receive_energy() {
      this.energy = 30;
   }

   /**
    * Exibe o estado atual do herói no terminal.
    */
   public void show() {
      System.out.print("                                 Your health: " + this.health);
      System.out.println("         Your energy: " + this.energy);
   }

   /**
    * Exibe a representação ASCII do herói.
    */
   public void ASCII() {
      System.out.println("                                                    /+\\");
      System.out.println("                                                   (._.)");
   }
   // print do heroi
}