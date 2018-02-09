
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
        if ((x < 3) || (x == 4)){
            System.out.println("Не удалось разбить");
        }
        else {
            System.out.println("Разбиение по 3, 5, 7 коп");
            System.out.println("\t\t3 коп.\t5 коп.\t7 коп.");
            int n1 = x / 3;
            int n2 = x / 5;
            int n3 = x / 7;
            for (int i=0; i <= n1; i++){
                for (int j=0; j <= n2; j++){
                    for (int k=0; k <= n3; k++){
                        if (3*i + 5*j + 7*k == x){
                            System.out.println("Монеты: \t" + i + "\t\t" + j + "\t\t" + k );
                        }

                    }
                }
            }
            System.out.println();
            if (x == 7){
                System.out.println("Не удалось разбить по 3, 5 коп");
            }
            else {
                System.out.println("Разбиение по 3, 5 коп");
                System.out.println("\t\t3 коп.\t5 коп.");
                for (int i = 0; i <= n1; i++) {
                    for (int j = 0; j <= n2; j++) {
                        if (3 * i + 5 * j == x) {
                            System.out.println("Монеты: \t" + i + "\t\t" + j);
                        }
                    }
                }
            }
        }
    }
}