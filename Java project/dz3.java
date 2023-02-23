import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

import javax.management.ObjectName;

public class dz3 {

    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("Красный");
        list.add("Желтый");
        list.add("Зеленый");
        list.add("Черный");
        list.add("Белый");
        list.add("Синий");
        list.add("Оранжевый");
        System.out.print("1. Изначальный список: ");
        showArray(list);
        
        for (int i = 0; i < list.size(); i++) {
            StringBuilder l = new StringBuilder();
            l.append(list.get(i).toString()).append("!");
            list.set(i, l.toString());
        }
        System.out.print("2. К каждому элементу добавили '!': ");
        showArray(list);

        System.out.print("Введите новый элемент: ");
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner scanner = new Scanner(System.in, encoding);
        String s = scanner.nextLine();
        list.add(0, s);
        System.out.print("3. Добавили элемент в начало списка: ");
        showArray(list);

        
        System.out.print(String.format("4. Укажите индекс элемента списка от 0 до %d для его отображения: ", list.size()-1));
        s = scanner.nextLine();
        int el = Integer.parseInt(s);
        if (el >= list.size()) System.out.println("Введен неверный индекс");
        else System.out.println(String.format("Элемент списка под индексом %d: %s", el, list.get(el)));

        System.out.print(String.format("5. Укажите индекс элемента списка от 0 до %d для его обновления: ", list.size()-1));
        s = scanner.nextLine();
        el = Integer.parseInt(s);
        if (el >= list.size()) System.out.println("Введен неверный индекс");
        else {System.out.print(String.format("[%d]: Введите новое значение данного элемента: ", el));
        s = scanner.nextLine();
        list.set(el, s);
        System.out.println("Обновленный список: ");
        showArray(list);
        }
        
        System.out.println("6. Удаление 3 элемента списка: ");
        list.remove(3);
        showArray(list);

        System.out.print("7. Введите значение элемента для поиска в списке: ");
        s = scanner.nextLine();
        if (list.indexOf(s) >= 0) {
            System.out.println("Такой элемент есть под индексом " + list.indexOf(s));
        }
        else System.out.println("Такого элемента нет");

        ArrayList<String> listNew = new ArrayList<String>();
        listNew = selectSomeItems(list);
        System.out.print("8. Создали новый список и добавили в него несколько элементов: ");
        showArray(listNew);

        System.out.println("9. Удалили все элементы, отсутствующие в новом списке: ");
        list.retainAll(listNew);
        showArray(list);

        System.out.println("10. Сортировка списка по алфавиту: ");
        Collections.sort(list);
        showArray(list);

        System.out.println("10. Сравнение время работы тысячи повторений пункта 3 для ArrayList и LinkedList.");
        ArrayList<String> list1 = new ArrayList<String>();
        var start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list1.add("Белый");
        }
        var stop1 = System.currentTimeMillis();
        System.out.print("Время выполнения ArrayList: "); 
        System.out.println(stop1 - start1);

        LinkedList<String> list2 = new LinkedList<>();
        start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list2.add("Белый");
        }
        stop1 = System.currentTimeMillis();
        System.out.print("Время выполнения LinkedList: "); 
        System.out.println(stop1 - start1);
        
    }
    static void showArray(ArrayList<String> list){
        for(String j: list){
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static ArrayList<String> selectSomeItems (ArrayList<String> listFull){
        ArrayList<String> listFill = new ArrayList<String>();
        Random random = new Random();
        for (String el : listFull) {
            int k = new Random().nextInt(2);
            if (k == 1) listFill.add(el);
        }
        return listFill;
    }
        
}

