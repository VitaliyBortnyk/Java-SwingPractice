package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {

    public static void Menu()
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<Material> materials = new ArrayList<Material>();
        int menu;
        boolean exit = false;

        while(!exit)
        {
            System.out.print("""
                    Меню:
                    1 - Додати елемент
                    2 - Продемонстувати всі елементи
                    3 - Моє завдання
                    4 - Видалити елемент
                    5 - Редагувати елемент
                    6 - Завантажити з файла
                    7 - Зберегти в файл
                    8 - Відсортувати
                    9 - Вихід

                    Виберіть пункт меню:\s""");
            menu = sc.nextInt();

            switch (menu)
            {
                case 1:
                {
                    Material material = new Material();
                    material.Input();
                    materials.add(material);
                    break;
                }
                case 2:
                {
                    System.out.printf("№\t%-20s\t %-20s\t %-15s\t %-15s\t %-15s %-15s\t %-20s%n",
                            "Назва матеріалу", "Постачальник", "Одиниця виміру", "Дата покупки", "Кількість", "Ціна за одиницю", "Загальна сума");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

                    for (int i = 0; i < materials.size(); i++) {
                        System.out.print((i+1) + "\t");
                        materials.get(i).Show();
                    }

                    break;
                }
                case 3:
                {
                    Individual(materials);
                    break;
                }
                case 4:
                {
                    System.out.print("Введіть номер матеріала по списку для видалення: ");
                    int index = sc.nextInt();

                    if (index < 1 || index > materials.size())
                        System.out.println("Такого елемента не існує");
                    else {
                        for (Material material : materials)
                            if (materials.indexOf(material) == (index - 1)) {
                                materials.remove(material);
                                break;
                            }
                    }
                    break;
                }
                case 5:
                {
                    System.out.print("Введіть номер матеріала по списку для редагування: ");
                    int index = sc.nextInt();

                    if (index < 1 || index > materials.size())
                        System.out.println("Такого елемента не існує");
                    else
                    {
                        for (Material material : materials)
                            if (materials.indexOf(material) == (index - 1))
                                material.Input();
                    }
                    break;
                }
                case 6:
                {
                    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("materials.dat")))
                    {
                        materials =(ArrayList<Material>) ois.readObject();
                    }
                    catch(Exception ex){ System.out.println(ex.getMessage()); }
                    break;

                }
                case 7:
                {
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("materials.dat")))
                    {
                        oos.writeObject(materials);
                    }
                    catch(Exception ex){ System.out.println(ex.getMessage()); }
                    break;
                }
                case 8:
                {
                    Collections.sort(materials);
                    break;
                }
                case 9:
                {
                    exit = true;
                    break;
                }
                default: break;
            }
        }
    }

    public static void Individual(List<Material> materials)
    {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int  previousMonth = month == 1? 12 : month - 1;
        int count = 0;
        double totalCost = 0;
        String provider = "";
        ArrayList<String> list = new ArrayList<String>();

        for(Material material : materials) {
            for(Material theSame : materials) {
                    if (material.getProvider().equals(theSame.getProvider())) {
                        count++;
                        if (count > 1) {
                            provider = theSame.getProvider();
                        }
                    }
                }
        }

        for(Material material : materials)
            if(material.getProvider().equals(provider) && material.getMonth() == previousMonth)
                list.add(material.getName());

        for(Material material : materials)
            if(material.getProvider().equals(provider))
                totalCost += material.getCost();

            if(list.size() == 0)
                System.out.println("Товарів придбаних за попередній місяць у одного і того ж постачальника немає");
            else {
                System.out.println("Товари придбані у постачальника \"" + provider + "\" за попередній місяць:");
                for (String element : list)
                    System.out.println(element);

                System.out.println("Загальна вартість придбаних матеріалів у \"" + provider + "\" : " + totalCost);
            }
    }

    public static void main(String[] args) {
        Menu();
    }
}
