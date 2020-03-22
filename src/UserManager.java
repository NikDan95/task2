

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserManager {

    public static Scanner scanner = new Scanner(System.in);
    public static List<User> users = new ArrayList<>();


    public static void add(List<User> users, User user) {
        users.add(user);
    }


    public static void add() {
        System.out.print(" name: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("surName: ");
        String surName = scanner.next();
        System.out.println();
        int age = 0;
        while (true) {
            System.out.print("age: ");
            try {
                age = Integer.parseInt(scanner.next());
                if (age <= 0 || age >= 100) {
                    throw new IllegalArgumentException();
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("please try again. Age must be betwean 0-100");
            }
        }
        users.add(new User(name, surName, age));
    }

    public static void remove() throws IndexOutOfBoundsException {
        int index=0;
        try {
            System.out.print("input index of element, what you want to remove - ");
            index =Integer.parseInt(scanner.next());
            System.out.println(users.remove(index).toString()+" was removed!");
        }

        catch (NumberFormatException | NoSuchElementException|IndexOutOfBoundsException  e){
            System.out.println("there are no such element!");
            Main.commandsControl();
        }
    }

    public static void list() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public static boolean exit(BufferedWriter writer) throws IOException {

        for (User user:users){
            writer.write(user.toString());
            writer.newLine();
        }
        writer.close();
        return false;

    }
}
