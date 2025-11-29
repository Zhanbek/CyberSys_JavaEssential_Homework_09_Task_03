import model.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyDictionary<Client, Integer> myDictionary = new MyDictionary<>();

        Client firstClient  = new Client(123, "Sokolov", 56);
        int salary = 1200;
        myDictionary.put(firstClient, salary);

        Client secondClient  = new Client(124, "Vovk", 34);
        salary = 2200;
        myDictionary.put(secondClient, salary);

        Client thirdClient = new Client(125, "Disney", 45);
        salary = 9000;
        myDictionary.put(thirdClient, salary);

        Client fourthClient = new Client(126,  "Gates", 67);
        salary = 1000;
        myDictionary.put(fourthClient, salary);
        System.out.println();
        System.out.println("Словник містить наступні пари KEY-VALUE:");
        System.out.println("--------------------------------------------------------------");
        System.out.println(myDictionary);
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        int newSalary = 3200;
        System.out.println("Встановимо нове значення  зарплати: " + newSalary + " для існуючого ключа: " + secondClient);
        System.out.println();
        myDictionary.put(secondClient, newSalary);
        System.out.println("В результаті словник матиме наступний вигляд:");
        System.out.println("--------------------------------------------------------------");
        System.out.println(myDictionary);
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Для отримання значення вкажіть будь ласка Індекс словника: ");
        int index = sc.nextInt();
        try {
            System.out.println("Отримаємо ключ і значення словника для зазначеного індексу: " + index);
            System.out.println("--------------------------------------------------------------");
            Client foundKey = myDictionary.getKeyByIndex(index);
            System.out.println("Ключ словника для вказаного індексу дорівнює: " + foundKey);
            int foundValue = myDictionary.getValueByIndex(index);
            System.out.println("Значення словника для вказаного індексу дорівнює: " + foundValue);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println();
        System.out.println("Отримаємо значення словника по ключу: " + thirdClient);
        System.out.println("--------------------------------------------------------------");
        int foundValueForKey = myDictionary.getValueByKey(thirdClient);
        System.out.println("Для ключа " + thirdClient + " знайдено значення: " +  foundValueForKey);
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        sc.close();
    }
}