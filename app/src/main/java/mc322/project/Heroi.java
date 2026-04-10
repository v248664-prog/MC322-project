package mc322.project;
public class Heroi extends Entidade{
   /**
    * mão para o deck
    */
   Carta[] mao = new Carta[7];

   /**
    * atributos básicos da classe abstrata
    */
   public Heroi() {
        this.name = "Heroi"; 
        this.attack = 0;     
        this.defence = 0;    
        this.energy = 30;    
        this.health = 100;   
   }

   /**
     * ele funciona como um sistema simples para
     * organizar o combate, se estiver vivo continua,
     * se não, ele encerrar
     */
   public boolean health_status() {
      return this.health > 0;
   }

   /**
     * Sistema de dano básico
     */
   public void receive_damage(int dmg) {

      this.health -= (int)(dmg * ((100.0 - this.defence) / 100.0));

      if (this.health < 0) {
         this.health = 0;
      }
   }

   /**
    * restaura a energia no final do turno
    */
   public void receive_energy() {
      this.energy = 30;
   }

   public void show() {
      System.out.print("                                 Your health: " + this.health);
      System.out.println("         Your energy: " + this.energy);
   }

   /**
    * há uma inteção de serem escalas diferentes
    * um herói muito menor e um inimigo enorme
    */
   public void ASCII() {
      System.out.println("                                                    /+\\");
      System.out.println("                                                   (._.)");
   }
   // print do heroi
}