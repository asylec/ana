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
        int x = input("Введите число: "); // Читаем с клавиатуры число
        if (x <= 0){ // Проверка корректности числа
            do {
                x = input(" Ошибка значения. Введите еще раз: ");
            } while (x <= 0);
        }
        System.out.println("Введенное значение: " + x);
        System.out.print("Простые множители: 1 ");
        double sqrt = Math.sqrt(x);  // Вычисленеи квадрата числа
        int y = 2;
        while (x > 1 && y <= sqrt) {
            if (x % y == 0) {  // Проверка остатка от деления
                System.out.print(y + " "); // Вывод если поделилось без остатка
                x /= y;
            }
            else if (y == 2) { // Проверяем 3
                y++;
            }
            else {
                y += 2; // Проверяются только нечетные элементы
            }
        }
        if (x != 1) { // Вывод последнего множителя
            System.out.print(x);
        }
    }
}
