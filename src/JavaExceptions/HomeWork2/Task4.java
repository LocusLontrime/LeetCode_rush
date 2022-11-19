package JavaExceptions.HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {

    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static void main(String[] args) throws Throwable {

        stringReader();
    }

    public static void stringReader() throws Throwable {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            if (str.equals("")) {
                // System.out.println("You cannot enter an empty string!");
                throw new Exception("You cannot enter an empty string!");
            }

        } catch(IOException e) {

            System.out.println("Good luck!");
        }
    }
}
