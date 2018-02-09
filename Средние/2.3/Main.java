
package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String In = scn.nextLine();
        String Out = "";
        String num = "";
        char[] mas = In.toCharArray(); // Строку в массив символов
        for(int i = 0; i < mas.length; i++){
            if (Character.isDigit(mas[i])) { // Проверка является ли цифрой
                num += mas[i];
            }
            else{
                for(int j = 0; j < Integer.parseInt(num); j++){
                    Out += mas[i];
                }
                num = "";
            }
        }
        System.out.println(Out);
    }
}