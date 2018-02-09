package com.company;
import java.util.Scanner;

public class Main {
    public static Boolean palindrom(String A) {
        String K = "";
        String B = "";
        char[] mas1 = A.toCharArray(); // Строку в массив символов
        for (int l = 0; l < mas1.length; l++) {
            if (Character.isLetterOrDigit(mas1[l])) { // Проверка является ли буквой или цифрой
                K += mas1[l];
            }
        }
        char[] mass = K.toCharArray();
        char[] mass2 = new char[mass.length];
        for (int i = mass.length - 1; i >= 0;) {
            for (int j = 0; j < mass2.length; j++) {
                mass2[j] = mass[i];   // Сравнивание строк
                i--;
                B += mass2[j];
            }
        }
        return B.equalsIgnoreCase(K);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s1 = scn.nextLine();
        boolean fl = palindrom(s1);
        if (fl){
            System.out.println("Строка палиндром");
        }
        else{
            System.out.println("Строка не палиндром");
        }
    }
}