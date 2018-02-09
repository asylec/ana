package com.company;
import java.util.Scanner;

public class Main {
    public static int input(String text) { // Проверка на корректность ввода переменных
        System.out.print(text);
        boolean fl = true;
        int num = 0;
        Scanner scn = new Scanner(System.in);
        while (fl) {
            try {
                num = scn.nextInt();
                fl = false;
                break;
            } catch (Exception e) {
                System.out.print(" Ошибка значения. Введите еще раз: ");
                scn.next();
            }
        }
        return num;
    }

    public static int[] noDubs(int mas[]) {
        boolean mas1[] = new boolean[mas.length];
        int removeCount = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!mas1[i]) {
                int tmp = mas[i];
                for (int j = i + 1; j < mas.length; j++) {
                    if (tmp == mas[j]) {
                        mas1[j] = true;
                        removeCount++;
                    }
                }
            }
        }
        int[] result = new int[mas.length - removeCount];
        for (int i = 0, j = 0; i < mas.length; i++) {
            if (!mas1[i]) {
                result[j++] = mas[i];
            }
        }
        return result;
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
        int k = input("Введите какой по величине элемент найти: "); // Читаем с клавиатуры размер массива
        if (k <= 0){ // Проверка корректности длины массива
            do {
                k = input(" Ошибка значения. Введите еще раз: ");
            } while (k <= 0);
        }
        System.out.print ("Введенный массив:");
        for (i = 0; i < n; i++) {
            System.out.print (" " + mas[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
        int m;
        mas = noDubs(mas);
        boolean fl = false;
        for (i = 0; i < mas.length; i++) { // Поиск удаляемого элемента
            m = 1;
            for (int j = 0; j < mas.length; j++) { // Поиск удаляемого элемента
                if (mas[i] < mas[j]){
                    m++;
                }
            }
            if (m == k){
                System.out.print (k + "й по величине элемент: " + mas[i]);
                fl = true;
                break;
            }
            else {
                fl = false;
            }
        }
        if (!fl){
            System.out.print ("В массиве нет " + k + "ого по величине элемента");
        }
        System.out.println();
    }
}