package mc322.project;

import java.util.Scanner;

public class App {
    /**
     * Classe responsável por gerenciar a lógica de árvore binária do jogo
     * @param args
     */
    public static void main(String[] args) {

        //gera o heroi e o mapa
        Scanner scan = new Scanner(System.in);
        Mapa mapa = new Mapa(scan);
        mapa.gerar_mapa();
        Heroi pt = new Heroi();

        //novo while do jogo
        while (pt.health_status() && !mapa.acabou()) {
            Batalha batalha = mapa.mover();
            batalha.luta(pt, scan);
        }
        //morreu tentando
        if (pt.health_status() == false) {
            System.out.println("\n----------------Fim de Jogo----------------");
        }
        //venvceu o jogo
        else {
            System.out.println("""
.                  .                                     .                        
                    .                                       .                      
                                                                                         
.                              .                                          .                  
                          .                       FIM                    .                         
                    __
                    \\ __| 
   .      .            \\|____                                                           
.                        | \\_____                       .                          .       
                         |     \\____
.           .            |       __ \\__
                         |  ______/                      .                         .                                                  
                        _|___/
.                ________|_/                                              _______
             _____/      |                           .                 . |      |       .   
      __________/________|_______________________________________________|      |______________
 ___ / ________          |                                               |      |             
/          

|
        """);
        }
        scan.close();
    }
}
