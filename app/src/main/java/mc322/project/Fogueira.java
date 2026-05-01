package mc322.project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fogueira extends Eventos{
    int num;

    public Fogueira(int num) {
        super(num);
    }
    
    public void iniciar(Heroi pt, Scanner scan, Baralho bar) {

        System.out.println("""
            Você ve a luz de uma fogueira e decide ir em direção
            a ela. Não há ninguém por perto. Na esperança de 
            encontrar alguém, você espera... Não demora muito tempo
            para você perceber que está sozinho

            o que você vai fazer em seguida?
            """);

        List<Opcoes> opcoes = new ArrayList<>();
        opcoes.add(new Descansar());
        opcoes.add(new Reedesenhar());

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println(i+ ": " + opcoes.get(i).getNome());
        }
        int esc = scan.nextInt();

        opcoes.get(esc).exe(pt, scan); //executável, kkkkkkkkkkkkkkk
        this.visitado = true;
    }
}
