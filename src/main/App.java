package src.main;

import java.util.*;

public class App {

    public static void executar() {
        Scanner in = new Scanner(System.in);
            menu();

        System.out.print("> Escolha uma opção: ");
        int op = in.nextInt();

        do{
        switch (op) {
            case 0:
                System.out.println("> Programa finalizado.");
                break;
            case 1:
                selectionSort();
                break;
            case 2:
                bubbleSort();
                break;
            case 3:
                insertionSort();
                break;
        }
      }while(op!=0);
    }

    public static void menu() {
        System.out.println("@ MENU @ ");
        System.out.println("[0] Encerrar");
        System.out.println("[1] Análise de Selection Sort");
        System.out.println("[2] Análise de Bubble Sort");
        System.out.println("[3] Análise de Insertion Sort");
        System.out.println("[4] Análise completa.");
    }

    public static void insertionSort() {
        long tempoInicial = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tam = sc.nextInt();

        int[] array = new int[tam];
        System.out.println("Digite os valores do array: ");
        for (int i = 0; i < tam; i++) {
            array[i] = sc.nextInt();
        }

        int cont = 0;

        for (int i = 1; i < array.length; i++) {
            int j = i;

            while (j > 0 && array[j] < array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j -= 1;
                cont++;
            }
        }
        System.out.println(" @ INSERTION SORT @ ");
        System.out.println(" > Vetor Cadastrado");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
        System.out.println(" > Numero de trocas: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long mediaFinal = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução: " + mediaFinal + "ms");
    }

    public static void bubbleSort() {

    }

    public static void selectionSort() {
    }
}

