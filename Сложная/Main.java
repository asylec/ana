package com.company;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> pr(ArrayList<Integer> mas2, char[] mas1){ //Преобразование массива символов в динамический массив чисел
        String K = "";
        for (int l = 0; l < mas1.length; l++) {
            if (l ==  (mas1.length - 1)){       //Проверяем оследнего элемента
                if (Character.isWhitespace(mas1[l])){    //Проверяем является ли текущий символ пробелом
                    mas2.add(Integer.valueOf(K));   //Если пробел, то записываем в mas2 предыдущее значение К
                }
                else{ //Иначе
                    K += mas1[l];   // Сначала добавляем число
                    mas2.add(Integer.valueOf(K));    // Записываем в массив
                }
            }
            else {
                if (Character.isWhitespace(mas1[l])){  //Если текущий элемент пробел переходим к следующему
                    continue;
                }
                if (Character.isWhitespace(mas1[l + 1])) { // Проверка является ли пробелом след символ
                    K += mas1[l];           // Сначала добавляем число
                    mas2.add(Integer.valueOf(K));   // Записываем в массив
                    K = "";  // Обнуляем для последующих символов
                } else {
                    K += mas1[l];   //Добавляем число
                }
            }
        }
        return mas2;
    }

    public static int fAkkerman(int m, int n) { // Функция Аккермана
        if (m == 0) {
            return n + 1;
        } else {
            if (n > 0) {
                return fAkkerman(m - 1, fAkkerman(m, n - 1));
            } else {
                return fAkkerman(m - 1, 1);
            }
        }
    }

    public static String Akkerman(String str){
        str = str.substring(4); //Удаляем из строки первые 4 символа "ACK "
        String V = "";
        char[] mas1 = str.toCharArray();        // Строку в массив символов
        ArrayList<Integer> mas2 = new ArrayList<>(); // Динамический массив для ARG1, ARG2 ...
        mas2 = pr(mas2, mas1);
        // Проверка сколько чисел было в файле в строке
        if ((mas2.size() % 2 == 1)){ //Если введено нечетное число чисел удаляем 1 с конца, т.к. функцию Аккермана
            mas2.remove(mas2.size()-1);  //будем искать для n последовательно расположенных пар чисел
        }
        for (int i = 0; i < mas2.size(); i += 2) {
            V += fAkkerman(mas2.get(i), mas2.get(i + 1)) + " "; //Вычисление функции Аккермана
        }
        return V;
    }

    public static String factorial(String str){ //Функция поиска факториала числа
        str = str.substring(2); //Удаляем из строки первые 4 символа "F "
        String V = "";
        //Преобразование строки в массив чисел аналогично преобразованию в поиске функции Аккермана
        char[] mas1 = str.toCharArray(); // Строку в массив символов
        ArrayList<Integer> mas2 = new ArrayList<>();  // Динамический массив для ARG1, ARG2 ...
        mas2 = pr(mas2,mas1);
        for (int i = 0; i < mas2.size(); i++){ //вычисление факториала
            int y = 1;
            int n = mas2.get(i);
            for (int j = 1; j <= n; j++){
                y = y * j;
            }
            V += y + " ";
        }
        return V;
    }

    public static int fFib(int n) { // Функция поиска n числа в последовательности Фибоначчи
        int a = 1, b = 1;
        int fib = 2, i = 2;
        while (i < n) {
            fib = a + b;
            a = b;
            b = fib;
            i++;
        }
        return fib;
    }

    public static String fibon(String str){
        str = str.substring(4);
        String V = "";
        char[] mas1 = str.toCharArray(); // Строку в массив символов
        ArrayList<Integer> mas2 = new ArrayList<>();
        mas2 = pr(mas2, mas1);
        for (int i = 0; i < mas2.size(); i++){
            V += fFib(mas2.get(i)) + " ";
        }
        return V;
    }

    public static void main(String[] args) {
        String V ;
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите путь к файлу с данными: ");
        String s = scn.nextLine();
        File fin = new File(s);
        if(!(fin.exists() && fin.isFile())) { //Проверка наличия файла
            do {
                System.out.println("Файл не найден, введите путь еще раз: ");
                s = scn.nextLine();
                fin = new File(s);
            } while (!(fin.exists() && fin.isFile()));
        }
        System.out.println("Введите путь и название файла, в который будут выведены результаты: ");
        String s0 = scn.nextLine();
        OutputStream fout = null;
        try {
            String lineSeparator = System.getProperty("line.separator");
            fout = new FileOutputStream(new File(s0));
            Scanner scan = new Scanner(fin);
            ArrayList<String> mas = new ArrayList<>();
            while (scan.hasNextLine()) {      //Считывание исходного файла
                mas.add(scan.nextLine());
            }
            int k1;
            for (int i = 0; i < mas.size(); i++ ) {
                if(mas.get(i).contains("ACK ")){
                    k1 = i + 1;
                    V = k1 + ": " + Akkerman(mas.get(i)) + lineSeparator ;
                    fout.write(V.getBytes(), 0, V.length());
                }
                if(mas.get(i).contains("F ")){
                    k1 = i + 1;
                    V = k1 + ": " + factorial(mas.get(i)) + lineSeparator ;
                    fout.write(V.getBytes(), 0, V.length());
                }
                if(mas.get(i).contains("FIB ")){
                    k1 = i + 1;
                    V = k1 + ": " + fibon(mas.get(i)) + lineSeparator ;
                    fout.write(V.getBytes(), 0, V.length());
                }
            }
            System.out.println("Запись результата выполнена в файл: " + s0);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}