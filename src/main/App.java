package src.main;

import java.util.*;

public class App {


    public static void executar() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            menu();
            System.out.print("> Escolha uma opção: ");
            op = in.nextInt();

            switch (op) {

                case 0:
                    System.out.println("> Programa finalizado.");
                    break;
                case 1:
                    int[] a1 = cadastroArray();
                    selectionSort(a1);
                    break;
                case 2:
                    int[] a2 = cadastroArray();
                    bubbleSort(a2);
                    break;
                case 3:
                    int[] a3 = cadastroArray();
                    insertionSort(a3);
                    break;
            }
        } while (op != 0);
    }



    public static void menu() {
        System.out.println("\n@ MENU @ ");
        System.out.println("[0] Encerrar");
        System.out.println("[1] Análise de Selection Sort");
        System.out.println("[2] Análise de Bubble Sort");
        System.out.println("[3] Análise de Insertion Sort");
    }



    public static int[] cadastroArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tam = sc.nextInt();

        int[] array = new int[tam];
        System.out.println("Digite os valores do array: ");
        for (int i = 0; i < tam; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }



    public static void insertionSort(int[] array) {
        long tempoInicial = System.currentTimeMillis();

        System.out.println(" @ INSERTION SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
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
        System.out.println("\n > Vetor Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
        System.out.println("\n > Numero de trocas no Insertion Sort: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long mediaFinal = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução no Insertion Sort: " + mediaFinal + "ms");
    }




    public static void bubbleSort(int[] array) {
        long tempoInicial = System.currentTimeMillis();

        System.out.println(" @ BUBBLE SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }


        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int auxiliar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = auxiliar;
                    cont++;
                }
            }
        }

        System.out.println("\n > Vetor Ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
        System.out.println("\n > Numero de trocas no Bubble Sort: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long mediaFinal = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução no Bubble Sort: " + mediaFinal + "ms");
    }




    public static void selectionSort(int[] array) {
        long tempoInicial = System.currentTimeMillis();

        System.out.println(" @ SELECTION SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }

        int cont = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                cont++;
            }
        }

        System.out.println("\n > Vetor Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }

        System.out.println("\n > Numero de trocas no Selection Sort: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução no Selection Sort: " + tempoExecucao + "ns");
    }
}

