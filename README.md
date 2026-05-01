# Jogo de Cartas - MC322

Projeto de um jogo de cartas feito em Java para a disciplina MC322.

## Sobre

O projeto implementa um sistema com heróis, inimigos e cartas que aplicam efeitos como dano, veneno, queimadura e regeneração.

## Como rodar

Compilar:

./gradlew build

Executar:

./gradlew run

Rodar testes:

./gradlew test

## Estrutura

* Entidade → classe base
* Heroi e Inimigo → personagens

### Cartas

* Carta → classe base
* CartaDano, CartaDano2, CartaDano3, CartaDano4, CartaDano5
* CartaEscudo, CartaEscudo2
* CartaQueimadura
* CartaVeneno
* CartaRegeneracao

### Efeitos

* Efeito → classe base
* EfeitoQueimadura
* EfeitoVeneno
* EfeitoRegeneracao

### Outros

* Batalha → lógica de combate
* Mapa → estrutura do jogo
* Publisher / Subscriber → sistema de eventos
* App → execução principal

Testes ficam em:

test/java/mc322/project/

## Observações

O foco do projeto foi praticar orientação a objetos e organização de código em Java.

Fogueira (strategy)
- A fogueira segue o padrão strategy. Nela, cada opção oferecida está encapsulada em uma classe que faz a interface(opcoes)

Loja (factory)
-A loja segue o padrão factory. Nele, a gera dinamicamente os objetos (produtos) que serão disponibilizados na loja
