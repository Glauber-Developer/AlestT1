package src.main;

import java.util.Scanner;
public class AnaliseSort{
    public static void main(String args[]){
        insertionSort();
    }
    public static void insertionSort(){
        long tempoInicial = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tam = sc.nextInt();

        int [] array = new int[tam];
        System.out.println("Digite os valores do array: ");
        for(int i = 0; i < tam; i++){
            array[i] = sc.nextInt();
        }

        int cont = 0;

        for(int i = 1; i < array.length; i++){
            int j = i;
            
            while(j>0 && array[j] < array [j-1]){ 
                int aux = array[j];
                array[j] = array[j-1];
                array[j-1] = aux;
                j-=1;
                cont++;
            }
    }
    System.out.println(" @ INSERTION SORT @ ");
    System.out.println(" > Vetor Cadastrado");
    for(int i = 0; i < array.length; i++){
        System.out.println(" > Indice [" + i + "] " + array[i]);
    }
        System.out.println(" > Numero de trocas: " + cont);
       long tempoFinal =  System.currentTimeMillis();
        long mediaFinal = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução: " + mediaFinal + "ms");
    }
    public static void bubble(){
    
    }
    public static void selectionSort(){

    }
}