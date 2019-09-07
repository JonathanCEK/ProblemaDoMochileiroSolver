/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicacomputacional;

import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class MatematicaComputacional {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Capacidade Total da Mochila: ");
        int coluna = scan.nextInt() + 1;
        System.out.println("Quantidade de itens: ");
        int linha = scan.nextInt() + 1;
        int valor = coluna;
        int peso = coluna + 1;
        
        int vet[][] = new int[linha][coluna + 2]; // os dois slots extra é para guardas os preços e valores
        
        for (int i = 0; i < linha; i++) { // zerando as linhas e colunas 0
            vet[i][0] = 0;
        }
        for (int i = 0; i < coluna; i++) {
            vet[0][i] = 0;
        }
        
        for (int i = 1; i < linha; i++) {
            System.out.println("Insira o valor do item " + i + ": ");
            vet[i][valor] = scan.nextInt();
            System.out.println("Insira o peso do item " + i + ": ");
            vet[i][peso] = scan.nextInt();
        }
        
        for (int i = 1; i < linha; i++) {
            for (int j = 1; j < coluna; j++) {
                if(vet[i][peso] > j){
                    vet[i][j] = vet[i - 1][j];
                }else{
                    vet[i][j] = vet[i][valor] + vet[i-1][j - vet[i][peso]];
                }
            }
        }
        imprimir(vet, linha, coluna);
        
        linha --;
        int temp  = vet[linha][1]; 
        for (int i = 1; i < coluna; i++) {
            if(vet[linha][i] > temp){
                temp = vet[linha][i];
                valor = i;// guardando a coluna com maior valor
            }
        }
        System.out.println("Maior valor: " + vet[linha][valor]);
        coluna = valor;
        while(linha > 0){ // verificação de quais foram escolhidos
            if(vet[linha][coluna] != vet[linha - 1][coluna]){
                System.out.println("O item " + linha + " foi escolhido de valor " + vet[linha][peso-1] + " e peso " + vet[linha][peso]);
                coluna = coluna - vet[linha][peso];
            }
            linha--;
        }
    }
    public static void imprimir(int vet[][],int linha,int coluna){
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(", " + vet[i][j]);
            }
            System.out.println("");
        }
    }
}
