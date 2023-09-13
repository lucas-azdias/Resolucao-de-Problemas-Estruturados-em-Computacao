"Lucas Azevedo Dias"

"AVALIAÇÃO INDIVIDUAL"
"""
ENUNCIADO
      Você deve escolher resolver o item 1, ou o item 2 desta tarefa. Não serão dados
pontos extras para quem resolver os dois. Caso o aluno resolva os dois itens será
considerado como nota o item de MENOR VALOR. Use como referência o pseudocódigo
apresentado no livro texto. A entrega do algoritmo pode ser feita por meio de um texto
em pdf. A entrega do código Python deve ser feita por meio de um link para o repl.it.

      A Torre de Hanói é um quebra-cabeça que consiste em uma base contendo três pinos,
em um dos quais são dispostos alguns discos uns sobre os outros, em ordem crescente de
diâmetro, de cima para baixo. O problema consiste em passar todos os discos de um pino
para outro qualquer, usando um dos pinos como auxiliar, de maneira que um disco maior
nunca fique em cima de outro menor em nenhuma situação. O número de discos pode variar
sendo que o mais simples contém apenas três.

      1. Escreva o algoritmo de uma função recursiva, em pseudo-código para determinar o
      menor número de movimentos para resolver o “quebra-cabeça” da Torre de Hanói
      e determine a quantidade mínima de movimentos para completar o quebra–cabeça
      com 7 discos.
      2. Escreva uma função recursiva, em Python, C ou C++, para determinar o menor
      número de movimentos para resolver o “quebra-cabeça” da Torre de Hanói
      determinando a quantidade mínima de movimentos para completar o quebra–
      cabeça com 7 discos e mostrando em tela, cada um dos movimentos.
"""


def showPinos(pinos):
      # Mostra os pinos na tela
      print("\n" + "-" * 30)
      for i, pino in enumerate(pinos):
            print(f"{i + 1}|", end="")
            for disco in pino:
                  print(f" {disco}", end="")
            print()
      print("-" * 30)


def solveHanoi(n, pinos, count, indexPinoInicial, indexPinoFinal, indexPinoMeio):
      # Resolve a Torre de Hanoi para uma quantidade n de discos
      # Retorna uma nova lista com as posições atualizadas e a contagem de movimentos atualizada
      indexPinoInicial -= 1
      indexPinoFinal -= 1
      indexPinoMeio -= 1

      if n == 1:
            pinos[indexPinoFinal].append(pinos[indexPinoInicial][len(pinos[indexPinoInicial]) - 1])
            pinos[indexPinoInicial].pop(len(pinos[indexPinoInicial]) - 1)
            showPinos(pinos)
            count += 1
      elif n < 1:
            print("\033[1;31m\nErro! Número de discos é negativo.\033[m")
      else: # n > 1
            pinos, count = solveHanoi(n - 1, pinos, count, indexPinoInicial + 1, indexPinoMeio + 1, indexPinoFinal + 1)
            pinos, count = solveHanoi(1, pinos, count, indexPinoInicial + 1, indexPinoFinal + 1, indexPinoMeio + 1)
            pinos, count = solveHanoi(n - 1, pinos, count, indexPinoMeio + 1, indexPinoFinal + 1, indexPinoInicial + 1)

      return pinos, count


def main():
      discosIniciais = 7

      # Define os pinos e as listas para cada pino
      pinos = list()
      for i in range(3):
            pinos.append([])

      # Adiciona os discos ao pino inicial
      for i in range(discosIniciais):
            pinos[0].append(discosIniciais - i)

      # Mostra os pinos
      showPinos(pinos)

      # Resolve a Torre de Hanoi para os discosIniciais
      pinos, count = solveHanoi(discosIniciais, pinos, 0, 1, 3, 2)

      # Mostra a resposta
      print(f"\n\033[1;33mResposta:\nLeva {count} movimentos para se resolver a Torre de Hanoi com {discosIniciais} discos!\033[m\n")


if __name__ == "__main__":
      main()
