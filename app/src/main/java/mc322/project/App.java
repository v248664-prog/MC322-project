package mc322.project;

import java.util.Scanner;

public class App {
    /**
     * Classe responsável por gerenciar a lógica de árvore binária do jogo.
     * @param args
     */
    public static void main(String[] args) {

        //gera o heroi e o mapa
        Scanner scan = new Scanner(System.in);
        Mapa mapa = new Mapa(scan);
        mapa.gerar_mapa();
        Mao mao = new Mao();
        Baralho bar = new Baralho();
        Heroi pt = new Heroi(mao, bar);

        //novo while do jogo
        while (pt.health_status() && !mapa.acabou()) {
            Eventos ev = mapa.mover();
            ev.iniciar(pt, scan);
        }
        if (pt.health_status() && mapa.acabou()) {
            System.out.println("\nUltima batalha");
            Batalha batalha = new Batalha(0, true);
            batalha.iniciar(pt, scan);
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


        """);
        }
        scan.close();
    }
}
