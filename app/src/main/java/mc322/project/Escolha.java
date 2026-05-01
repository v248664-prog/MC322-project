package mc322.project;

import java.util.Scanner;

public class Escolha extends Eventos {
    int num;

    public Escolha(int num) {
        super(num);
    }
    
    public void iniciar(Heroi pt, Scanner scan, Baralho bar) {
        System.out.println("""
        Você encontra um galpão com suprimentos, mas
        você só tem capacidade de levar um deles na
        sua jornada

        1. Remédios (você irá recuperar 30 de vida)
        2. Mantimentos (a energia total na sua próxima batalha vai aumentar para 45)
        3. Ouro (você receberá mais 20 de ouro)

        Seja rápido antes que eles te encontrem de novo
        """);

        int choice = scan.nextInt();
        if (choice == 1) {
            pt.health += 30;
            if (pt.health > 100) {
                pt.health = 100;
            }
        }
        if (choice == 2) {
            pt.energy = 45;
            pt.energy_total = 45;
        }
        if (choice == 3) {
            pt.ouro += 20;
        }
        else {
            System.out.println("Você perdeu uma oportunidade que não voltará");
        }
        this.visitado = true;

    }
}
