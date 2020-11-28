/*
Main.java
Autor: Fábio Figueiredo
Data da implementação: 27/11/2020
*/

package main;

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        principal(new Scanner(System.in));
    }

    public static void principal(Scanner l){/*Substitui a função main como função principal do programa para testes*/
        int N,P,Aux,Minutos;/*Número de andares do prédio, quantidade de pessoas por andar, auxiliar, menor tempo gasto*/

        N = Integer.parseInt(l.next());/*Entrada do número de andares do prédio*/
        
        int[] Pessoas = new int[N];/*Vetor que armazena em cada posição i a quantidade de pessoas do andar i+1*/
        for (int i = 0; i < N; i++){/*Entrada da quantidade de pessoas por andar do prédio*/
            P = l.nextInt();
            Pessoas[i] = P;
        }

        int[][] TempodeCadaAndar = new int[N][N];/*Matriz que armazena o tempo total gasto pelos funcionários num andar*/
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j){
                    TempodeCadaAndar[i][j] = 0;
                }
                else{
                    TempodeCadaAndar[i][j] = Math.abs((2*(j-i))*Pessoas[j]);
                }    
            }
        }
        
        int[] Total = new int[N];/*Vetor que armazena o tempo total gasto se a máquina ficar posicionada no andar i+1*/
        Aux = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Aux = Aux + TempodeCadaAndar[i][j];
            }
            Total[i] = Aux;
            Aux = 0;
        }

        Minutos = TempoGasto(Total, N);/*total de minutos a serem gastos com o melhor posicionamento possível da máquina*/
        System.out.println(Minutos);
        
        AndarMaquina(Total, N, Minutos);/*Andar(es) onde a máquina deverá ser posicionada para minimizar o tempo gasto*/
    }

    public static int TempoGasto(int T[], int n){/*Retorna total de minutos gastos com o melhor posicionamento da maquina*/
        int minutos = T[0];

        for(int i = 1; i < n; i++){
            if(T[i] < minutos){
                minutos = T[i];
            }
        }

        return minutos;
    }

    public static void AndarMaquina(int T[], int n, int m){/*Imprime os andar(es) onde a máquina deverá ser posicionada*/
        ArrayList<Integer> Andar = new ArrayList();

        for(int i = 0; i < n; i++){
            if(T[i]==m){
                Andar.add(i+1);
            }
        }

        for(int i = 0; i<Andar.size();i++){
            System.out.printf(Andar.get(i)+" ");
        }

        System.out.println();
    }
}