package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String In = scn.nextLine();
        String Out = "";
        char[] mas = In.toCharArray(); // Строку в массив символов
        int i = 0, k = 1;
        while ( i < (mas.length - 1)) {
            if (mas[i] == mas[i+1]) {
                k++;
                if (i == (mas.length - 2)){
                    Out += Integer.toString(k) + Character.toString(mas[i+1]);
                }
            }
            else{
                Out += Integer.toString(k) + Character.toString(mas[i]);
                k = 1;
                if (i == (mas.length - 2)){
                    Out += Integer.toString(k) + Character.toString(mas[i+1]);
                }
            }
            i++;
        }
        System.out.println(Out);
    }
}