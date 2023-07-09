package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {// Создаем класс "User" для представления пользователя
    private String fullName; // Полное имя пользователя
    private int age; // Возраст пользователя
    private String gender; // Пол пользователя

    public User(String fullName, int age, String gender) { // Конструктор класса User
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {// Геттер для получения полного имени пользователя
        return fullName;
    }

    public int getAge() {// Геттер для получения возраста пользователя
        return age;
    }

    public String getGender() {// Геттер для получения пола пользователя
        return gender;
    }

    @Override
    public String toString() {// Переопределение метода toString для вывода информации о пользователе в удобочитаемом формате
        return fullName + " " + getInitials() + " " + age + " " + gender;
    }

    private String getInitials() {// Метод для получения инициалов пользователя
        String[] names = fullName.split(" ");// Разделяем полное имя на отдельные слова
        StringBuilder initials = new StringBuilder();// Создаем StringBuilder для хранения инициалов
        for (String name : names) {// Проходимся по каждому слову в имени
            initials.append(name.charAt(0)).append(".");// Добавляем первую букву слова и символ точки к инициалам
        }
        return initials.toString();// Возвращаем полученные инициалы
    }
}

public class UserManagementSystem {// Главный класс "UserManagementSystem" для управления пользователями
    private List<User> users;// Создаем список пользователей

    public UserManagementSystem() {// Конструктор класса UserManagementSystem
        users = new ArrayList<>();// Инициализируем список пользователей как пустой ArrayList
    }

    public void addUser(User user) { // Метод для добавления нового пользователя в список
        users.add(user);
    }

    public List<User> getUsers() {// Метод для получения списка пользователей
        return users;
    }

    public void printUsers() {// Метод для вывода всех пользователей
        for (User user : users) {
            System.out.println(user.toString());// Вывод информации о каждом пользователе с помощью метода toString
        }
    }

    public void sortByAge() {// Метод для сортировки пользователей по возрасту
        Collections.sort(users, Comparator.comparingInt(User::getAge));// Сортировка списка пользователей по возрасту
    }

    public void sortByAgeAndGender() {// Метод для сортировки пользователей по возрасту и полу
        Collections.sort(users, Comparator.comparing(User::getGender).thenComparingInt(User::getAge));// Сортировка списка пользователей по возрасту и полу
    }

    public static void main(String[] args) { // Метод для запуска программы
        UserManagementSystem system = new UserManagementSystem();// Создаем экземпляр класса UserManagementSystem

        // Добавление пользователей
        system.addUser(new User("Иванов Иван Иванович", 30, "М"));
        system.addUser(new User("Петров Петр Петрович", 25, "М"));
        system.addUser(new User("Сидорова Анна Ивановна", 35, "Ж"));

        // Вывод пользователей
        System.out.println("Список пользователей:");
        system.printUsers();

        // Сортировка по возрасту
        System.out.println("\nСписок пользователей, отсортированный по возрасту:");
        system.sortByAge();
        system.printUsers();

        // Сортировка по возрасту и полу
        System.out.println("\nСписок пользователей, отсортированный по возрасту и полу:");
        system.sortByAgeAndGender();
        system.printUsers();
    }
}
