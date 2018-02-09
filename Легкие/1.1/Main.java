package com.company;
import java.util.Scanner;

public class Main {
    public static int input(String text){ // Проверка на корректность ввода переменных
        System.out.print(text);
        boolean fl = true;
        int num = 0;
        Scanner scn = new Scanner(System.in);
        while(fl){
            try{
                num = scn.nextInt();
                fl = false;
                break;
            } catch(Exception e){
                System.out.print(" Ошибка значения. Введите еще раз: ");
                scn.next();
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int i;
        int n = input("Введите длину массива: "); // Читаем с клавиатуры размер массива
        if (n <= 0){ // Проверка корректности длины массива
            do {
                n = input(" Ошибка значения. Введите еще раз: ");
            } while (n <= 0);
        }
        int mas[] = new int[n]; // Создаём массив int размером n
        System.out.println("Введите элементы массива:");
        for (i = 0; i < n; i++) {
            mas[i] = input("Введите " + i +" элемент массива: "); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print ("Введенный массив:");
        for (i = 0; i < n; i++) {
            System.out.print (" " + mas[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
        if (n == 1){ // Проверка длины массива, необходима для корректного решения поставленной задачи
            System.out.println("Массив состоит из одного элемента, поиск 2-го по величине элемента невозможен");
        }
        else {
            int m;
            boolean fl = false;
            for (i = 0; i < n; i++) {
                m = 1;
                for (int j = 0; j < n; j++) {
                    if (mas[i] < mas[j]){
                        m++;
                    }
                }
                if (m == 2){
                    System.out.print (2 + "й по величине элемент: " + mas[i]);
                    fl = true;
                    break;
                }
                else {
                    fl = false;
                }
            }
            if (!fl){
                System.out.print ("Массив состоит из одинаковых элементов");
            }
            System.out.println();
        }
    }
}

