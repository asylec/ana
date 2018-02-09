package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s1 = scn.nextLine();
        System.out.println("Введите подстроку: ");
        String s2 = scn.nextLine();
        char[] mas1 = s1.toCharArray(); // Строку в массив символов
        char[] mas2 = s2.toCharArray(); // Строку в массив символов
        if (mas1.length < mas2.length){
            System.out.println("Строка: '" + s1 + "' меньше чем введенная подстрока: '" + s2 + mas2.length + "'");
        }
        else {
            boolean fl;
            boolean fl2 = false;
            int k, j;
            for (int i = 0; i <= (mas1.length - mas2.length); i++) {
                if (mas1[i] == mas2[0]) {
                    fl = true;
                    k = i;
                    j = 0;
                    while (fl){
                        if (j < mas2.length && mas1[k] == mas2[j]){
                            k++;
                            j++;
                        }
                        else{
                            fl = false;
                        }
                    }
                    if (j == mas2.length ){
                        fl2 = true;
                        break;
                    }
                }
            }
            if (fl2) {
                System.out.println("Строка: '" + s1 + "' содержит подстроку: '" + s2 + "'");
            }
            else {
                System.out.println("Строка: '" + s1 + "' не содержит подстроку: '" + s2 + "'");
            }
        }
    }
}